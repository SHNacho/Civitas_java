/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

import java.util.Collections;
/**
 *
 * @author juliocamposrodriguez
 */
public class CivitasJuego {
    
    private int indiceJugadorActual;
    
    private MazoSorpresas mazo;
    
    private Tablero tablero;
    
    private ArrayList<Jugador> jugadores;
    
    EstadosJuego estado;
    
    GestorEstados gestorEstados;
    
    public CivitasJuego (ArrayList<String> nombres){               // 4 nombres
        jugadores = new ArrayList<>();
        gestorEstados = new GestorEstados();

        if (nombres.size()<=4){
            for (int i=0; i < nombres.size(); i++)
                jugadores.add(new Jugador(nombres.get(i)));
        }
                
        gestorEstados.estadoInicial();
        estado = gestorEstados.estadoInicial();
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        mazo = new MazoSorpresas();
        tablero = new Tablero(4);
        inicializarMazoSorpresas (tablero);        
        inicializarTablero(mazo);
    }
    
    void actualizarInfo(){
        
        System.out.println(jugadores.get(indiceJugadorActual).toString());
        
        if (finalDelJuego()){
            ArrayList<Jugador> rank = ranking();  
            
            System.out.println ("EL RANKING ES EL SIGUIENTE: ");
            
            for (int i = 0; i < rank.size(); i++)
                System.out.println (rank.get(i).getNombre() + " con un saldo de "+ rank.get(i).getSaldo());
        }     
    }
    
    
    public boolean cancelarHipoteca (int ip){
        return (jugadores.get(indiceJugadorActual).cancelarHipoteca(ip));
    }
    
    public boolean comprar(){
        Jugador jugadorActual = jugadores.get(indiceJugadorActual);
        int numCasilla = jugadorActual.getNumCasillaActual();
        Casilla casilla = tablero.getCasilla(numCasilla);
        TituloPropiedad titulo = casilla.getTituloPropiedad();
        boolean res = jugadorActual.comprar(titulo);
        return res;
    }
    
    public boolean construirCasa (int ip){
        return (jugadores.get(indiceJugadorActual).construirCasa(ip));
    }
    
    public boolean construirHotel(int ip){
        return (jugadores.get(indiceJugadorActual).construirHotel(ip));
    }

    
    public boolean finalDelJuego(){
        boolean bancarrota = false;
        
        int i = 0;
        while (!bancarrota && (i < jugadores.size())) {
            if (jugadores.get(i).enBancarrota())
                bancarrota = true;
        }        

        return bancarrota;
    }
    
    public Casilla getCasillaActual(){
        int casillaActual = jugadores.get(indiceJugadorActual).getNumCasillaActual();
        
        return (tablero.getCasilla(casillaActual));
    }
    
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    
    /*public boolean hipotecar(int ip){
        return (jugadores.get(indiceJugadorActual).hipotecar(ip));
    }
*/
    
    public String infoJugadorTexto(){
        String info = ("Nombre: " + jugadores.get(indiceJugadorActual).getNombre() +
             " Casilla: " + Integer.toString(jugadores.get(indiceJugadorActual).getNumCasillaActual()) + "Saldo: "+   
              Float.toString(jugadores.get(indiceJugadorActual).getSaldo()));
        
        return info;
    }
    
    public boolean salirCarcelPagando(){
        return (jugadores.get(indiceJugadorActual).salirCarcelPagando());
    }
    
    public boolean salirCarcelTirando(){
        return (jugadores.get(indiceJugadorActual).salirCarcelTirando());
    }
    
    //public OperacionesJuego siguientePaso(){}
    
    public void siguientePasoCompletado(OperacionesJuego operacion){
        
        estado = gestorEstados.siguienteEstado (jugadores.get(indiceJugadorActual), estado ,operacion);
    }
    
    public boolean vender(int ip){
        return (jugadores.get(indiceJugadorActual).vender(ip));
    }
    
    private void contabilizarPasosPorSalida(Jugador jugadorActual){
        
        if (tablero.getPorSalida()>0)
            jugadorActual.pasaPorSalida();
    }
    
    private void inicializarMazoSorpresas(Tablero tablero){
        mazo = new MazoSorpresas();
        
        mazo.alMazo(new Sorpresa(TipoSorpresa.IRCARCEL, tablero));
        
        mazo.alMazo(new Sorpresa(TipoSorpresa.IRCASILLA, tablero,5,"A casilla 5"));
            
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, 10, "Por casa hotel"));
        
    }
    
    private void inicializarTablero(MazoSorpresas mazo){
        tablero = new Tablero(4);
        
        tablero.añadeJuez();
        
        tablero.añadeCasilla(new Casilla("Descanso"));
        
        tablero.añadeCasilla(new Casilla(200, "Impuesto"));
        
        tablero.añadeCasilla(new Casilla(mazo, "Sorpresa"));
        
        // Añadimos casillas más adelante
    }
    
    private void pasarTurno(){
        
        if (indiceJugadorActual== (jugadores.size()-1))
            indiceJugadorActual = 0;
        else
            indiceJugadorActual+=1;
    }
    
    private ArrayList<Jugador> ranking(){
        
        Collections.sort(jugadores);
        
        return jugadores;
    }

    private void avanzaJugador(){
        Jugador jugadorActual = jugadores.get(indiceJugadorActual);
        int posicionActual = jugadorActual.getNumCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);

        contabilizarPasosPorSalida(jugadorActual);
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);
        contabilizarPasosPorSalida(jugadorActual);
    }
}
