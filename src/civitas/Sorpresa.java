/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

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
    
    private void init(){
        valor = -1;
        mazo = null;
        tablero = null;
    }

    Sorpresa(TipoSorpresa tipo, Tablero tablero) {
        init();
        this.tipo = TipoSorpresa.IRCARCEL;
        texto = "Ir a la carcel";
    }
    
    Sorpresa(TipoSorpresa tipo, Tablero tablero, int valor, String texto){
        init();
        this.tipo = TipoSorpresa.IRCASILLA;
        this.valor = valor;
        this.texto = texto;
    }
    
    Sorpresa(TipoSorpresa tipo, int valor, String texto){       // Resto de sorpresas
        init();
        this.tipo = tipo;
        this.texto = texto;
        this.valor = valor;
    }
    
    Sorpresa(TipoSorpresa tipo, MazoSorpresas mazo){
        init();
        this.tipo= TipoSorpresa.SALIRCARCEL;
        texto = "Salir de la carcel";
    }
    
    public String toString(){
        
        String tp = tipo.toString ();
        
        return (tp);
    }
    
    void usada(){
      if (tipo ==TipoSorpresa.SALIRCARCEL)
            mazo.habilitarCartaEspecial(this);
    }
    
    void SalirdelMazo(){
        if (tipo ==TipoSorpresa.SALIRCARCEL)
            mazo.inhabilitarCartaEspecial(this);
    }
    
    public boolean jugadorCorrecto (int actual, ArrayList<Jugador> todos){
        boolean cmp = false;
        
        if (actual >=0 && actual < todos.size()){
            cmp = true;
        }
        
        return cmp;
    }
    
    private void informe(int actual, ArrayList<Jugador> todos){
        Diario diario = Diario.getInstance();
        
        if (jugadorCorrecto(actual, todos)){
            diario.ocurreEvento("Se aplica Sorpresa a "+todos[actual].getNombre());
        }   
    }
    
    private void aplicarAJugador_salirCarcel(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual,todos)){
            informe (actual,todos);
            
            boolean laTiene = false;
            
            for (int i = 0; i<todos.size(); i++){
                if (todos[i].tieneSalvoConducto())
                    laTiene = true;
            }
            
            if (!laTiene){
                todos[actual].obtenerSalvoConducto();
                SalirdelMazo();
            }
        }
    }
    
    private void aplicarAJugador_porJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual,todos)){
            
            informe (actual,todos);
            
            Sorpresa sorpresa = new Sorpresa(TipoSorpresa.PAGARCOBRAR,(valor*(-1)),"Pagarcobrar");
            
            for (int i = 0; i < todos.size(); i++){
                if (i != actual)
                    aplicarAJugador_pagarCobrar(i, todos);
            }
            
            Sorpresa sorpresa2 = new Sorpresa(TipoSorpresa.PAGARCOBRAR,(valor*(todos.size()-1)),"Pagarcobrar");
            
            aplicarAJugador_pagarCobrar(actual, todos);
    }
    
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos){
         if (jugadorCorrecto(actual, todos)){
             informe(actual, todos);
             
             float saldo = valor * todos[actual].getCasasPorHotel();
             
             todos[actual].modificarSaldo(saldo);
         }  
    }
    
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual, todos)){
            informe(actual,todos);
            
            todos[actual].modificarSaldo(valor);
        }
    }
    
    private void aplicarAJugador_irCarcel(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual,todos)){
           informe(actual, todos);
           int casilla = tablero.getCarcel();
           todos[actual].encarcelar(casilla);
        }
    }
    
    private void aplicarAJugador_irACasilla(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual,todos)){
            informe (actual, todos);
            int casillaActual = todos[actual].getNumCasillaActual();
            
            // Calculamos la tirada con el valor de sorpresa y con la casilla actual
            
            int tirada = tablero.calcularTirada(casillaActual, valor);
            
            int nuevaPos=tablero.nuevaPosicion(actual, tirada);
            
            todos[actual].moverACasilla(nuevaPos);
            
            Casilla casilla = tablero.getCasilla(valor);
            
            casilla.recibeJugador(actual,todos);
        }
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        
        if (jugadorCorrecto(actual, todos)){
            if (tipo == TipoSorpresa.IRCARCEL)
                aplicarAJugador_irCarcel(actual,todos);
            if (tipo == TipoSorpresa.IRCASILLA)
                aplicarAJugador_irACasilla(actual,todos);
            if (tipo == TipoSorpresa.PAGARCOBRAR)
                aplicarAJugador_pagarCobrar(actual,todos);
            if (tipo == TipoSorpresa.PORCASAHOTEL)
                aplicarAJugador_porCasaHotel(actual,todos);
            if (tipo == TipoSorpresa.PORJUGADOR)
                aplicarAJugador_irCarcel(actual,todos);
            if (tipo == TipoSorpresa.SALIRCARCEL)
                aplicarAJugador_salirCarcel(actual,todos);
        }  
    }

}
