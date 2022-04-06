package ficheros.ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ejercicio7 {
    /*
    7. Escribir un programa que contenga un método que reciba por parámetro la ruta de un archivo 
    y devuelva un array con las cadenas que dicho archivo almacena. 
    Las cadenas vienen separadas por un asterisco.
     */
    public static void main(String[] args) {
        String ruta = "FicherosSnif\\src\\ficheros\\ejercicios\\cadenas.txt";
        String[] resultado = devolverCadenas(ruta);
        Arrays.stream(resultado).forEach(cadena -> System.out.println(cadena));
    }
    
    public static String[] devolverCadenas(String ruta) {
        // tenemos que leer el fichero que está en esa ruta
        // me interesa coger todo en un string y luego "trocear" 
        String[] cadenas = null;
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(ruta))); 
            cadenas = contenido.split("\\*"); // tenemos que "escapar" el asterisco
        } catch (IOException e) {
            System.out.println("Ha ocurrido un problema: " + e.getMessage());
            //e.printStackTrace();
        }

        return cadenas;
    }
}
