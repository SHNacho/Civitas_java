/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

import java.util.Collections;

import GUI.Dado;
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

        if (nombres.size()<=4){
            for (int i=0; i < nombres.size(); i++)
                jugadores.add(new Jugador(nombres.get(i)));
        }
        
        gestorEstados = new GestorEstados();
        estado = gestorEstados.estadoInicial();
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        mazo = new MazoSorpresas(true);
        tablero = new Tablero (5);
        inicializarMazoSorpresas (tablero);        
        inicializarTablero(mazo);
    }
    
    public void actualizarInfo(){
        
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
        CasillaCalle casilla = (CasillaCalle)tablero.getCasilla(numCasilla);
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
            i++;
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
    
    public boolean hipotecar(int ip){
        return (jugadores.get(indiceJugadorActual).hipotecar(ip));
    }

    
    public String infoJugadorTexto(){
        String info = jugadores.get(indiceJugadorActual).toString();
        /*String info = ("Nombre: " + jugadores.get(indiceJugadorActual).getNombre() +
             " Casilla: " + Integer.toString(jugadores.get(indiceJugadorActual).getNumCasillaActual()) + "Saldo: "+   
              Float.toString(jugadores.get(indiceJugadorActual).getSaldo()));
        */
        return info;
    }
    
    public boolean salirCarcelPagando(){
        return (jugadores.get(indiceJugadorActual).salirCarcelPagando());
    }
    
    public boolean salirCarcelTirando(){
        return (jugadores.get(indiceJugadorActual).salirCarcelTirando());
    }
    
    public OperacionesJuego siguientePaso(){
        Jugador jugadorActual = jugadores.get(indiceJugadorActual);
        
        OperacionesJuego operacion = gestorEstados.operacionesPermitidas(jugadorActual, estado);
        
        if (operacion == OperacionesJuego.PASAR_TURNO){
            this.pasarTurno();
            this.siguientePasoCompletado(operacion);
        }
        
        if (operacion==OperacionesJuego.AVANZAR){
            this.avanzaJugador();
            this.siguientePasoCompletado(operacion);
        }
        return operacion;
    }
    
    public void siguientePasoCompletado(OperacionesJuego operacion){
        
        estado = gestorEstados.siguienteEstado (jugadores.get(indiceJugadorActual), estado ,operacion);
    }
    
    public boolean vender(int ip){
        return (jugadores.get(indiceJugadorActual).vender(ip));
    }
    
    private void contabilizarPasosPorSalida(Jugador jugadorActual){
        
        while (tablero.getPorSalida()>0)
            jugadorActual.pasaPorSalida();
    }
    
    private void inicializarMazoSorpresas(Tablero tablero){
        mazo.alMazo(new SorpresaIrCasilla(tablero, 14, "Ve a la casilla 14"));
        mazo.alMazo(new SorpresaConvertirJugador(200, "Convertir Jugador"));
        mazo.alMazo(new SorpresaIrCarcel(tablero));
        mazo.alMazo(new SorpresaIrCasilla(tablero, 3, "Ve a la casilla 3"));
        
        mazo.alMazo(new SorpresaPorCasaHotel(50, "Cobra 50 por cada propiedad"));
        mazo.alMazo(new SorpresaPagarCobrar(200, "Cobra 200"));
        mazo.alMazo(new SorpresaPagarCobrar(-200, "Paga 200"));
        mazo.alMazo(new SorpresaPorCasaHotel(-50, "Paga 50 por cada propiedad"));
        mazo.alMazo(new SorpresaSalirCarcel(mazo));
        mazo.alMazo(new SorpresaPorJugador(50, "Recibe 50 de cada jugador"));
        mazo.alMazo(new SorpresaPorCasaHotel(-50, "Paga 50 a cada jugador"));
        
    }
    
    private void inicializarTablero(MazoSorpresas mazo){
        // Salida ya se añade en la posición 0

        // Añadimos en la posición 1 la calle 1
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 1", 100, 0.05f, 200, 400, 300)));
        tablero.añadeCasilla(new CasillaSorpresa(mazo, "Sorpresa 1"));

        // Añadimos en la posición 2 la casilla impuesto
        tablero.añadeCasilla(new CasillaImpuesto(300f, "Impuesto"));
        // Añadimos en la posición 3 la calle 2
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 2", 225, 0.075f, 450, 900, 675)));
        // Añadimos en la posición 4 la calle 3
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 3", 150, 0.05f, 300, 600, 450)));
        // En la posición 5 ya está la cárcel
        // Añadimos en la posición 6 la calle 4
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 4", 300, 0.075f, 600, 1200, 900)));
        // Añadimos en la posición 7 la sorpresa 1
        // Añadimos en la posición 8 la calle 5
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 5", 125, 0.05f, 250, 500, 375)));
        // Añadimos en la posición 9 la calle 6
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 6", 200, 0.05f, 400, 800, 600)));
        // Añadimos en la posición 10 el parking
        tablero.añadeCasilla(new Casilla("Parking"));
        // Añadimos en la posición 11 la calle 7
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 7", 400, 0.1f, 800, 1600, 1200)));
        // Añadimos en la posición 12 la calle 8
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 8", 250, 0.075f, 500, 1000, 750)));
        // Añadimos en la posición 13 la sorpresa 2
        tablero.añadeCasilla(new CasillaSorpresa(mazo, "Sorpresa 2"));
        
        // Añadimos en la posición 14 la calle 9
        
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 9", 175, 0.05f, 350, 700, 525)));
        
        // Añadimos en la posición 15 el juez
        
        tablero.añadeJuez();
        
        // Añadimos en la posición 16 la calle 10
        
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 10", 200, 0.05f, 400, 800, 600)));
        
        // Añadimos en la posición 17 la calle 11
        
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 11", 350, 0.1f, 700, 1400, 1050)));
        
        // Añadimos en la posición 18 la calle 12
        
        tablero.añadeCasilla(new CasillaCalle(new TituloPropiedad("Calle 12", 300, 0.075f, 600, 1200, 900)));
        
        // Añadimos en la posición 19 la sorpresa 3
        
        tablero.añadeCasilla(new CasillaSorpresa(mazo, "Sorpresa3"));
    
    // Añadimos casillas más adelante
    }
    
    private void pasarTurno(){
        
         indiceJugadorActual = (indiceJugadorActual + 1) % jugadores.size();
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
