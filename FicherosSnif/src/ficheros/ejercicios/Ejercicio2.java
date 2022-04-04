package ficheros.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        /* 2. Partiendo del fichero de csv de ejemplo, crear un programa de
Java que muestre los datos de todos aquellos restaurantes cuyo
código postal empiece por 6.
         */
        // Primero abrimos el fichero
        // nos interesa leerlo línea a línea -> Scanner
        String ruta = "FicherosSnif\\src\\ficheros\\ejercicios\\Restaurantes.csv";
        File f = new File(ruta);
        try {
            Scanner lector = new Scanner(f); // con esto "abrimos el fichero"
            String línea;
            String[] campos = null;
            while (lector.hasNextLine()) {
                línea = lector.nextLine(); // cojo una línea para procesarla
                campos = línea.split(","); // la divido en sus campos y guardo los valores en un array de String: campos[0] sería el nombre, etc.
                if (campos[4].startsWith("6")) { // campos[4] es el código postal
                    System.out.println(línea);
                }
            }


            lector.close(); // antes de salir, "cerramos" el fichero
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
            //e.printStackTrace();
        }
    }
}
