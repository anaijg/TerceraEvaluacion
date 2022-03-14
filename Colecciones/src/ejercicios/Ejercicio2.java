package ejercicios;

import java.util.*;

public class Ejercicio2 {
    /*
    Implementar una aplicación en la que se insertan 20 números enteros aleatorios
entre 1 y 10 (incluidos), que pueden estar repetidos, en una colección. A
continuación, se crea una lista con los mismos elementos sin repeticiones.
     */
    public static void main(String[] args) {
        // se insertan 20 números enteros aleatorios
        //entre 1 y 10 (incluidos),
        // que pueden estar repetidos  --> lista        , en una colección.

        // Creamos la lista
        List<Integer> lista = new ArrayList<>();

        // Insertamos 20 enteros aleatorios entre 1 y 10
        for (int i = 0; i < 20; i++) {
            int num = (int) (Math.random() * 10 + 1); // generamos el número aleatorio, lo guardo en num
            lista.add(num);  // lo meto en la lista
        }
        // la mostramos
        System.out.print("Colección: ");
        for (Integer elemento: lista) {
            System.out.print(elemento + " ");
        }

        //continuación, se crea una lista con los mismos elementos sin repeticiones
        Set<Integer> conjunto = new HashSet<>();
        conjunto.addAll(lista);
        System.out.printf("\nConjunto: ");
        Iterator<Integer> it = conjunto.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
