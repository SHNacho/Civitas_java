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

enum GestorEstados{
    
    EstadosJuego estadoInicial(){
    
    }
    
    OperacionesJuego operacionesPermitidas (Jugador jugador, EstadosJuego estado){
    
    }

    EstadosJuego siguienteEstado ( Jugador jugador, EstadosJuego estado, OperacionesJuego operacion){

    }     
    
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
        
        // Comprobamos cuantas veces sale quien empieza en cada tirada
        
        int n = 4;
        
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        
        int k = 0;
  
        for (int i = 0; i< 100; i++){
            
            k = Dado.getInstance().quienEmpieza(n);
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
        
        lol = Dado.getInstance().salgoDeLaCarcel();
        
        if (lol == true)
            System.out.println("salgo de la carcel");
        else
            System.out.println("no salgo de la carcel");
        
        // Funciona toda la clase Dado
        
        //Ahora mostraremos al menos un valor de cada enumerado
        
        System.out.println("\nAhora mostraremos un valor de cada enumerado");
        
        System.out.println("Tipo de casilla: " + TipoCasilla.CALLE);
        
        System.out.println("Tipo de sorpresa: " + TipoSorpresa.IRCASILLA);
        
        System.out.println("Estados de juego: " + EstadosJuego.DESPUES_AVANZAR);

        //Funcionamiento de la clase MazoSorpresas
        MazoSorpresas mazo       = new MazoSorpresas();
        Sorpresa      sorpresa_1 = new Sorpresa("Sorpresa 1");
        Sorpresa      sorpresa_2 = new Sorpresa("Sorpresa 2");
        
        mazo.alMazo(sorpresa_1);
        mazo.alMazo(sorpresa_2);

        Sorpresa sorpresa_siguiente = mazo.siguiente();

        mazo.inhabilitarCartaEspecial(sorpresa_2);
        mazo.habilitarCartaEspecial(sorpresa_2);

        System.out.println("\nAhora se leerá el diario");
        Diario diario = Diario.getInstance();
        
        while (diario.eventosPendientes()) {
            System.out.println(diario.leerEvento());
        }

        
        // Ahora comprobaremos que funciona la clase Tablero

        System.out.println("\nComprobación de la clase tablero:");
        
        Tablero tabla = new Tablero(3);
        
        tabla.añadeJuez();          // Porque sino el tablero no es correcto
        
        Casilla casilla1 = new Casilla("Primera");
        Casilla casilla2 = new Casilla("Segunda");
        Casilla casilla3 = new Casilla("Tercera");
        Casilla casilla4 = new Casilla ("Cuarta");
        
        
        tabla.añadeCasilla(casilla1);
        tabla.añadeCasilla(casilla2);
        tabla.añadeCasilla(casilla3);
        tabla.añadeCasilla(casilla4);
        
        Casilla devolver = new Casilla("a");
        
        for (int i = 0; i < 7; i++){
            devolver = (tabla.getCasilla(i));
            
            System.out.println(devolver.getNombre());
        }
        
        // Al ejecutarlo podemos comprobar como funciona correctamente
        
        // Tras esto vamos a comprobar que funciona el método de calcular tirada
        
        int tirada = tabla.calcularTirada(3, 2);
        
        System.out.println("La tirada es: " + tirada);
        
        System.out.println("La tirada es: "+tabla.calcularTirada(2,5));
                   
        // Podemos comprobar que se calcula bien la tirada
        
        // Una vez que hemos visto que se calcula bien la tirada comprobamos que
        // dado un origen y dado la tirada se calcula bien el destino
        
        
        int origen = 2;
        
        int tirar = 6;
        
        int posicion= tabla.nuevaPosicion (origen, tirar); 
        
        System.out.println("El nuevo destino es " + posicion);
        
        
  
       
        
    }
    
}
