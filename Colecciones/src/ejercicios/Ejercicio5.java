package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
//Crear una lista de números enteros positivos introducidos por consola hasta
//que se introduzca uno negativo.
        Scanner sc = new Scanner(System.in);
        List<Integer> números = new ArrayList<>();
        int num = 0; // para guardar temporalmente el número que vamos pidiendo
        do {
            System.out.print("Num: ");
            num = sc.nextInt();
            if (num >= 0) {
                números.add(num);
            }
        } while (num >= 0);
        System.out.println(números);

//A continuación, recorrer la lista y mostrar por pantalla los índices de los elementos de valor par,
//que será multiplicado por 100.
        Iterator<Integer> it = números.iterator();
        // para lo de los índices, o bien utilizo un for "normal", y el índice es i
        // o bien creo aquí una variable i y la voy incrementando en cada vuelta
        int i = 0;
        while (it.hasNext()) {
            num = it.next(); // reutilizo la variable num
            if (num % 2 == 0) {
                System.out.println("Índice " + i + " valor: " + num + " * 100= " + (num * 100));
            }
            i++; // antes de salir del bucle, incrementamos el valor del índice
        }

    }
}
