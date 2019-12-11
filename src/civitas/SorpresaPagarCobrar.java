package civitas;

import java.util.ArrayList;

public class SorpresaPagarCobrar extends Sorpresa{
    
    private int valor;

    SorpresaPagarCobrar(int valor, String texto){
        super(texto);
        this.valor = valor;
    }

    @Override
    public String toString(){
        String str = "Sorpresa Pagar Cobrar \n" + texto;

        return str;
    }

    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual, todos)){
            informe(actual,todos);
            
            todos.get(actual).modificarSaldo(valor);
        }
    }
}