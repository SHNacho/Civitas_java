package civitas;

import java.util.ArrayList;

public class Casilla {

    /*========================ATRIBUTOS======================== */
    private String nombre;
    /*=========================MÉTODOS========================= */

    /*----------------------Constructores----------------------*/
    Casilla(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre (){
        return nombre;
    }

    protected void informe(int actual, ArrayList<Jugador> todos){
        String evento = "El jugador " + todos.get(actual).getNombre() +
                        " ha caido en la casilla " + nombre + "\n" +
                        "Información sobre la casilla: \n" + toString();
        Diario.getInstance().ocurreEvento(evento);
    }

    public boolean jugadorCorrecto(int actual, ArrayList<Jugador> todos){
        return(actual < todos.size());
    }

    void recibeJugador(int actual, ArrayList<Jugador> todos){
        informe(actual,todos);     
    }

    @Override
    public String toString(){
        String str = "-----------------------------------\n" +
                     "CASILLA: \n" +
                     "Nombre:         " + nombre + "\n" +
                     "Tipo:           " + "Descanso" + "\n";
        str += "-----------------------------------\n";

        return str;
    }
}
