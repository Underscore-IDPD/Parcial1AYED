package clases.controlador;

import clases.logicas.PrintService;
import clases.logicas.Prioridad;

/*
Clase PrintManager:
Clase controladora
*/

public class PrintManager {
    private static PrintManager Instance;

    private PrintService servicioImprimir;
    public static PrintManager getInstance(){
        if(Instance == null){
            Instance = new PrintManager();
        }
        return Instance;
    }

    public PrintManager(){
        this.servicioImprimir = new PrintService();
    }

    public PrintService utilizarServicio(){
        return servicioImprimir;
    }

    public int valPrioridad(Prioridad p){
        return switch(p){
            case H -> 2;
            case M -> 1;
            case L -> 0;
        };
    }
}
