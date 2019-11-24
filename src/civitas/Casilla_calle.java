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
public class Casilla_calle extends Casilla {
    
    private TituloPropiedad  tituloPropiedad;
    
    Casilla_calle(TituloPropiedad titulo){
        super(titulo.getNombre());
        tituloPropiedad = titulo;
    }
    
    TituloPropiedad getTituloPropiedad(){
        return tituloPropiedad;
    }
    
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        if(jugadorCorrecto(actual, todos)){
            informe(actual, todos);
            Jugador jugador = todos.get(actual);

            if(!tituloPropiedad.tienePropietario()){
                jugador.puedeComprarCasilla();
            }
            else{
                tituloPropiedad.tramitarAlquiler(jugador);
            }
        }
    }
    
    @Override
    public String toString(){
        String str = "-----------------------------------\n" +
                     "CASILLA: \n" +
                     "Nombre:         " + this.getNombre() + "\n" +
                     "Tipo:           " + "Calle" + "\n";
        str+= "Precio:        " + Float.toString(tituloPropiedad.getPrecioCompra()) + "\n";
        str += "-----------------------------------\n";

        return str;
    }
}
