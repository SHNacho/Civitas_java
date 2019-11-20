package juegoTexto;

import civitas.CivitasJuego;
import civitas.Diario;
import civitas.GestionesInmobiliarias;
import civitas.OperacionesJuego;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class VistaTextual {
  
  CivitasJuego juegoModel; 
  int iGestion;
  int iPropiedad;
  private static String separador = "=====================";
  
  private Scanner in;
  
  VistaTextual () {
    in = new Scanner (System.in);
    iGestion = -1;
    iPropiedad = -1;
  }
  
  void mostrarEstado(String estado) {
    System.out.println (estado);
  }
              
  void pausa() {
    System.out.print ("Pulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }

  SalidasCarcel salirCarcel() {
    int opcion = menu ("Elige la forma para intentar salir de la carcel",
      new ArrayList<> (Arrays.asList("Pagando","Tirando el dado")));
    return (SalidasCarcel.values()[opcion]);
  }

  Respuestas comprar() {
      
    ArrayList<String> lista = new ArrayList<>();
    
    lista.add("SÍ");
    
    lista.add("NO");
    
    int opcion = this.menu("¿Quieres comprar esta calle?",
                    lista);
      
    return (Respuestas.values()[opcion]);
  }

  void gestionar () {
      iGestion = this.menu("¿Qué gestión inmoviliaria quieres hacer?",
      new ArrayList<> (Arrays.asList("VENDER", "HIPOTECAR", "CANCELAR HIPOTECA",
                          "CONSTRUIR CASA", "CONSTRUIR HOTEL", "TERMINAR")));

      if(GestionesInmobiliarias.values()[iGestion] != GestionesInmobiliarias.TERMINAR){
        iPropiedad = menu("¿Sobre qué propiedad quieres hacer la gestión?",
                          juegoModel.getJugadorActual().ListaPropiedades());
      }
  }
  
  public int getGestion(){
      return iGestion;
  }
  
  public int getPropiedad(){
      return iPropiedad;
  }
    

  void mostrarSiguienteOperacion(OperacionesJuego operacion) {
      System.out.println("Siguiente operación: " + operacion.toString());
  }


  void mostrarEventos() {
      Diario diario = Diario.getInstance();
      while (diario.eventosPendientes())
        System.out.println( diario.leerEvento());
  }
  
  public void setCivitasJuego(CivitasJuego civitas){ 
        juegoModel=civitas;
        this.actualizarVista();
    }
  
  void actualizarVista(){
      System.out.println(juegoModel.infoJugadorTexto());
      System.out.println(juegoModel.getCasillaActual().toString());
      System.out.println(separador);
  } 
}
