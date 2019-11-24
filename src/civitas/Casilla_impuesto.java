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
public class Casilla_impuesto extends Casilla {
    
    private float importe;
    
    Casilla_impuesto(float cantidad, String nombre){
        super(nombre);
        importe = cantidad;
    }
    
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual,todos)){
            informe(actual, todos);
            todos.get(actual).pagaImpuesto(importe);
        }
    }
    
    @Override
    public String toString(){
        String str = "-----------------------------------\n" +
                     "CASILLA: \n" +
                     "Nombre:         " + this.getNombre() + "\n" +
                     "Tipo:           " + "Calle" + "\n";
        str+="Importe:        " + Float.toString(importe) + "\n";
        str += "-----------------------------------\n";

        return str;
    }
}
