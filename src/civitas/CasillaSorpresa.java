package civitas;

import java.util.ArrayList;

public class CasillaSorpresa extends Casilla {

    private MazoSorpresas mazo;
    private Sorpresa sorpresa;

    CasillaSorpresa(MazoSorpresas mazo, String nombre){
        super(nombre);
        this.mazo = mazo;
        sorpresa = mazo.siguiente();
    }

    @Override
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        if(jugadorCorrecto(actual, todos)){
            informe(actual, todos);
            sorpresa.aplicarAJugador(actual, todos);
            sorpresa = mazo.siguiente();
        }
    }

    @Override
    public String toString(){
        String str = "-----------------------------------\n" +
                     "CASILLA: \n" +
                     "Nombre:         " + this.getNombre() + "\n" +
                     "Tipo:           " + "Sorpresa" + "\n" +
                     sorpresa.toString() + "\n";
        str += "-----------------------------------\n";

        return str;
    }
}