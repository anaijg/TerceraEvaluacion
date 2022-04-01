package ficheros.texto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {
    public static void main(String[] args) {
        // Utilizamos la clase FileWriter pasándole un File
        String ruta = "FicherosSnif\\src\\ficheros\\texto\\";
        // si el fichero no existe, nos lo creará
        String nombre = "Escribiendo.txt";
        File f = new File(ruta + nombre);
        // append es opcional, lo que indica es:
        // true -> si hay contenido ya en ese fichero, escribe a continuación
        try {
            FileWriter escritor = new FileWriter(f);
            // una vez creado este objeto FileWriter, utilizamos el método write para escribir
            escritor.write("Queda menos de una semana..."); // como no le hemos puesto append = true, machacará la información cada vez que ejecutemos el programa
            // si quiero seguir escribiendo, lo sigo llamando
            escritor.append("\nEstoy probando si este método me lo pone en una nueva línea.");
            // cuando terminamos de escribir, lo cerramos con el método close()
            for (int i = 0; i < 10; i++) {
                escritor.append("\n" + i);
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("Problema: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
