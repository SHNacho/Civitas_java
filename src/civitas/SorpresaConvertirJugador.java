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
public class SorpresaConvertirJugador extends Sorpresa {
    
    private int valor;
    
    SorpresaConvertirJugador(int cantidad, String texto){
        super(texto);
        
        valor = cantidad;
    }
    
    @Override
    public String toString(){
        String str = "'Sorpresa convertir jugador: " + texto + "'";
        return str;
    }
    
    public void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        if (jugadorCorrecto(actual, todos)) {
            Jugador jugadorActual = todos.get(actual);
            informe(actual, todos);
            JugadorEspeculador jugadorEspeculador =
                new JugadorEspeculador(jugadorActual, valor);
            todos.remove(actual);
            todos.add(actual, jugadorEspeculador);
    }
  }
}
