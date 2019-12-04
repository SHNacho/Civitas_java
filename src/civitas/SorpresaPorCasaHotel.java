package civitas;

import java.util.ArrayList;

public class SorpresaPorCasaHotel extends Sorpresa{
    
    private int valor;

    SorpresaPorCasaHotel(int valor, String texto){
        super(texto);
        this.valor = valor;
    }

    @Override
    public String toString(){
        String str = "Sorpresa Por Casa/Hotel \n" + texto;

        return str;
    }

    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual, todos)){
            informe(actual, todos);
            
            float saldo = valor * todos.get(actual).cantidadCasasHoteles();
            
            todos.get(actual).modificarSaldo(saldo);
        }  
    }
}