package civitas;

import java.util.ArrayList;
import java.lang.Float;

public class Jugador implements Comparable<Jugador> {
    private static int CasasMax         = 4;
    private static int CasasPorHotel    = 4;
    private static int HotelesMax       = 4;
    private static float PasoPorSalida  = 1000;
    private static float PrecioLibertad = 200;
    private static float SaldoInicial   = 7500;

    protected boolean encarcelado;
    private String nombre;
    private int numCasillaActual;
    private boolean puedeComprar;
    private float saldo;
    private Sorpresa salvoconducto;
    private ArrayList<TituloPropiedad> propiedades;

    Jugador (String nombre){
        this.nombre = nombre;
        encarcelado = false;
        numCasillaActual = 0;
        puedeComprar = true;
        saldo = SaldoInicial;
        salvoconducto = null;
        propiedades = new ArrayList<>();
    }

    private Jugador(Jugador otro){
        encarcelado = otro.encarcelado;
        nombre = otro.nombre;
        numCasillaActual = otro.numCasillaActual;
        puedeComprar = otro.puedeComprar;
        saldo = otro.saldo;
        salvoconducto = otro.salvoconducto;
        propiedades = otro.propiedades;
    }
    // boolean cancelarHipoteca(int ip){}
    //Probar
    int cantidadCasasHoteles(){
        int cantidad = 0;
        for(TituloPropiedad propiedad : propiedades){
            cantidad += propiedad.cantidadCasasHoteles();
        }

        return cantidad;
    }

    public int compareTo(Jugador otro){
        return Float.compare(saldo, otro.saldo);
    }

    boolean comprar(TituloPropiedad titulo){
        boolean result = false;
        if (encarcelado){
            return result;
        }

        if(puedeComprar){
            float precio = titulo.getPrecioCompra();

            if(puedoGastar(precio)){
                result = titulo.comprar(this);
                
                if(result){
                    propiedades.add(titulo);
                    Diario.getInstance().ocurreEvento("El jugador " + nombre + " compra la propiedad " + titulo.toString());
                }
            }
        }

        return result;
    }
    // boolean construirCasa(int ip){}
    // boolean construirHotel(int ip){}

    private boolean debeSerEncarcelado(){
        boolean debeSerEncarcelado = false;

        if(!encarcelado){
            if(!tieneSalvoconducto()){
                debeSerEncarcelado = true;
            }
            else{
                debeSerEncarcelado = false;
                perderSalvoconducto();
            }
        }

        return debeSerEncarcelado;
    }

    boolean enBancarrota(){
        return (saldo < 0);
    }

    boolean encarcelar(int numCasillaCarcel){
        if(debeSerEncarcelado()){
            moverACasilla(numCasillaCarcel);
            encarcelado = true;
            Diario.getInstance().ocurreEvento("Ha sido encarcelado " + nombre);
        }
        return encarcelado;
    }

    private boolean existeLaPropiedad(int ip){
        return (ip < propiedades.size());
    }

    private int getCasasMax(){
        return CasasMax;
    }

    int getCasasPorHotel(){
        return CasasPorHotel;
    }

    private int getHotelesMax(){
        return HotelesMax;
    }
    
    String getNombre(){
        return nombre;
    }

    int getNumCasillaActual(){
        return numCasillaActual;
    }

    private float getPrecioLibertad(){
        return PrecioLibertad;
    }

    private float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    
    protected ArrayList<TituloPropiedad> getPropiedades(){
        return propiedades;
    }

    boolean getPuedeComprar(){
        return puedeComprar;
    }

    protected float getSaldo(){
        return saldo;
    }

    boolean hipotecar(int ip){
        boolean result = false;

        if(encarcelado)
            return result;
        
        if(existeLaPropiedad(ip)){
            TituloPropiedad propiedad = propiedades.get(ip);
            result = propiedad.hipotecar(this);
        }

        if(result){
            Diario.getInstance().ocurreEvento("El jugador " + nombre + " hipoteca la propiedad " + ip);
        }

        return result;
    }

    public boolean isEncarcelado(){
        return encarcelado;
    }

    boolean modificarSaldo(float cantidad){
        saldo += cantidad;
        String evento = "El saldo del jugador " + nombre + 
                        " ha aumentado en" + Float.toString(cantidad);
        Diario.getInstance().ocurreEvento(evento);
        return true;
    }

