package ejercicios.ejercicio4;

import java.util.function.Predicate;

public class MainPredicados {
    public static void main(String[] args) {
        // Define un predicado para comprobar si un entero es múltiplo de 5.
        Predicate<Integer> esMúltiploDe5 = n -> n % 5 == 0;
        System.out.println("1. " + esMúltiploDe5.test(15));

        // Define un predicado para comprobar si un String no termina en “s”.
        Predicate<String> noTerminaEns = s -> !s.endsWith("s");
        System.out.println("2. "+ noTerminaEns.test("Xocas"));
        System.out.println("3. " + noTerminaEns.test("Ibai"));

        // Define un predicado para comprobar si un
        //entero es par y múltiplo de 3.
        Predicate<Integer> parYMúltiploDe3 = n -> n % 2 == 0 && n % 3 == 0;
        System.out.println("4. " + parYMúltiploDe3.test(6));

        // Define un predicado para comprobar si un
        //carácter es una letra y está en mayúscula.

        // Define un predicado para comprobar si un
        //entero es impar y múltiplo de 7;

// Define un predicado para comprobar si un
//entero es impar o múltiplo de 7.
    }
}
