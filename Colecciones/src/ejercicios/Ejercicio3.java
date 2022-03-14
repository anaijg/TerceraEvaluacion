package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        /*
        Implementar una aplicación donde se insertan 100 números enteros aleatorios
entre 1 y 10 incluidos, que pueden estar repetidos, en una colección. -> mostrar*/
        List<Integer> lista = new ArrayList<>(); // creamos la lista
        // la rellenamos con 100 elementos random entre 1 y 10
        for (int i = 0; i < 100; i++) {
            int num = (int) (Math.random() * 10 + 1);
            lista.add(num);
        }
        // la mostramos
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");

/* Después se eliminan todos los elementos que valen 5.
TIENE QUE SER CON UN ITERADOR.
Mostrar la colección antes y después de la eliminación. Utiliza un iterador.
         */
        // como tenemos que recorrer la misma lista, podemos utilizar el mismo iterador
        // para que vuelva al principio, lo tenemos que resetear
        it = lista.iterator();
        while (it.hasNext()) {
            // vamos a guardar el siguiente elemento en una variable tenporal para operar y que no de más de un salto
            int elementoActual = it.next();
            if (elementoActual == 5) {
                // resulta que el iterador tiene un método para quitar elementos
                it.remove();
            }
        }
        // la mostramos
        System.out.println("\nSin 5:");
        it = lista.iterator(); // reseteamos el iterador
        while (it.hasNext())
            System.out.print(it.next() + " ");
    }
}
