/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.Random;

/**
 *
 * @author juliocamposrodriguez
 */
public class Dado {
    
    //Atributos de instancia
    
    private Random random = new Random();
    private int ultimoResultado;
    private boolean debug;
    
    //Atributos de clase
    
    private static Dado instance = new Dado();
    private static int SalidaCarcel = 5;
    
    private Dado(){
        
        ultimoResultado = 0;
        debug = false;
    }
    
    static public Dado getInstance(){
        
        return instance;
    }
    
    int tirar(){
        
        ultimoResultado = 1;
        
        if (debug == false)
            ultimoResultado = (random.nextInt(6) +1);
        
        return ultimoResultado;
    }
    
    boolean salgoDeLaCarcel(){
        
        tirar();
        
        boolean puede = false;
        
        if (ultimoResultado == SalidaCarcel)
            puede = true;
        
        return puede;
    }
    
    int quienEmpieza (int n){
        
        
        int empieza = (random.nextInt(n));
        
        return empieza;
    }
    
    void setDebug (boolean d){
        
        // Esto no se entiende bien el como meter el evento en diario
        
        debug = d;

        String estado = "debug true";
        
        if (debug == true)
            Diario.getInstance().ocurreEvento(estado);
        else{
            estado ="debug false";
            Diario.getInstance().ocurreEvento(estado);
        }
            
        
    }
    
    int getUltimoResultado(){
        
        return ultimoResultado;
    }
            
    
    
}
