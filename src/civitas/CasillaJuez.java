package civitas;

import java.util.ArrayList;

public class CasillaJuez extends Casilla {
    private static int carcel = 0;

    CasillaJuez(int numCasillaCarcel, String nombre){
        super(nombre);
        carcel = numCasillaCarcel;
    }

    @Override
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual,todos)){
            informe(actual, todos);
            todos.get(actual).encarcelar(carcel);
        }
    }

    @Override
    public String toString(){
        String str = "-----------------------------------\n" +
                     "CASILLA: \n" +
                     "Nombre:         " + this.getNombre() + "\n" +
                     "Tipo:           " + "Juez" + "\n" +
                     "Casilla carcel: " + Integer.toString(carcel) + "\n" +
                     "-----------------------------------\n";

        return str;
    }
}