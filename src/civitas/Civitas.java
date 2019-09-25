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
/**
 *
 * @author nacho
 */
public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        // Comprobamos cuantas veces sale quien empieza en cada tirada
        
        int n= 4;
        
        int p1=0;
        int p2=0;
        int p3=0;
        int p4=0;
        
        int k = 0;
  
        for (int i = 0; i< 100; i++){
            
            k= Dado.getInstance().quienEmpieza(n);
            System.out.println(k);
            
            switch (k){
                case 0:
                    p1++;
                    break;
                case 1:
                    p2++;
                    break;
                case 2:
                    p3++;
                    break;
                case 3:
                    p4++;
                    break;
                default:   
            }
        }
        
        System.out.println("Número de veces que empieza cada participante (hay 4)");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
            
        
    }
    
}
