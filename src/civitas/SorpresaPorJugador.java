package civitas;

import java.util.ArrayList;

public class SorpresaPorJugador extends Sorpresa{
    
    private int valor;

    SorpresaPorJugador(int valor, String texto){
        super(texto);
        this.valor = valor;
    }

    @Override
    public String toString(){
        String str = "Sorpresa Por Jugador \n" + texto;
        
        return str;
    }

    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual,todos)){
            
            informe (actual,todos);
            
            SorpresaPagarCobrar sorpresa = new SorpresaPagarCobrar((valor*(-1)),"Pagarcobrar");
            
            for (int i = 0; i < todos.size(); i++){
                if (i != actual)
                    sorpresa.aplicarAJugador(i, todos);
            }
            
            SorpresaPagarCobrar sorpresa2 = new SorpresaPagarCobrar((valor*(todos.size()-1)),"Pagarcobrar");
            
            sorpresa2.aplicarAJugador(actual, todos);
        }
    }
}