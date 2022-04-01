package ficheros.texto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeerFicheroComoString {
    public static void main(String[] args) {
        // Leer todo el texto de un archivo como una sola cadena

        String ruta = "FicherosSnif\\src\\excepciones\\";
        String nombre = "OtroEjemploExcepciones.java";
        // Quiero leer este fichero e imprimirlo

        // Declaro un String donde voy a guardar todo el contenido del fichero
        // y luego lo instancio y en el constructor escribo: String(Files.readAllBytes(Paths.get(ruta)));
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(ruta + nombre)));

            // ya tenemos guardado en contenido el contenido del fichero
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
