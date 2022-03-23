package ejercicios.ejercicio5;

import java.util.function.Function;

public class MainFunction {
    public static void main(String[] args) {
// Define una función para devolver la longitud de
//un String.
        Function<String, Integer> f1 = s -> s.length();
        System.out.println("1. " + f1.apply("Rosalía"));

        // Define una función que devuelva el cuadrado de
        //un entero.
        Function<Integer, Integer> f2 = n -> (int) Math.pow(n, 2);
        System.out.println("2. " + f2.apply(4));

        // Define una función que devuelva el 10% de un
        //número.
        Function<Double, Double> f3 = n -> n * 10 / 100;
        System.out.println("3. " + f3.apply(85.0));
    }
}
