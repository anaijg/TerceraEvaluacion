import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatoFechas {
    public static void main(String[] args) {
        // Formatos de fecha
        // a) Para poner un LocalDate en un formato ES
        LocalDate hoy = LocalDate.of(2022, 5, 4);
        // Para darle formato necesitamos un DateFormatter
        // el patrón no es más que un String con la forma que queremos
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Formato 1:" + hoy.format(formato1));
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("d-MMM-yy");
        System.out.println("Formato 2:" + hoy.format(formato2));
        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        System.out.println("Formato 3: " + hoy.format(formato3));

        // Formato de fecha y hora
        LocalDateTime ahora = LocalDateTime.of(2022, 5, 4, 18, 30, 00);
        DateTimeFormatter formatoFechaYHora = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Formato fecha y hora: " + ahora.format(formatoFechaYHora));
        // si no quiero que muestre los segundos
        DateTimeFormatter formatoFechaYHora2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println("Formato fecha y hora (sin segundos): " + ahora.format(formatoFechaYHora2));



        // b) Ahora tenemos la fecha como un String y queremos guardarla como un LocalDate
        // Esto es lo que tendremos en las bases de datos
        String fecha = "2022-07-01";
        DateTimeFormatter deStringAFechaJava = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaEnJava = LocalDate.parse(fecha, deStringAFechaJava);
        System.out.println(fechaEnJava);

    }
}
