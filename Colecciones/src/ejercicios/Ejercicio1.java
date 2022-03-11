package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        /*
Implementar una aplicación que pida por consola números enteros no
negativos hasta que se introduce -1. --> do while
Los números se irán insertando en una colección, pudiéndose repetir.
Al terminar, se mostrará la colección por pantalla.
A continuación, se mostrarán todos los valores pares. --> iterador
Por último, se eliminarán todos los múltiplos de 3 --> remove
y se mostrará por pantalla la colección resultante.
         */
        Scanner sc = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
        int num = 0;
        do {
            System.out.print("Número: "); // pedimos número
            num = sc.nextInt(); // metemos número
            // Los números se irán insertando en una colección, pudiéndose repetir.
            if (num >= 0) { // si no es negativo, lo guardamos
                lista.add(num);
            }
            // si es negativo no lo guardamos pero seguimos
        } while (num != -1); // salimos cuando el num = -1

        // Al terminar, se mostrará la colección por pantalla.
        System.out.println("Mostramos la lista");
        System.out.println(lista);

        // A continuación, se mostrarán todos los valores pares.
        // ya tenemos la colección, la recorremos con un iterador
        System.out.println("Mostramos los pares");
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) { // si hay un elemento más, entramos
            Integer elemento = it.next(); // guardamos el siguiente elemento
            // comprobamos si el elemento es par, para mostrarlo
            if (elemento % 2 == 0) {
                System.out.print(elemento + " ");
            }
        }

        // Por último, se eliminarán todos los múltiplos de 3 --> remove
        // Ojo, porque el iterador lo tenemos "gastado", al final
        // lo tenemos que resetear
        it = lista.iterator();
        while (it.hasNext()) {
            Integer elemento = it.next(); // "cogemos" el siguiente elemento
            // si es múltiplo de 3, lo eliminaremos de la lista
            if (elemento % 3 == 0) {
                it.remove();
            }
        }

        //y se mostrará por pantalla la colección resultante.
        System.out.println("Eliminamos los múltiplos de 3");
        System.out.println(lista);

    }
}
