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
public class Sorpresa_convertir_jugador extends Sorpresa {
    
    private int valor;
    
    Sorpresa_convertir_jugador(int cantidad, String texto){
        super(texto);
        
        valor = cantidad;
    }
    
    @Override
    public toString(){
        String str = "'Sorpresa convertir jugador: " + texto + "'";
    }
    
    public void aplicarAJugador(int actual,ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual,todos)){
            informe(actual,todos);
            todos.get(actual) = JugadorEspeculador.new(todos.get(actual), valor);
        }
    }
}
