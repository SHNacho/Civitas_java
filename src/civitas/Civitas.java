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
/**
 *
 * @author nacho
 */
public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jugador nacho = new Jugador("Nacho");
        Jugador julio = new Jugador("Julio");
    }
    
}
