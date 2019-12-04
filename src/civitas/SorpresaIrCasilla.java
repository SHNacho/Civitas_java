package civitas;

import java.util.ArrayList;

public class SorpresaIrCasilla extends Sorpresa{
    
    Tablero tablero;
    int valor;

    SorpresaIrCasilla(Tablero tablero, int valor, String texto){
        super(texto);
        this.tablero = tablero;
        this.valor = valor;
    }

    @Override
    public String toString(){
        String str = "IR CASILLA /n" + texto; 
        return str;
    }

    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual,todos)){

            informe (actual, todos);
            int casillaActual = todos.get(actual).getNumCasillaActual();
            
            // Calculamos la tirada con el valor de sorpresa y con la casilla actual
            int tirada = tablero.calcularTirada(casillaActual, valor);
            int nuevaPos=tablero.nuevaPosicion(actual, tirada);
            todos.get(actual).moverACasilla(nuevaPos);
            Casilla casilla = tablero.getCasilla(valor);
            casilla.recibeJugador(actual,todos);
        }
    }
}