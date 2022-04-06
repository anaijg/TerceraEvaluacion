package ficheros.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
    /*
    4. Partiendo del fichero de csv de ejemplo, crear un programa de
Java que cree una copia de ese fichero llamada “Restaurants2.csv” que contenga los mismos datos excepto
aquellos correspondientes a los restaurantes cuyo código postal empieza por 6
     */
    public static void main(String[] args) {
        // vamos a leer de
        String rutaOrigen = "FicherosSnif\\src\\ficheros\\ejercicios\\Restaurantes.csv";
        File origen = new File(rutaOrigen);

        // y vamos a escribir
        String rutaDestino = "FicherosSnif\\src\\ficheros\\ejercicios\\Restaurantes2.csv";
        File destino = new File(rutaDestino);

        // vamos a abrir el fichero origen y leer línea a línea
        try {
            // como sé que tengo que leer por un lado y luego escribir. creo un scanner y un filewriter
            Scanner lector = new Scanner(origen);
            FileWriter fw = new FileWriter(destino, true); // queremos que vaya añadiendo -> append = true
            // vamos leyendo
            String línea;
            while (lector.hasNextLine()) {
                línea = lector.nextLine(); // guardamos la siguiente línea
                String[] campos = línea.split(",");
                // campos[4] es el código postal
                if (!campos[4].startsWith("6")) { // los que no empiezan por 6 los copio en el destino
                    // si no empieza por 6, escribimos la línea en el destino
                    fw.write(línea+"\n");
                }
            }


            fw.close();
            lector.close(); // con try-catch siempre hay que cerrar
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
