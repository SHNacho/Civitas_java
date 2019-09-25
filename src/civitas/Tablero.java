/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author juliocamposrodriguez
 */
public class Tablero {
    
    private int numCasillaCarcel;
    private ArrayList<Casilla> casillas;
    private int porSalida;
    private boolean tieneJuez;
    
    Tablero (int num){          // Constructor de visibilidad de paquete
        
        if (num < 1){
            numCasillaCarcel = 1;
        }
        else{
            numCasillaCarcel = num;
        }
        
        Casilla salida = new Casilla ("Salida");  
        
        casillas.add(salida);       // Array con una sola casilla "salida"
        
        porSalida = 0;
        
        tieneJuez =  false;
    }
    
    private boolean correcto(){
        
        boolean comp = false;
        
        if (casillas.size() > numCasillaCarcel && tieneJuez == true)
            comp = true;
        
        return comp;
    }
    
    private boolean correcto (int numCasilla){
        
        boolean comp = false;
        
        if (numCasilla < casillas.size() && correcto()==true)
            comp = true;
        
        return comp;
    }
    
    int getCarcel() {
        return numCasillaCarcel;
    }
    
    int getPorSalida() {
        
        int devolver = porSalida;
        
        if (porSalida > 0)
            porSalida--;
        
        return devolver;      
    }
    
    void añadeCasilla (Casilla casilla ){
        
        Casilla carcel = new Casilla ("Carcel");
        
        if (casillas.size() == numCasillaCarcel)
            casillas.add(carcel);
        
        casillas.add(casilla);
        
        if (casillas.size() == numCasillaCarcel)
            casillas.add(carcel);
    }
    
    void añadeJuez (){
        
        Casilla juez = new Casilla ("Juez");
        
        if (tieneJuez == false)
            casillas.add(juez);
            tieneJuez = true;
    }
    
    Casilla getCasilla (int numCasilla){
        
        if (correcto(numCasilla) == true)
            return casillas.get(numCasilla);
        else
            return null;
    }
    
    int nuevaPosicion (int actual, int tirada){
        
        int nueva = -1;
        
        if (correcto() == false)
            return nueva;
        
        nueva = actual + tirada;
        
        if (nueva > casillas.size()){
            nueva = nueva - casillas.size();
            porSalida++;
        }
        
        return nueva;
    }
    
    int calcularTirada (int origen, int destino){
        
        int tirada;
        
        tirada = destino - origen;
        
        if (tirada < 0){
            porSalida++;
            tirada = tirada + casillas.size();

        }
        return tirada;
    }
    
}
