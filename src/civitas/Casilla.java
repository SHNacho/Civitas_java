package civitas;

import java.util.ArrayList;

public class Casilla {

    /*========================ATRIBUTOS======================== */
    private static int carcel;
    private float importe;
    private String nombre;
    private TipoCasilla tipo;
    private TituloPropiedad  tituloPropiedad;
    private MazoSorpresas mazo;
    private Sorpresa sorpresa;

    /*=========================MÉTODOS========================= */

    /*----------------------Constructores----------------------*/
    Casilla(String nombre){
        this.nombre = nombre;
    }

    Casilla(TituloPropiedad titulo){

    }

    Casilla(float cantidad, String nombre){
        
    }

    Casilla(int numCasillaCarcel, String nombre) {

    }

    Casilla(MazoSorpresas mazo, String nombre){

    }

    
    public String getNombre (){
        return nombre;
    }

    TituloPropiedad getTituloPropiedad(){
        return null;
    }

    private void informe(int iactual, ArrayList<Jugador> todos){

    }

    private void init(){
        
    }

    public boolean jugadorCorrecto(int iactual, ArrayList<Jugador> todos){

    }

    void recibeJugador(int iactual, ArrayList<Jugador> todos){

    }

    private void recibeJugador_calle(int iactual, ArrayList<Jugador> todos){

    }

    private void recibeJugador_impuesto(int iactual, ArrayList<Jugador> todos){

    }

    private void recibeJugador_juez(int iactual, ArrayList<Jugador> todos){

    }

    private void recibeJugador_sorpresa(int iactual, ArrayList<Jugador> todos){

    }

    public String toString(){

    }
}
