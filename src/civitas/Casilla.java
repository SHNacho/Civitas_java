/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author nacho
 */
public class Casilla {
    private String nombre;
    
    public Casilla(String _nombre){
        nombre = _nombre;
    }
    
    String getNombre (){
        return nombre;
    }
}