package clases.logicas;

import clases.estructuras.PrintQueue;

/*
Clase PrintService:
Maneja el queue y la inserción e impresión de trabajos
- printQueue: Guarda una referencia al Queue
*/

public class PrintService {
    private final PrintQueue printQueue = new PrintQueue();

    public void anadirTrabajo(PrintJob PJ){
        printQueue.enqueue(PJ);
        System.out.println("Se ha añadido el trabajo al queue de impresión");
    }

    public void imprimirTrabajos(int n){

        for (int i = 0; i < n; i++) {
            if (printQueue.peek() == null){
                System.out.println("\nNo hay más impresiones para hacer.");
                break;
            }
            printQueue.dequeue();
        }

        System.out.println("\nTodas las Impresiones se han completado.");

    }

}
