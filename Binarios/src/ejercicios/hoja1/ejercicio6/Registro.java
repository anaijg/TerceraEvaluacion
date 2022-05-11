package ejercicios.hoja1.ejercicio6;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// necesitamos implementar Serializable para poder grabar los objetos de tipo Registro en un fichero binario
public class Registro implements Serializable {
    /*
    Cada registro constará de la temperatura en grados centígrados, introducida por teclado,
    y la fecha y hora, que se leerá del sistema en el momento de la creación del registro.
     */
     int temperatura;
     // LocalDate -> es para la fecha, sin más
    // LocalDateTime -> es para fecha y hora
    LocalDateTime fechaYHora;

    public Registro(int temperatura) {
        this.temperatura = temperatura;
        //que se leerá del sistema en el momento de la creación del registro.
        this.fechaYHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        // **** NEW ****** ¡¡¡ formateamos la fecha y la hora !!!
        // 1) Creamos un formato con la clase DateTimeFormatter
        DateTimeFormatter formato = DateTimeFormatter
                .ofPattern("dd-MM-yyyy HH:mm");

        return "Registro{" +
                "temperatura=" + temperatura +
                ", fechaYHora=" + fechaYHora.format(formato) +
                '}';
    }
}
