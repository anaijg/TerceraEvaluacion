package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
//        Crear una lista con 40 números enteros entre -20 y 20. A partir de ella,
        List<Integer> lista = new ArrayList<>();

        // fórmula: Math.random() * (max - min + 1) + min
        for (int i = 0; i < 40; i++) {
            lista.add((int) (Math.random() * (20 - (-20) + 1) + (-20)));
        }

//        a. Crear dos Stream, uno con los números positivos y otro con los
//        negativos, todos ellos sin repetir.
//                b. Mostrar por pantalla el número de elementos de cada Stream.
//                c. Crear otro Stream para contar los números que están comprendidos
//        entre -10 y 10 incluidos, sin repeticiones.
    }
}
