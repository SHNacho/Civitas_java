/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author juliocamposrodriguez
 */
public class CivitasJuego {
    
    private int indiceJugadorActual;
    
    private MazoSorpresas mazo;
    
    private Tablero tablero;
    
    private Arraylist<Jugador> jugadores[4];
    
    EstadosJuego estado;
    
    GestorEstados gestorEstados;
    
    public CivitasJuego (String nombres){               // 4 nombres
        
    }
    
    public boolean cancelarHipoteca (int ip){
        return false;
    }
    
    public boolean comprar(){
        return false;
    }
    
    public boolean construirCasa (int ip){
        return false;
    }
    
    public boolean construirHotel(int ip){
        return false;
    }
    
    public boolean finalDelJuego(){
        return false;
    }
    
    public Casilla getCasillaActual(){
        
    }
    
    public Jugador getJugadorActual(){
        
    }
    
    public boolean hipotecar(int ip){
        return false;
    }
    
    public String infoJugadorTexto(){
        return "hola";
    }
    
    public boolean salirCarcelPagando(){
        return false;
    }
    
    public boolean salirCarcelTirando(){
        return false;
    }
    
    public OperacionesJuego siguientePaso(){
        
    }
    
    public void siguientePasoCompletado(OperacionesJuego operacion){
        
    }
    
    public boolean vender(int ip){
        return false;
    }
    
    private void contabilizarPasosPorSalida(Jugador jugadorActual){
        
    }
    
    private void inicializarMazoSorpresas(Tablero tablero){
        
    }
    
    private void inicializarTablero(MazoSorpresas mazo){
        
    }
    
    private void pasarTurno(){
        
    }
    
    private Arraylist<Jugador> ranking(){
        
    }

    private void avanzaJugador(){
        
    }
}
