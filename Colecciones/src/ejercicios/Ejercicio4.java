package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        /*
        Implementa una aplicación donde se piden por consola números reales hasta
que se introduce un 0. A medida que se leen del teclado, los valores positivos se
insertan en una colección y los negativos en otra. Al final, se muestran ambas
colecciones y las sumas de los elementos de cada una de ellas. Por último, se
eliminan de ambas todos los valores que sean mayores que 10 o menores de -
10 y se vuelven a mostrar.
         */
        // se piden por consola números reales hasta que se introduce un 0
//        A medida que se leen del teclado, los valores positivos se
//        insertan en una colección y los negativos en otra
        Scanner sc = new Scanner(System.in);
        int num = 0;
        List<Integer> positivos = new ArrayList<>();
        List<Integer> negativos = new ArrayList<>();
        int sumaPos = 0, sumaNeg = 0;
        do {
            System.out.print("Número: ");
            num = sc.nextInt();
            // los valores positivos se insertan en una colección y los negativos en otra.
            if (num > 0) { // no comprobamos == 0 porque en ese caso no entramos y nos vamos al final del bucle
                positivos.add(num);
                sumaPos += num; // sumaPos = sumaPos + num;
            } else if (num < 0) {
                negativos.add(num);
                sumaNeg += num; // sumaNeg = sumaNeg + num;
            }
        } while (num != 0); //hasta que se introduce un 0
        // Al final, se muestran ambas colecciones
        // y las sumas de los elementos de cada una de ellas (lo hemos hecho antes, pero también se podría hacer aquí con un nuevo for o iterador
        System.out.println("Positivos: " + positivos + " suman " + sumaPos);
        System.out.println("Negativos: " + negativos + " suman " + sumaNeg);

        /*
        Por último, se eliminan de ambas todos los valores que sean mayores que 10 o menores de -
10 y se vuelven a mostrar.
         */
        Iterator<Integer> itPos = positivos.iterator(); // creamos un iterador para recorrer la lista
        while (itPos.hasNext()) { // mientras queden elementos en la lista de positivos
            if (itPos.next() > 10) { // si el elemento siguiente es >10
                itPos.remove(); // lo eliminamos
            }
        }
        System.out.println("Positivos <= 10 " + positivos); // imprimimos de nuevo la lista

        Iterator<Integer> itNeg = negativos.iterator();
        while (itNeg.hasNext()) {
            if (itNeg.next() < -10) {
                itNeg.remove();
            }
        }
        System.out.println("Negativos <= -10 " + negativos); // imprimimos de nuevo la lista

    }
}
