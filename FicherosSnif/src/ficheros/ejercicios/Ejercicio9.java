package ficheros.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio9 {
    /*
    9. Escribir un programa que obtiene la línea de mayor tamaño y la
de menor tamaño dentro de un fichero de texto.
     */
    public static void main(String[] args) {
        // tenemos que ir leyendo línea a línea
        String ruta = "FicherosSnif\\src\\ficheros\\ejercicios\\Restaurantes.csv";
        File f = new File(ruta);
        try (Scanner lector = new Scanner(f)) { // no hace falta close()

            // variables que voy a necesitar para ir guardando los tamaños y las líneas "que me interesan"
            int tamañoMayor = 0, tamañoMenor = 1000;
            String líneaMásLarga = null, líneaMásCorta = null;

            while (lector.hasNextLine()) {
                String línea = lector.nextLine();
                // vamos a ver si es mayor que lo que tengo hasta ahora
                if (línea.length() > tamañoMayor) {
                    tamañoMayor = línea.length();
                    líneaMásLarga = línea; // guardo la línea que acabo de leer, ya que es la más larga hasta el momento
                } else if (línea.length() < tamañoMenor) {
                    tamañoMenor = línea.length();
                    líneaMásCorta = línea;
                }
            }
            System.out.println("Línea más larga: " + líneaMásLarga + " (" + tamañoMayor + " caracteres)");
            System.out.println("Línea más corta: " + líneaMásCorta + " (" + tamañoMenor + " caracteres)");

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
            //e.printStackTrace();
        }
    }
}
