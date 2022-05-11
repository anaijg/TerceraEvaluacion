package ejercicios.hoja2;

import java.io.*;
import java.util.Arrays;

/**
 * 2. Implementa el método Integer[] fusionar(String fichero1, String fichero2), al que
 * se le pasan los nombres de dos ficheros binarios que contienen dos listas
 * ordenadas de objetos Integer y devuelve un array ordenado con todos los
 * elementos de los dos ficheros fusionados.
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        // creo el array 1 de tamaño 10
        Integer[] a1 = crearArrayEnteros(10);
        //imprimeArray(a1);
        // creo el array 2 de tamaño 7
        Integer[] a2 = crearArrayEnteros(7);
        //imprimeArray(a2);
        // creo el fichero binario que guarda el array 1 (me devuelve la ruta en la que se crea
        String r1 = crearFicheroBinario("f1", a1);
        // creo el fichero binario que guarda el array 2
        String r2 = crearFicheroBinario("f2", a2);
        // llamo al método fusionar con las rutas de ambos ficheros
        Integer[] arrayFusionado = fusionar(r1, r2);
        // imprimo el array que devuelve el método fusionar
        imprimeArray(arrayFusionado);
    }

    // crear método Integer[] fusionar(String fichero1, String fichero2)
    // junta el contenido de dos ficheros en un único array y lo devuelve
    public static Integer[] fusionar(String fichero1, String fichero2) {

        Integer[] contenido1 = null;
        Integer[] contenido2 = null;
        // abrir el primer fichero y obtener el array que contiene
        // abrir el segundo fichero y obtener el array que contiene --> pongo los dos flujos juntos en el mismo try-with-resources
        try (ObjectInputStream in1 = new ObjectInputStream(new FileInputStream(fichero1));
             ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(fichero2)); ) {
            contenido1 = (Integer[]) in1.readObject();
            contenido2 = (Integer[]) in2.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // ahora tenemos que fusionar ambos arrays en uno solo
        // que tendrá el tamaño de los dos arrays juntos
        Integer[] total = new Integer[contenido1.length + contenido2.length];
        // lo fácil es añadir el primero
        for (int i = 0; i < contenido1.length; i++) {
            total[i] = contenido1[i];
        }
        // y ahora añadimos el segundo a continuación de los elementos del primero
        for (int i = 0 ; i < contenido2.length; i++) {
            total[contenido1.length + i] = contenido2[i];
        }
        // antes de devolverlo tenemos que ordenarlo
        Arrays.sort(total);
        return total;
    }

    // crear método Integer[] crearArrayEnteros(int tamaño)
    // crea un array de elementos random del tamaño indicado y lo devuelve
    public static Integer[] crearArrayEnteros(int tamaño) {
        Integer[] numeros = new Integer[tamaño];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100);
        }
        return numeros;
    }

    // método que crea un fichero binario con el nombre y el array que le pasamos
    // nos devuelve un String con la ruta del fichero
    public static String crearFicheroBinario(String nombre, Integer[] array) {
        // ruta
        String ruta = "Binarios\\src\\ejercicios\\hoja2\\" + nombre + ".dat";
        // Creo el fichero binario
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(array); // le digo que grabe en el fichero el array pasado por parámetro al método
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero o la ruta es incorrecta.");
            //e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return ruta;
    }

    // método que recibe un Integer[] y lo imprime
    public static void imprimeArray(Integer[] array) {
        System.out.println(Arrays.toString(array));
    }


}
