package civitas;

import java.util.ArrayList;

public class SorpresaSalirCarcel extends Sorpresa{
    
    private MazoSorpresas mazo;

    SorpresaSalirCarcel(MazoSorpresas mazo, String texto){
        super(texto);
        this.mazo = mazo;
    }

    void usada(){
        mazo.inhabilitarCartaEspecial(this);
    }
      
    void SalirdelMazo(){
        mazo.inhabilitarCartaEspecial(this);
    }

    @Override
    public String toString(){
        String str = "Sorpresa Salir Carcel \n" + texto;

        return str;
    }

    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (jugadorCorrecto(actual,todos)){
            informe (actual,todos);
            
            boolean laTiene = false;
            
            for (int i = 0; i<todos.size(); i++){
                if (todos.get(i).tieneSalvoconducto())
                    laTiene = true;
            }
            
            if (!laTiene){
                todos.get(actual).obtenerSalvoconducto(this);
                SalirdelMazo();
            }
        }
    }
}