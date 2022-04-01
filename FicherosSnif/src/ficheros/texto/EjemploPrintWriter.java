package ficheros.texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class EjemploPrintWriter {
    public static void main(String[] args) {
        // para escribir ficheros con algo más de formato
        String ruta = "FicherosSnif\\src\\ficheros\\texto\\";
        // si el fichero no existe, nos lo creará
        String nombre = "Escribiendo3.txt";
        File f = new File(ruta + nombre);
        // el objeto para escribir de tipo PrintWriter se crea como el FileWriter
        // aprovechamos y probamos el try-with-resources, que me ahorra tener que utilizar close
        // porque cierra el objeto automáticamente
        try (PrintWriter pw = new PrintWriter(f)) { // entre paréntese creamos el objeto
            pw.println(Math.PI);
            pw.printf("%.2f", Math.PI);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
    }
}
