package ejercicios.hoja1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Ejercicio4 {
    public static void main(String[] args) {
        /*
        4. Recupera los datos guardados en el fichero del ejercicio 2, y muéstralos por consola.
         */
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Binarios\\src\\ejercicios\\10.dat"))) {
            // habíamos guardado los datos como un double[] --> así los vamos a recuperar
            double[] datos = (double[]) in.readObject(); // lee los datos, los convierte en double[] y los guarda en la variable datos
            System.out.println(Arrays.toString(datos));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
