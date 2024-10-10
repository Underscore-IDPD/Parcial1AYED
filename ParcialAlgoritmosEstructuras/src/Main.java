
import clases.controlador.PrintManager;
import clases.logicas.PrintJob;
import clases.logicas.Prioridad;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        PrintManager pm = new PrintManager();
        pm.utilizarServicio().anadirTrabajo(new PrintJob("Samuel Gondres", new Date()));
        pm.utilizarServicio().anadirTrabajo(new PrintJob("Don Alfonso", new Date(), Prioridad.L));
        pm.utilizarServicio().anadirTrabajo(new PrintJob("Ciruela Pasa", new Date(), Prioridad.H));
        pm.utilizarServicio().imprimirTrabajos(3);

        pm.utilizarServicio().imprimirTrabajos(5);
    }
}