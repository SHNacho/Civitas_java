package civitas;

public class TituloPropiedad {

    /*========================ATRIBUTOS======================== */
    private static float factorInteresesHipoteca = (float)1.1;
    
    private float alquilerBase;
    private float factorRevalorizacion;
    private float hipotecaBase;
    private boolean hipotecado;
    private String nombre;
    private int numCasas;
    private int numHoteles;
    private float precioCompra;
    private float precioEdificar;
    private Jugador propietario;

    /*=========================MÉTODOS========================= */

    TituloPropiedad(String nom, float ab, float fr, float hb, float pc, float pe){
        nombre = nom;
        alquilerBase = ab;
        factorRevalorizacion = fr;
        hipotecaBase = hb;
        precioCompra = pc;
        precioEdificar = pe;
        propietario = null;
        hipotecado = false;
        numCasas = 0;
        numHoteles = 0;
    }

    void actualizaPropietarioPorConversion(Jugador jugador){
        
    }

    boolean cancelarHipoteca(Jugador jugador){
        boolean operacion_realizada = false;
        if (hipotecado && esEsteElPropietario(jugador)){
            jugador.paga(getImporteCancelarHipoteca());
            hipotecado = false;
            operacion_realizada = true;
        }

        return operacion_realizada;
    }
    

    int cantidadCasasHoteles(){
        return (numCasas+numHoteles);
    }

    boolean comprar(Jugador jugador){
        boolean comprada = false;

        if(!tienePropietario()){
            jugador.paga(precioCompra);
            propietario = jugador;
            comprada = true;
        }

        return comprada;
    }

    boolean construirCasa(Jugador jugador){
        boolean construida = false;

        if(jugador == propietario){
            propietario.paga(precioEdificar);
            numCasas++;
            construida=true;
        }

        return construida;
    }

    boolean construirHotel(Jugador jugador){
        boolean construida = false;

        if(jugador == propietario){
            propietario.paga(precioEdificar);
            numHoteles++;
            construida=true;
        }

        return construida;
    }

    boolean derruirCasas(int n, Jugador jugador){

        boolean operacion_realizada = false;
        if((jugador == propietario) && (numCasas >= n)){
            numCasas -= n;
            operacion_realizada = true;
        }
        return operacion_realizada;            
    }

    private boolean esEsteElPropietario(Jugador jugador){
        return (propietario == jugador);
    }

    public boolean getHipotecado(){
        return hipotecado;
    }

    float getImporteCancelarHipoteca(){
        return getImporteHipoteca()*factorInteresesHipoteca;
    }

    private float getImporteHipoteca(){
        float importeHipoteca = (float)(hipotecaBase*(1+(numCasas*0.5)+(numHoteles*2.5)))
        return importeHipoteca;
    }

    String getNombre(){
        return nombre;
    }

    int getNumCasas(){
        return numCasas;
    }

    int getNumHoteles(){
        return numHoteles;
    }

    private float getPrecioAlquiler(){
        float alquiler;

        if(hipotecado || propietarioEncarcelado())
            alquiler = 0;
        else
            alquiler = (float)(alquilerBase*(1+(numCasas*0.5)+(numHoteles*2.5)));

        return alquiler;
    }

    float getPrecioCompra(){
        return precioCompra;
    }

    float getPrecioEdificar(){
        return precioEdificar;
    }

    private float getPrecioVenta(){
        return precioCompra + precioEdificar*(numCasas+5*numHoteles)*factorRevalorizacion;
    }

    Jugador getPropietario(){
        return propietario;
    }

    boolean hipotecar(Jugador jugador){
        if (!hipotecado && esEsteElPropietario(jugador)){
            jugador.recibe(getImporteHipoteca());
            hipotecado = true;
            return true;
        }

        return false;
    }

    private boolean propietarioEncarcelado(){
        boolean encarcelado = true;
        if (propietario == null || !propietario.isEncarcelado())
            encarcelado = false;

        return encarcelado;
    }

    boolean tienePropietario(){
        return (propietario != null);
    }

    public String toString(){

        String nombre_propietario = "Sin propietario",
               hipotecado_str     = "No";

        if(hipotecado) {
            hipotecado_str = "Sí";
        }

        if(tienePropietario()){
            nombre_propietario = propietario.getNombre();
        }


        // String str = "TituloPropiedad" + "\n" +
        //              "-Nombre:                   " + nombre + "\n" +
        //              "-Precio base de alquiler:  " + Float.toString(alquilerBase) + "\n" +
        //              "-Factor de revalorización: " + Float.toString(factorRevalorizacion) + "\n" +
        //              "-Hipoteca base:            " + Float.toString(hipotecaBase) + "\n" +
        //              "-Precio de compra:         " + Float.toString(precioCompra) + "\n" +
        //              "-Precio de edificar:       " + Float.toString(precioEdificar) + "\n" +
        //              "-Propietario:              " + nombre_propietario + "\n" +
        //              "-Hipotecado:               " + hipotecado_str + "\n" +
        //              "-Numero de casas:          " + Integer.toString(numCasas) + "\n" +
        //              "-Numero de hoteles:        " + Integer.toString(numHoteles) + "\n";

        String str = nombre;

        return str;
    }

    void tramitarAlquiler(Jugador jugador){
        if(tienePropietario() && propietario != jugador){
            propietario.recibe(alquilerBase);
            jugador.pagaAlquiler(alquilerBase);
        }
    }

    boolean vender(Jugador jugador){
        boolean vendida = false;

        if(propietario == jugador){
            numCasas = 0;
            numHoteles = 0;
            jugador.recibe(getPrecioVenta());
            propietario = null;
            vendida = true;
        }

        return vendida;
    }



}