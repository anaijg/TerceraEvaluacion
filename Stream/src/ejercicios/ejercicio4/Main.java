package ejercicios.ejercicio4;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cliente[] clientes = {
          new Cliente("11111111A", "Asdrúbal", LocalDate.of(2004, 12, 15)),
          new Cliente("22222222B", "Benito", LocalDate.of(2001, 5, 6)),
          new Cliente("33333333C", "Carlota", LocalDate.of(1988, 7, 9)),
          new Cliente("44444444D", "Demetria", LocalDate.of(2002, 10, 10)),
          new Cliente("55555555E", "Esperanza", LocalDate.of(1972, 2, 2))
        };

        for (int i = 0; i < clientes.length; i++) {
            System.out.println(clientes[i]);
        }

//        a) Escribe una tubería que muestre los clientes ordenados por fecha de
//        nacimiento.
        System.out.println("\nOrdenados por fecha de nacimiento");
        Arrays.stream(clientes)
                .sorted((c1, c2) -> c1.fechaNacimiento.compareTo(c2.fechaNacimiento))
                .forEach(cliente -> System.out.println(cliente));


    }
}
