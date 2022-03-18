package ejercicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio6 {
    public static void main(String[] args) {
//        Insertar en una lista 20 enteros aleatorios entre 1 y 10. A partir de ella, crear un
//        conjunto con los elementos de la lista sin repetir, otro con los repetidos y otro
//        con los elementos que aparecen una sola vez en la lista original.

        List<Integer> listaOriginal = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listaOriginal.add((int) (Math.random() * 10 + 1));
        }

        // Ordenamos la lista para facilitar la visualización de los elementos originales
        listaOriginal.sort((n1, n2) -> n1 - n2);
        System.out.println("Lista original: " + listaOriginal);

        // Creamos una lista para los elementos sin que aparezcan las repeticiones
        Set<Integer> sinRepeticiones = new HashSet<>();
        // le pasamos la lista original es este conjunto para que quite las repeticiones
        sinRepeticiones.addAll(listaOriginal);
        System.out.println("Lista original pero sin repeticiones: " + sinRepeticiones);

        // Quitamos de la lista original todos los elementos de la lista anterior para quedarnos
        // con una lista que contiene sólo las repeticiones
        for (Integer elemento : sinRepeticiones) {
            listaOriginal.remove(elemento); // quito los elementos que no se repiten
            // y, de los que se repiten, quito el primero
        }
        System.out.println(listaOriginal);
        // para no liarnos, creamos un conjunto para guardar esta nueva lista y eliminar las repeticiones
        Set<Integer> repetidos = new HashSet<>();
        repetidos.addAll(listaOriginal);
        System.out.println("Elementos que en la lista original se repiten: " + repetidos);

        //  Ahora necesitamos los elementos únicos
        Set<Integer> únicos = new HashSet<>();
        // La lista únicos la rellenamos inicialmente con todos los elementos distintos que aparecen
        únicos.addAll(sinRepeticiones);
        // y le quitamos los que estaban repetidos en la lista original
        únicos.removeAll(repetidos);
        System.out.println("Elementos únicos en la lista original: " + únicos);
    }
}
