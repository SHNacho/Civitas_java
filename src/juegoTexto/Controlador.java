package juegoTexto;

import civitas.CivitasJuego;
import civitas.GestionesInmobiliarias;
import civitas.OperacionInmobiliaria;
import civitas.OperacionesJuego;;

class Controlador{
    private CivitasJuego juego;
    private VistaTextual vista;

    Controlador(CivitasJuego juego, VistaTextual vista){
        this.juego = juego;
        this.vista = vista;
    }

    void juega(){
        vista.setCivitasJuego(juego);

        while(!juego.finalDelJuego()){
            vista.actualizarVista();
            vista.pausa();
            OperacionesJuego operacion = juego.siguientePaso();
            vista.mostrarSiguienteOperacion(operacion);

            if(operacion != OperacionesJuego.PASAR_TURNO){
                vista.mostrarEventos();
            }

            if(!juego.finalDelJuego()){
                switch (operacion) {
                    case COMPRAR:
                        Respuestas respuesta = vista.comprar();

                        if(respuesta == Respuestas.SI)
                            juego.comprar();
                        
                        juego.siguientePasoCompletado(operacion);
                        break;

                    case GESTIONAR:
                        vista.gestionar();

                        int gestion = vista.getGestion();
                        int propiedad = vista.getPropiedad();

                        OperacionInmobiliaria operacion_inm = 
                        new OperacionInmobiliaria(GestionesInmobiliarias.values()[gestion], propiedad);

                        switch (GestionesInmobiliarias.values()[gestion]){
                            case VENDER:
                                juego.vender(propiedad);
                                break;
                            case HIPOTECAR:
                                juego.hipotecar(propiedad);
                                break;
                            case CANCELAR_HIPOTECA:
                                juego.cancelarHipoteca(propiedad);
                                break;
                            case CONSTRUIR_CASA:
                                juego.construirCasa(propiedad);
                                break;
                            case CONSTRUIR_HOTEL:
                                juego.construirHotel(propiedad);
                                break;
                            case TERMINAR:
                                juego.siguientePasoCompletado(operacion);
                        }
                    
                    case SALIR_CARCEL:
                        SalidasCarcel salida = vista.salirCarcel();

                        if (salida == SalidasCarcel.PAGANDO)
                            juego.salirCarcelPagando();
                        else
                            juego.salirCarcelTirando();

                        juego.siguientePasoCompletado(operacion);
                }
            }

        }
        juego.actualizarInfo();
    }
} 