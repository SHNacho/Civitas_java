package civitas;

import java.util.ArrayList;

abstract class Sorpresa {

    protected String texto;

    Sorpresa(String texto){
        this.texto = texto;
    }

    public abstract String toString();
    abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);

    public boolean jugadorCorrecto (int actual, ArrayList<Jugador> todos){
        boolean cmp = false;
        
        if (actual >=0 && actual < todos.size()){
            cmp = true;
        }
        
        return cmp;
    }

    protected void informe(int actual, ArrayList<Jugador> todos){
        Diario diario = Diario.getInstance();
        
        if (jugadorCorrecto(actual, todos)){
            diario.ocurreEvento("Se aplica Sorpresa a "+todos.get(actual).getNombre());
        }   
    }
}