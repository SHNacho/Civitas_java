/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;
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
    
    public CivitasJuego (ArrayList<String> nombres, int casillaCarcel){               // 4 nombres
        if (nombres.size()<=4){
            for (int i=0; i < nombres.size(); i++)
                jugadores[i] = new Jugador(nombres[i]);
        }
                
        gestorEstados.estadoInicial();
        
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        
        inicializarTablero(mazo, casillaCarcel);
        
        inicializarMazoSorpresas (tablero);
    }
    
    void actualizarInfo(){
        
        // Para mostrar en consola la información usaremos el System.out
        
        System.out.println ("El nombre del jugador actual es: " + jugadores[indiceJugadorActual].getNombre());
        
        System.out.println ("La casilla actual del jugador actual es: " + jugadores[indiceJugadorActual].getNumCasillaActual());
        
        System.out.println ("El saldo del jugador actual es: " + jugadores[indiceJugadorActual].getSaldo());
        
        System.out.println ("Tiene " + jugadores[indiceJugadorActual].getPropiedades().size()+ "propiedades.");
        
        boolean bancarrota = false;
        
        for (int i = 0; i < jugadores.size(); i++)
            if (jugadores[i].enBancarrota())
                bancarrota = true;
        
        if (bancarrota){
            ArrayList<Jugador> rank = ranking();  
            
            System.out.println ("EL RANKING ES EL SIGUIENTE: ");
            
            for (int i = 0; i < rank.size(); i++)
                System.out.println (rank[i].getNombre() + " con un saldo de "+ rank[i].getSaldo());
        }     
    }
    
    public boolean cancelarHipoteca (int ip){
        return (jugadores[indiceJugadorActual].cancelarHipoteca(ip));
    }
    
    public boolean comprar(){
        return false;
    }
    
    public boolean construirCasa (int ip){
        return (jugadores[indiceJugadorActual].construirCasa(ip));
    }
    
    public boolean construirHotel(int ip){
        return (jugadores[indiceJugadorActual].construirHotel(ip));
    }
    
    public boolean finalDelJuego(){
        boolean bancarrota = false;
        
        for (int i = 0; i < jugadores.size(); i++)
            if (jugadores[i].enBancarrota())
                bancarrota = true;
        
        return bancarrota;
    }
    
    public Casilla getCasillaActual(){
        return (jugadores[indiceJugadorActual].getNumCasillaActual());
    }
    
    public Jugador getJugadorActual(){
        return jugadores[indiceJugadorActual];
    }
    
    public boolean hipotecar(int ip){
        return (jugadores[indiceJugadorActual].hipotecar(ip));
    }
    
    public String infoJugadorTexto(){
        String info = ("Nombre: " + jugadores[indiceJugadorActual].getNombre() +
             " Casilla: " + jugadores[indiceJugadorActual].getNumCasillaActual() + "Saldo: "+   
              jugadores[indiceJugadorActual].getSaldo());
        
        return info;
    }
    
    public boolean salirCarcelPagando(){
        return (jugadores[indiceJugadorActual].salirCarcelPagando(ip));
    }
    
    public boolean salirCarcelTirando(){
        return (jugadores[indiceJugadorActual].salirCarcelTirando(ip));
    }
    
    public OperacionesJuego siguientePaso(){
        
    }
    
    public void siguientePasoCompletado(OperacionesJuego operacion){
        
        estado = siguienteEstado (jugadores[indiceJugadorActual], estado ,operacion);
    }
    
    public boolean vender(int ip){
        return (jugadores[indiceJugadorActual].vender(ip));
    }
    
    private void contabilizarPasosPorSalida(Jugador jugadorActual){
        
        if (tablero.getPorSalida()>0)
            jugadorActual.pasaPorSalida();
    }
    
    private void inicializarMazoSorpresas(Tablero tablero){
        MazoSorpresas mazito = new MazoSorpresas();
        
        mazo = mazito;
    }
    
    private void inicializarTablero(MazoSorpresas mazo, int casillaCarcel){
        Tablero tabla = new Tablero(casillaCarcel);
        tablero = tabla;
    }
    
    private void pasarTurno(){
        
        if (indiceJugadorActual== (jugadores.size()-1))
            indiceJugadorActual = 0;
        else
            indiceJugadorActual+=1;
    }
    
    private ArrayList<Jugador> ranking(){
        ArrayList.sort(jugadores);
        
        return jugadores;
    }

    private void avanzaJugador(){
        
    }
}
