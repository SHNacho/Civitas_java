/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoTexto;

import java.util.ArrayList;
import civitas.CivitasJuego;
import civitas.Dado;
import juegoTexto.Controlador;
import juegoTexto.VistaTextual;
import civitas.Dado;

public class Prueba{
    public static void Juego(){
        VistaTextual vista = new VistaTextual();
        
        ArrayList <String> nombres = new ArrayList();
        
        nombres.add("Julio");
        nombres.add("Nacho");
        nombres.add("Jacob");
        nombres.add("Adri");
        
        CivitasJuego civi = new CivitasJuego(nombres);
        
        Dado.getInstance().setDebug(true);
        
        Controlador control = new Controlador(civi,vista);
        
        control.juega();
    }
    
    public static void main(){
        Prueba.Juego();
    }
}
