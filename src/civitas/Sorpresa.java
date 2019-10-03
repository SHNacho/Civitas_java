/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author nacho
 */
public class Sorpresa{
    
    private String texto;
    
    private int valor;
    
    private TipoSorpresa tipo;
    
    private MazoSorpresas mazo;
    
    private Tablero tablero;

    Sorpresa(TipoSorpresa tipo, Tablero tablero) {
        
    }
    
    Sorpresa(TipoSorpresa tipo, Tablero tablero, int valor, String texto){
        
    }
    
    Sorpresa(TipoSorpresa tipo, int valor, String texto){
        
    }
    
    Sorpresa(TipoSorpresa tipo, MazoSorpresas mazo){
        
    }
    
    public String toString(){
        return null;
    }
    
    void usada(){
      
    }
    
    void SalirdelMazo(){
        
    }
    
    public boolean jugadorCorrecto (int actual, ArrayList<Jugador> todos){
        return false;
    }
    
    private void init(){
        
    }
    
    private void informe(int actual, ArrayList<Jugador> todos){
    
    }
    
    private void aplicarAJugador_salirCarcel(int actual, ArrayList<Jugador> todos){
        
    }
    
    private void aplicarAJugador_porJugador(int actual, ArrayList<Jugador> todos){
        
    }
    
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos){
        
    }
    
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
        
    }
    
    private void aplicarAJugador_irCarcel(int actual, ArrayList<Jugador> todos){
        
    }
    
    private void aplicarAJugador_irACasilla(int actual, ArrayList<Jugador> todos){
        
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        
    }

}
