/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

public class JugadorEspeculador extends Jugador {
    
    private static int factorEspeculador = 2;
    private int fianza;
    private static int CasasMax = getCasasMax() * factorEspeculador;
    private static int HotelesMax = getHotelesMax() * factorEspeculador;
    
    
    JugadorEspeculador (Jugador otro, int cantidad){
        super(otro);
        fianza = cantidad;
        
        for (TituloPropiedad propiedad : getPropiedades())
            propiedad.actualizaPropietarioPorConversion(this);
    }
    
    @Override
    public String toString(){
        String encarceladoStr = encarcelado ? "Sí" : "No";
        String salvoconductoStr = (salvoconducto == null) ? "No" : "Sí";
        String propiedadesStr = Integer.toString(getPropiedades().size());
        String puedeComprarStr = getPuedeComprar() ? "Sí" : "No";
        String str = "-----------------------------------\n" +
                     "JUGADOR \n" +
                     "Tipo de jugador: Especulador \n" +
                     "Nombre:         " + getNombre() + "\n" + 
                     "Saldo:          " + Float.toString(getSaldo()) + "\n" +
                     "Casilla actual: " + Integer.toString(getNumCasillaActual()) + "\n" +
                     "Encarcelado:    " + encarceladoStr + "\n" +
                     "Salvoconducto:  " + salvoconductoStr + "\n" +
                     "Propiedades:    " + propiedadesStr + "\n" +
                     "Puede comprar   " + puedeComprarStr + "\n" +
                     "-----------------------------------\n";

        return str;
    }
    
    protected static int getCasasMax(){
        return CasasMax;
    }
    
    protected static int getHotelesMax(){
        return CasasMax;
    }
    
    boolean encarcelar(int num_casilla_carcel){
        if (debeSerEncarcelado()){
            if (getSaldo() < fianza){
                moverACasilla(num_casilla_carcel);
                encarcelado = true;
                Diario.getInstance().ocurreEvento("Ha sido encarcelado "+getNombre());
            }
            else{
                paga(fianza);
            }
        }
        
        return encarcelado;
    }
    
    boolean pagaImpuesto(int cantidad){
        return super.pagaImpuesto(cantidad/factorEspeculador);
    }
}
