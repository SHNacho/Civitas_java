package civitas;

import java.util.ArrayList;

public class SorpresaIrCarcel extends Sorpresa {

    Tablero tablero;

    SorpresaIrCarcel(Tablero tablero){
        super("Ir a la carcel");
        this.tablero = tablero;
    }

    @Override
    public String toString(){
        String str = "IR CARCEL \n" + texto;
        return str;
    }

    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual,todos)){
            informe(actual, todos);
            int casilla = tablero.getCarcel();
            todos.get(actual).encarcelar(casilla);
        }
    }
}