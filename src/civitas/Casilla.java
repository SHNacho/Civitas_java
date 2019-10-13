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
        init();
        tipo = TipoCasilla.DESCANSO;
        this.nombre = nombre;
    }

    Casilla(TituloPropiedad titulo){
        init(); 
        tipo = TipoCasilla.CALLE;
        tituloPropiedad = titulo;
        nombre = titulo.getNombre();
    }

    Casilla(float cantidad, String nombre){
        init();
        importe = cantidad;
        tipo = TipoCasilla.IMPUESTO;
        this.nombre = nombre;
    }

    Casilla(int numCasillaCarcel, String nombre) {
        init();
        this.nombre = nombre;
        tipo = TipoCasilla.JUEZ;
        carcel = numCasillaCarcel;
    }

    Casilla(MazoSorpresas mazo, String nombre){
        init();
        this.nombre = nombre;
        tipo = TipoCasilla.SORPRESA;
        this.mazo = mazo;
        sorpresa = mazo.siguiente();
    }

    
    public String getNombre (){
        return nombre;
    }

    TituloPropiedad getTituloPropiedad(){
        return tituloPropiedad;
    }

    private void informe(int actual, ArrayList<Jugador> todos){
        String evento = "El jugador " + todos.get(actual).getNombre() +
                        " ha caido en la casilla " + nombre + "\n" +
                        "Información sobre la casilla: \n" + toString();
        Diario.getInstance().ocurreEvento(evento);
    }

    private void init(){
        carcel = 0;
        importe = 0;
        mazo = null;
        nombre = "";
        sorpresa = null;
        tipo = null;
        tituloPropiedad = null;
    }

    public boolean jugadorCorrecto(int actual, ArrayList<Jugador> todos){
        return(actual < todos.size());
    }

    // void recibeJugador(int actual, ArrayList<Jugador> todos){

    // }

    // private void recibeJugador_calle(int actual, ArrayList<Jugador> todos){

    // }

    private void recibeJugador_impuesto(int actual, ArrayList<Jugador> todos){
        if (actual < todos.size()){
            informe(actual, todos);
            todos.get(actual).pagaImpuesto(importe);
        }
    }

    private void recibeJugador_juez(int actual, ArrayList<Jugador> todos){
        if (actual < todos.size()){
            informe(actual, todos);
            todos.get(actual).encarcelar(carcel);
        }
    }

    private void recibeJugador_sorpresa(int iactual, ArrayList<Jugador> todos){

    }

    public String toString(){
        String str = "CASILLA: \n" +
                     "Nombre:         " + nombre + "\n" +
                     "Tipo:           " + tipo + "\n";
        
        switch (tipo) {                    
            case IMPUESTO:
                str+="Importe:        " + Float.toString(importe) + "\n";
                break;

            case JUEZ:
                str+="Casilla carcel: " + Integer.toString(carcel) + "\n" ;
                break;
            
            default:
                break;
        }

        return str;
    }
}
