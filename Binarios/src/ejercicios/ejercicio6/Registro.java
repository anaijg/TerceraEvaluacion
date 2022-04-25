package ejercicios.ejercicio6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Registro {
    /*
    Cada registro constará de la temperatura en grados centígrados, introducida por teclado, y la fecha y hora, que se leerá del sistema en el momento de la creación del registro.
     */
     int temperatura;
     // LocalDate -> es para la fecha, sin más
    // LocalDateTime -> es para fecha y hora
    LocalDateTime fechaYHora;

    public Registro(int temperatura, LocalDateTime fechaYHora) {
        this.temperatura = temperatura;
        this.fechaYHora = fechaYHora;
    }

    @Override
    public String toString() {
        // **** NEW ****** ¡¡¡ formateamos la fecha y la hora !!!
        // 1) Creamos un formato con la clase DateTimeFormatter
        DateTimeFormatter formato = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.SHORT) // en esta línea elegimos formato SHORT o MEDIUM
                .withLocale(Locale.getDefault());

        return "Registro{" +
                "temperatura=" + temperatura +
                ", fechaYHora=" + fechaYHora +
                '}';
    }
}
