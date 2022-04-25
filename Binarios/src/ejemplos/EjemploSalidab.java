package ejemplos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * Aquí hago lo mismo, pero guardando todo el array de golpe, no número a número
 */
public class EjemploSalidab {
    public static void main(String[] args) {
        // que queremos guardar en disco los números enteros que tenemos en un array.
        int[] enteros = new int[10];
        for (int i = 0; i < enteros.length; i++) {
            enteros[i] = (int) (Math.random() * 1000);
        }
        System.out.println(Arrays.toString(enteros));

        // esos datos queremos guardarlos en un fichero binario
        String ruta = "Binarios\\enteros2.dat";
        // lo que hay que hacer es:
        // 1) Creamos un fichero de salida con FileOutputStream al que indicamos la ruta y el nombre del fichero
        try {
            FileOutputStream ficheroSalida = new FileOutputStream(ruta);
            // 2) Tenemos que pasarle este fichero a un flujo de salida (ObjectOutputStream) que seralice los datos del fichero
            ObjectOutputStream flujoSalida = new ObjectOutputStream(ficheroSalida); // con este también pueden saltar excepciones, pero como ya lo tenemos dentro del try y tenemos los catch adecuados en este caso, no tenemos que hacer nada al respecto

            // Esto también podría ser
            //ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("Binarios\\enteros.dat"));

            // una vez que tenemos el flujo de salida la creado, no tenemos más que utilizar los métodos write que consideremos para
            // escribir en el fichero
/*
            for (int i = 0; i < enteros.length; i++) {
                flujoSalida.writeInt(enteros[i]); // estoy recorriendo el array de enteros, y escribiendo cada elemento en el fichero
            }
*/

            // el método writeObject Escribe un objeto serializable en el ObjectOutputStream.
            flujoSalida.writeObject(enteros);

            flujoSalida.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada. " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) { // esta la pongo porque puede haber problemas al cerrar el fichero
            System.out.println("Problema de E/S " + e.getMessage());
            e.printStackTrace();
        }
    }
}
