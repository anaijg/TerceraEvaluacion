package ejercicios.ejercicio4;

import java.util.function.Predicate;

public class MainPredicados {
    public static void main(String[] args) {
        // Define un predicado para comprobar si un entero es múltiplo de 5.
        Predicate<Integer> esMúltiploDe5 = n -> n % 5 == 0;
        System.out.println(esMúltiploDe5.test(15));

    // Define un predicado para comprobar si un
        //String no termina en “s”.


        // Define un predicado para comprobar si un
        //entero es par y múltiplo de 3.

        // Define un predicado para comprobar si un
        //carácter es una letra y está en mayúscula.

        // Define un predicado para comprobar si un
        //entero es impar y múltiplo de 7;

// Define un predicado para comprobar si un
//entero es impar o múltiplo de 7.
    }
}
