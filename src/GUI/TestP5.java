/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;

import civitas.CivitasJuego;

/**
 *
 * @author juliocamposrodriguez
 */
public class TestP5 {
    
    public static void main(){
        CivitasView vistaCivitas = new CivitasView();
        
        Dado.createInstance(vistaCivitas);
        
        Dado dado = Dado.getInstance();
        
        dado.setDebug(true);
        
        CapturaNombres captura = new CapturaNombres(vistaCivitas, true);
        
        ArrayList<String> nombres = new ArrayList<>();
        
        nombres = captura.getNombres();
        
        CivitasJuego juego = new CivitasJuego(nombres);
        
        Controlador controlador = new Controlador(juego, vistaCivitas);
        
        vistaCivitas.setCivitasJuego(juego);
        
    
    }
}