    boolean moverACasilla(int numCasilla){
        boolean puedeMover = false;

        if(!encarcelado){
            puedeMover = true;
            numCasillaActual = numCasilla;
            puedeComprar = false;
            String evento ="El jugador " + nombre + " se ha movido a la casilla" 
                            + Integer.toString(numCasilla);
            Diario.getInstance().ocurreEvento(evento);
        }

        return puedeMover;
    }

    boolean obtenerSalvoconducto(Sorpresa sorpresa){
        boolean obtieneSalvoconducto = false;

        if(!encarcelado){
            salvoconducto = sorpresa;
            obtieneSalvoconducto = true;
        }

        return obtieneSalvoconducto;
    }

    boolean paga(float cantidad){
        return modificarSaldo(cantidad * -1);
    }

    boolean pagaAlquiler(float cantidad){
        if(!encarcelado){
            return paga(cantidad);
        }
        return false;
    }

    boolean pagaImpuesto(float cantidad){
        if(!encarcelado){
            return paga(cantidad);
        }
        return false;
    }

    boolean pasaPorSalida(){
        modificarSaldo(PasoPorSalida);
        Diario.getInstance().ocurreEvento("El jugador " + nombre + " ha pasado por salida");
        return true;
    }

    private void perderSalvoconducto(){
        salvoconducto.usada();
        salvoconducto = null;
    }

    boolean puedeComprarCasilla(){
        if(encarcelado)
            puedeComprar = false;
        else
            puedeComprar = true;

        return puedeComprar;
    }

    private boolean PuedoSalirCarcelPagando(){
        return (saldo >= PrecioLibertad);
    }

    private boolean PuedoEdificarCasa(TituloPropiedad propiedad){
        return( propiedades.contains(propiedad) &&
               (propiedad.getNumCasas() < CasasMax) && 
               puedoGastar(propiedad.getPrecioEdificar()) );
    }

    private boolean puedoEdificarHotel(TituloPropiedad propiedad){
        return( propiedades.contains(propiedad) &&
               (propiedad.getNumCasas() < CasasMax) && 
               puedoGastar(propiedad.getPrecioEdificar()*5));
    }
    
    private boolean puedoGastar(float precio){
        return ( (!encarcelado) && (saldo >= precio) );
    }

    boolean recibe(float cantidad){
        if(!encarcelado){
            return modificarSaldo(cantidad);
        }
        return false;
    }

    boolean salirCarcelPagando(){
        boolean sale = false;
        if(encarcelado && PuedoSalirCarcelPagando()){
            paga(PrecioLibertad);
            sale = true;
            encarcelado = false;
            Diario.getInstance().ocurreEvento("Jugador " + nombre + " ha salido de la carcel");
        }
        return sale;
    }

    boolean salirCarcelTirando(){
        boolean sale = false;
        if(encarcelado && Dado.getInstance().salgoDeLaCarcel()){
            sale = true;
            Diario.getInstance().ocurreEvento("Jugador " + nombre + " ha salido de la carcel");
            encarcelado = false;
        }
        return sale;
    }

    boolean tieneAlgoQueGestionar(){
        return (propiedades.size() > 0);
    }

    boolean tieneSalvoconducto(){
        return (salvoconducto != null);
    }

    public String toString(){
        String encarceladoStr = encarcelado ? "Sí" : "No";
        String salvoconductoStr = (salvoconducto == null) ? "No" : "Sí";
        String propiedadesStr = Integer.toString(propiedades.size());
        String puedeComprarStr = puedeComprar ? "Sí" : "No";
        String str = "JUGADOR \n" +
                     "Nombre:         " + nombre + "\n" + 
                     "Saldo:          " + Float.toString(saldo) + "\n" +
                     "Casilla actual: " + Integer.toString(numCasillaActual) + "\n" +
                     "Encarcelado:    " + encarceladoStr + "\n" +
                     "Salvoconducto:  " + salvoconductoStr + "\n" +
                     "Propiedades:    " + propiedadesStr + "\n" +
                     "Puede comprar   " + puedeComprarStr;

        return str;
    }

    boolean vender(int ip){
        boolean puedeVender = false;

        if(!encarcelado ){
            if(existeLaPropiedad(ip)){
                if(propiedades.get(ip).vender(this)){
                    puedeVender = true;
                    propiedades.remove(ip);
                    String evento = "El jugador " + nombre 
                                    + " ha vendido su propiedad " 
                                    + Integer.toString(ip);
                    Diario.getInstance().ocurreEvento(evento);
                }
            }
        }

        return puedeVender;
    }
}