package clases.logicas;

import java.util.Date;

/*
Clase PrintJob:
Maneja la información de las impresiones que se tengan que hacer.
-nombreUsuario: El usuario que la solicitó
-horaDeEnvio: La hora en la que se hizo
-prioridad: La prioridad de su impresión
*/


public class PrintJob {
    private final String nombreUsuario;
    private final Date horaDeEnvio;
    private final Prioridad prioridad;

    public PrintJob(String nombreUsuario, Date horaDeEnvio) {
        this.nombreUsuario = nombreUsuario;
        this.horaDeEnvio = horaDeEnvio;
        prioridad = Prioridad.M;
    }

    public PrintJob(String nombreUsuario, Date horaDeEnvio, Prioridad prioridad) {
        this.nombreUsuario = nombreUsuario;
        this.horaDeEnvio = horaDeEnvio;
        this.prioridad = prioridad;
    }

    /*
    Formatea la clase para su sencilla impresión.
     */
    @Override
    public String toString(){
        return(nombreUsuario + " | " + horaDeEnvio.toString());
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public Date getHoraDeEnvio() {
        return horaDeEnvio;
    }

}
