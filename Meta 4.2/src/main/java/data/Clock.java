package data;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Reloj con uso de un nuevo Thread, para mantener independencia
 * @author <a href="github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */

public class Clock extends Timer {
    private String segundos = "00";
    private String minutos = "00";
    private String horas = "00";

    /**
     * Crea el nuevo Thread con TimerTask
     */
    public Clock() {
        schedule(new TimerTask() {
            @Override
            public void run() {
                getDateInternal();
            }
        }, 0, 1000L);
    }

    private void getDateInternal() {
        final Date date = new Date();

        segundos = date.getSeconds() + "";
        if(segundos.length() < 2) segundos = "0" + segundos;

        minutos = date.getMinutes() + "";
        if(minutos.length() < 2) minutos = "0" + minutos;

        horas = date.getHours() + "";
        if(horas.length() < 2) horas = "0" + horas;
    }

    /**
     * @return La hora con formato 00:00:00
     */
    public String getDateToString() {
        return horas + ":" + minutos + ":" + segundos;
    }
}
