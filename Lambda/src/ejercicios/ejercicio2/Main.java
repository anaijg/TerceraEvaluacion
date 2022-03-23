package ejercicios.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Partiendo de la clase Paciente, haz una lista de cinco pacientes con los datos de
la tabla y muéstralos ordenados por nombre, por edad y por número de
síntomas, utilizando el método sort y expresiones lambda. Puedes hacer una
versión en que se muestre un menú preguntando por qué criterio queremos
ordenar.
         */

        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Felipe R.", 54, new String[]{"nauseas", "mareos"}));
        pacientes.add(new Paciente("Irene M.", 32, new String[]{"tos", "cansancio", "mareos"}));
        pacientes.add(new Paciente("Carmen C.", 15, new String[]{"ansiedad"}));
        pacientes.add(new Paciente("Santiago A.", 8, new String[]{"fractura de cadera"}));
        pacientes.add(new Paciente("Isabel A.", 60, new String[]{"tos", "amnesia", "fiebre", "dolor"}));
        imprimir(pacientes);

        int opción = 0;

        do {
            opción = menú(); // sacamos el menú a un método estático
            // Elegir qué muestro
            switch (opción) { // según la opción elegida, muestro una cosa u otra, o voy al default
                case 1:
                    // Ordenar por nombre
                    pacientes.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
                    System.out.println("\nOrdenados por nombre:");
                    imprimir(pacientes);
                    break;
                case 2:
                    // Ordenar por edad
                    pacientes.sort((p1, p2) -> p1.getEdad() - p2.getEdad());
                    System.out.println("\nOrdenados por edad: ");
                    imprimir(pacientes);
                    break;
                case 3:
                    // Ordenar por nº de síntomas
                    pacientes.sort((p1, p2) -> p1.getSíntomas().length - p2.getSíntomas().length);
                    System.out.println("\nOrdenados por nº de síntomas");
                    imprimir(pacientes);;
                    break;
                default:
                    if (opción != 0) {
                        System.out.println("Opción no válida");
                    }
            }
        } while (opción != 0);
    }

    public static void imprimir(List<Paciente> list) {
        for (Paciente elemento: list) {
            System.out.println(elemento);
        }
    }

    public static int menú() {
        Scanner sc = new Scanner(System.in);
        int opción = 0;

        // Menú
        System.out.println("¿Por qué criterio quieres ordenar?\n1. Nombre\n2. Edad\n3.Nº de síntomas\n0. Salir");

        opción = sc.nextInt();
        sc.nextLine(); // para "limpiar" el scanner después de un nextInt
        return opción;
    }
}
