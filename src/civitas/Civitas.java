/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;
enum TipoCasilla {
    CALLE,
    SORPRESA,
    JUEZ,
    IMPUESTO,
    DESCANSO
}
enum TipoSorpresa {
    IRCARCEL,
    IRCASILLA,
    PAGARCOBRAR,
    PORCASAHOTEL,
    PORJUGADOR,
    SALIRCARCEL
}
enum EstadosJuego {
  INICIO_TURNO,
  DESPUES_CARCEL,
  DESPUES_AVANZAR,
  DESPUES_COMPRAR,
  DESPUES_GESTIONAR
}

enum OperacionesJuego{
    PASAR_TURNO,
    SALIR_CARCEL,
    AVANZAR,
    COMPRAR,
    GESTIONAR
}
/**
 *
 * @author nacho
 */
public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TituloPropiedad titulo = new TituloPropiedad("titulo", 10, 10, 10, 10, 10);
        
        System.out.println(titulo.toString());
    }
    
}
