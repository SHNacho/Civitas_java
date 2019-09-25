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
        System.out.println("Participante 1 "+p1);
        System.out.println("Participante 2 "+p2);
        System.out.println("Participante 3 "+p3);
        System.out.println("Participante 4 "+p4);
        
        // Comprobamos que funciona el método debug
        
        System.out.println("Comprobamos el método debug");
        
        boolean d = true;
        
        System.out.println("Para debug=true, se dan las siguientes tiradas:");
        
        Dado.getInstance().setDebug(d);
        
        for (int i= 0; i < 5; i++)
            System.out.println(Dado.getInstance().tirar());
        
        d = false;
        
        System.out.println("Para debug=false, se dan las siguientes tiradas:");
        
        Dado.getInstance().setDebug(d);
        
        for (int i= 0; i < 5; i++)
            System.out.println(Dado.getInstance().tirar());
        
        // Comprobamos que funciona getUltimoResultado() y salgoDeLaCarcel()
        
        System.out.println("Comprobamos el método getUltimoResultado");
        
        System.out.println(Dado.getInstance().getUltimoResultado());
        
        // Podemos observar que devuelve el último valor de la tirada
        
        boolean lol = true;
        
        d = Dado.getInstance().salgoDeLaCarcel();
        
        if (d == true)
            System.out.println("salgo de la carcel");
        else
            System.out.println("no salgo de la carcel");
        
        // Funciona toda la clase Dado
                    
            
        
    }
    
}
