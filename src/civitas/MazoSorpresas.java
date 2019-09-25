


package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author nacho
 */

public class MazoSorpresas {
   private ArrayList<Sorpresa> sorpresas;
   private boolean barajada;
   private int usadas;
   private boolean debug;
   private ArrayList<Sorpresa> cartasEspeciales;
   private Sorpresa ultimaSorpresa;
   
   private void init(){
       sorpresas = new ArrayList<>();
       cartasEspeciales = new ArrayList<>();
       barajada = false;
       usadas = 0;       
   }
   
   MazoSorpresas(){
       this.init();
       debug = false;
   }
   
   MazoSorpresas(boolean _debug){
       debug = _debug;
       this.init();
       if (debug){
           Diario.getInstance().ocurreEvento("Modo debug activado");
       }
   }
   
   void alMazo(Sorpresa s){
       if(!barajada){
           sorpresas.add(s);
       }
   }
   
   Sorpresa siguiente(){
        if ( (!barajada) || (usadas == sorpresas.size()) ){
            if (!debug){
                Collections.shuffle(sorpresas);
            }
            usadas = 0;
            barajada = true;
        }

        ++usadas;

        ultimaSorpresa = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(ultimaSorpresa);
       
       return ultimaSorpresa;
    }
   
   void inhabilitarCartaEspecial (Sorpresa sorpresa){
       boolean inhabilitada = sorpresas.remove(sorpresa);
       
       if(inhabilitada){
           cartasEspeciales.add(sorpresa);
           String evento = "Se ha inhabilitado una carta especial";
           Diario.getInstance().ocurreEvento(evento);
       }
   }

   void habilitarCartaEspecial(Sorpresa sorpresa){
       int pos = cartasEspeciales.indexOf(sorpresa);
       if (pos != -1){
           sorpresas.add(sorpresa);
           cartasEspeciales.remove(pos);
           Diario.getInstance().ocurreEvento("Carta especial habilitada");
       }
   }
}
