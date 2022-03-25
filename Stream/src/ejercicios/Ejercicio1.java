package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
//        Crea una lista de enteros con 20 elementos aleatorios entre 1 y 15.
//        Utilizando streams,
//        haz lo siguiente:
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            lista.add((int) (Math.random() * 15 +1));
        }

//        a. Imprime todos los elementos de la lista, sin ordenar.
        System.out.println("a. ");
        lista.stream()
                .forEach(n -> System.out.print(n + " "));

        //        b. Imprime todos los elementos de la lista, ordenados.
        System.out.println("\nb. ");
        lista.stream()
                .sorted()
                .forEach(n -> System.out.print(n + " "));

//        c. Imprime todos los elementos de la lista, sin repetir, ordenados.
        System.out.println("\nc. ");
        lista.stream()
                .distinct()
                .sorted()
                .forEach(n -> System.out.print(n + " "));

//        d. Imprime sólo los mayores o iguales a 5.
        System.out.println("\nd.");
        lista.stream()
                .filter(n -> n >=5)
                .forEach(n -> System.out.print(n + " "));

//        e. Imprime sólo los mayores o iguales a 5, ordenados.
        System.out.println("\ne.");
        lista.stream()
                .filter(n -> n >= 5)
                .sorted()
                .forEach(n -> System.out.print(n + " "));

//        f. Imprime sólo los mayuores o iguales a 5, ordenados inversamente.
        System.out.println("\nf. ");
        lista.stream()
                .filter(n -> n >= 5)
                .sorted((n1, n2) -> n2 - n1)
                .forEach(n -> System.out.print(n + " "));

//        g. Suma todos los elementos de la lista.
        System.out.println("\ng.");
        int suma = lista.stream()
                .reduce(0, (comparador, elemento) -> comparador + elemento);
        System.out.println("Suma = " + suma);

//        h. Suma todos los elementos mayores o iguales a 5.
        System.out.println("\nh.");
        suma = lista.stream()
                .filter(n -> n >= 5)
                .reduce(0, (acumulador, elemento) -> acumulador + elemento);
        System.out.println("Suma de los >=5 = " + suma);

        //        i. Calcula el promedio de todos los elementos de la lista.
        System.out.println("\ni.");
        double numerador = lista.stream().reduce(0, (a, b) -> a + b);
        double denominador = lista.stream().count();
        System.out.println("Promedio: " + (numerador / denominador));

    }
}
