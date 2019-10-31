package civitas;

import java.util.ArrayList;

public class TestP2 {

    public static void main(String[] args){
        ArrayList <String> nombres = new ArrayList<>();
        nombres.add("Nacho");
        nombres.add("Julio");
        nombres.add("Adris");
        nombres.add("Jacob");

        CivitasJuego juego = new CivitasJuego(nombres);
        System.out.println("Juego iniciado");

        
    }
}