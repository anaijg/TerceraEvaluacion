package ficheros.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio6 {
    /*
    6. Escribe un programa en Java que encuentre el número más grande
en el fichero dataset_91007.txt
     */
    public static void main(String[] args) {
        // con Scanner podemos ir leyendo el fichero número a número
        String ruta = "FicherosSnif\\src\\ficheros\\ejercicios\\dataset_91007.txt";
        File f = new File(ruta);
        try (Scanner lector = new Scanner(f)) { // con try-with-resources no hace falta cerrar el scanner
            int máximo = 0;
            while (lector.hasNextInt()) {
                int n = lector.nextInt(); // guardamos provisionalmente el número siguiente
                if (n > máximo) { // si pasa esto es que hemos encontrado un nuevo máximo
                    máximo = n;
                }
            }
            System.out.println("Mäximo: " + máximo);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
            //e.printStackTrace();
        }
    }
}
