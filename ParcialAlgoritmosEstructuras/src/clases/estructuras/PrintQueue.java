package clases.estructuras;

import clases.controlador.PrintManager;
import clases.logicas.*;

/*
Clase PrintQueue:
Crea el queue donde se organizan los trabajos de impresión según su prioridad a través de una lista doblemente enlazada.
==Sus atributos son aquellos de una lista doblemente enlazada común, pero se conoce a todo momento desde aqui la cabeza y la cola==
*/

public class PrintQueue {
    private PrintQueue siguiente;
    private PrintQueue anterior;
    private PrintQueue cabeza;
    private PrintQueue cola;
    private PrintJob impresion;

    /*
    Envía al queue una impresión que organiza según primero su prioridad, y luego su hora
     */
    public void enqueue(PrintJob impresion){
        PrintQueue nuevaImpresion = new PrintQueue();
        nuevaImpresion.impresion = impresion;
        if(this.cabeza == null) {
            nuevaImpresion.siguiente = null;
            nuevaImpresion.anterior = null;
            this.cabeza = nuevaImpresion;
            this.cola = nuevaImpresion;
        }
        else{
            PrintQueue cabezaIndice = this.cabeza;
            while(PrintManager.getInstance().valPrioridad(nuevaImpresion.impresion.getPrioridad()) < PrintManager.getInstance().valPrioridad(cabezaIndice.impresion.getPrioridad()) && cabezaIndice.siguiente != null) {
                cabezaIndice = cabezaIndice.siguiente;
                System.out.println("desplazo1");
            }
            if(PrintManager.getInstance().valPrioridad(impresion.getPrioridad()) == PrintManager.getInstance().valPrioridad(cabezaIndice.impresion.getPrioridad())) {
                while (impresion.getHoraDeEnvio().getTime() > cabezaIndice.impresion.getHoraDeEnvio().getTime() && cabezaIndice.siguiente != null) {
                    cabezaIndice = cabezaIndice.siguiente;
                    System.out.println("desplazo2");
                }
            }
            if(cabezaIndice.siguiente == null){
                cabezaIndice.siguiente = nuevaImpresion;
                nuevaImpresion.anterior = cabezaIndice;
                nuevaImpresion.siguiente = null;
                cola = nuevaImpresion;
            }
            else {
                nuevaImpresion.siguiente = cabezaIndice;
                nuevaImpresion.anterior = cabezaIndice.anterior;
                cabezaIndice.anterior = nuevaImpresion;
                if (cabezaIndice == this.cabeza) {
                    cabeza = nuevaImpresion;
                }
            }
        }
    }

    public void dequeue(){
        if(cabeza != null) {
            System.out.println(cabeza.impresion.toString());
            cabeza = cabeza.siguiente;
        }
        else System.out.println("No hay trabajos en queue");
    }

    public PrintQueue peek(){
        return cabeza;
    }

}
