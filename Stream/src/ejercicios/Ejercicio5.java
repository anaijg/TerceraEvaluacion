package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio5 {
    public static void main(String[] args) {
//        Crear una lista con 40 números enteros entre -20 y 20. A partir de ella,
        List<Integer> lista = new ArrayList<>();

        // fórmula: Math.random() * (max - min + 1) + min
        for (int i = 0; i < 40; i++) {
            lista.add((int) (Math.random() * (20 - (-20) + 1) + (-20)));
        }
        for (int elemento: lista) {
            System.out.print(elemento + " ");
        }
        System.out.println();
//        a. Crear dos Stream, uno con los números positivos y otro con los
//        negativos, todos ellos sin repetir.
        lista.stream().distinct().filter(n -> n >= 0).forEach(n -> System.out.print(n + " "));
//                b. Mostrar por pantalla el número de elementos de cada Stream.
        System.out.println();
        lista.stream().distinct().filter(n -> n < 0).forEach(n -> System.out.print(n + " "));
//                c. Crear otro Stream para contar los números que están comprendidos
//        entre -10 y 10 incluidos, sin repeticiones.
        System.out.println();
        long númerosIntervalo = lista.stream().distinct().filter(n -> n >= -10 && n <= 10).count();
        System.out.print(númerosIntervalo);
    }
}
