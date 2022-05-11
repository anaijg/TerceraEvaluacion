package ejercicios.hoja1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicio3 {
    /*
    3. Recupera el contenido de elBuenMomento.dat del ejercicio1 y muéstralo por consola.
     */
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Binarios\\src\\ejercicios\\elBuenMomento.dat"))) {
            // lo recuperamos con readObject --> pero lo tenemos que convertir a string para poder obtenerlo como tal
            String contenido = (String) in.readObject();
            // ya tengo el contenido en un String, ahora no tengo más que imprimirlo
            System.out.println(contenido);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
