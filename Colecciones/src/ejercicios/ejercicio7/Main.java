package ejercicios.ejercicio7;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
        Implementar un programa donde se crean cinco objetos Académico, que se
insertan en un mapa en el que la clave es la letra del sillón que ocupan, y el
valor un objeto de la clase Académico.
         */

        // de momento lo hacemos todo en main
        Académico álvaro = new Académico("Álvaro Pombo", 2004); // j
        Académico javier = new Académico("Javier Marías", 2008); // R
        Académico juan = new Académico("Juan Gil", 2011); // e
        Académico joseluis = new Académico("Jose Luis Gómez", 2014); //Z
        Académico paz = new Académico("Paz Battaner", 2017); // s

        // mapa en el que la clave es la letra del sillón que ocupan, y el
        //valor un objeto de la clase Académico.
        Map<Character, Académico> academia = new HashMap<>(); // creamos el mapa vacío
        // para añadirle pares <K, V>
        academia.put('j', álvaro);
        academia.put('R', javier);
        academia.put('e', juan);
        academia.put('Z', joseluis);
        academia.put('s', paz);

        /* Para recorrer el mapa e imprimir los valores y las claves, adapto el siguiente for
        for (String clave:mapa.keySet()) {
    int valor = mapa.get(clave);
    System.out.println("Clave: " + clave + ", valor: " + valor);}
         */

        for (Character clave: academia.keySet()) { // recorro un "array" de claves
            Académico valor = academia.get(clave);
            System.out.println("Sillón " + clave + ": " + valor.nombre + " (" + valor.añoIngreso + ")");
        }

    }


}
