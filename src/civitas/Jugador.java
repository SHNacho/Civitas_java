package civitas;

import java.util.ArrayList;

public class Jugador implements Comparable<Jugador> {
    private static int CasasMax         = 4;
    private static int CasasPorHotel    = 4;
    private static int HotelesMax       = 4;
    private static float PasoPorSalida  = 1000;
    private static float PrecioLibertad = 200;
    private static float SaldoInicial   = 7500;

    private boolean encarcelado;
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
    // private Jugador(Jugador otro){}
    // boolean cancelarHipoteca(int ip){}
    // int cantidadCasasHoteles(){}
    // public int compareTo(Jugador otro){}
    // boolean comprar(TituloPropiedad titulo){}
    // boolean construirCasa(int ip){}
    // boolean construirHotel(int ip){}

    private boolean debeSerEncarcelado(){
        
    }

    // boolean enBancarrota(){}
    // boolean encarcelar(int numCasillaCarcel){}
    // private boolean existeLaPropiedad(int ip){}
    // private int getCasasMax(){}
    // int getCasasPorHotel(){}
    // private int getHotelesMax(){}
    
    String getNombre(){
        return nombre;
    }

    // int getNumCasillaActual(){}
    // private flaot getPrecioLibertad(){}
    // private float getPremioPasoSalida(){}
    // private ArrayList<TituloPropiedad> getPropiedades(){}
    // boolean getPuedeComprar(){}
    // private float getSaldo(){}
    // boolean hipotecar(int ip){}
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

    // boolean moverACasilla(int numCasilla){}
    // boolean obtenerSalvoconducto(Sorpresa sorpresa){}

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
    // boolean pasaPorSalida(){}
    // private void perderSalvoconducto(){}
    // boolean puedeComprarCasilla(){}
    // private boolean PuedoSalirCarcelPagando(){}
    // private boolean PuedoEdificarCasa(TituloPropiedad propiedad){}
    // private boolean puedoEdificarHotel(){}
    // private boolean puedoGastar(float precio){}
    boolean recibe(float cantidad){
        if(!encarcelado){
            return modificarSaldo(cantidad);
        }
        return false;
    }
    // boolean salirCarcelPagando(){}
    // boolean salirCarcelTirando(){}
    // boolean tieneAlgoQueGestionar(){}
    // boolean tieneSaloconducto(){}
    // public String toString(){}
    // boolean vender(int ip){}
}