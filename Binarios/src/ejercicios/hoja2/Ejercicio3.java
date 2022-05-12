package ejercicios.hoja2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 3. Implementa el método void fusionar(String ficheroBase, String ficheroNuevo),
 * que añade a ficheroBase los elementos de ficheroNuevo, ambos ordenados. Al
 * final, ficheroBase contiene la lista ordenada de todos los elementos de ambos
 * ficheros.
 */


public class Ejercicio3 {
    public static void main(String[] args) {
        // crear lista 1 con 250 Integer aleatorios (por ejemplo)
        List<Integer> lista1 = crearListaEnteros(250);

        // crear lista 2 con 150 Integer aleatorios (por ejemplo)
        List<Integer> lista2 = crearListaEnteros(150);

        // las imprimimos para ver qué tenemos en ellas
        //imprimeLista(lista1);
        //System.out.println();
        //imprimeLista(lista2);

        // crear fichero 1 con la primera lista (guardamos la ruta que devuelve)
        String rutaFicheroBase = crearFicheroBinario("ficheroBase", lista1);

        // crear fichero 2 con la segunda lista (guardamos la ruta que devuelve)
        String rutaFicheroNuevo = crearFicheroBinario("ficheroNuevo", lista2);

        // fusionamos el contenido de ambos ficheros
        fusionar(rutaFicheroBase, rutaFicheroNuevo);

    }


    public static void fusionar(String ficheroBase, String ficheroNuevo) {
        /*
        añade a ficheroBase los elementos de ficheroNuevo, ambos ordenados. Al
 * final, ficheroBase contiene la lista ordenada de todos los elementos de ambos
 * ficheros.
         */
        // abrir y leer ficheroBase
        // abrir y leer ficheroNuevo

        List<Integer> contenidoFicheroBase = null;
        List<Integer> contenidoFicheroNuevo = null;
        try (ObjectInputStream in1 = new ObjectInputStream(new FileInputStream(ficheroBase));
                ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(ficheroNuevo))) {
            // leemos -> creamos una variable para guardar lo que contiene
            contenidoFicheroBase = (List<Integer>) in1.readObject();
            contenidoFicheroNuevo = (List<Integer>) in2.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // juntar el contenido de ambos ficheros en una lista
        contenidoFicheroBase.addAll(contenidoFicheroNuevo); // meto en la lista contenidoFicheroBase to-do lo que hay en contenidoFicheroNuevo
        //imprimeLista(contenidoFicheroBase);
        // guardar esta lista (ordenada) en ficheroBase
        contenidoFicheroBase.sort(((n1, n2) -> n1 - n2)); // la ordenamos
        //imprimeLista(contenidoFicheroBase);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ficheroBase))) {
            out.writeObject(contenidoFicheroBase); // guardamos en el fichero la lista que contiene lo de ambas listas
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Integer> crearListaEnteros(int tamaño) {
        List<Integer> lista = new ArrayList<>(tamaño); // no es necesario poner el tamaño porque las listas son dinámicas
        // tenemos que rellenarla con números enteros
        // hacemos un for con una línea de código que me genera un número random y lo añade a la lista
        for (int i = 0; i < tamaño; i++) {
            lista.add((int) (Math.random() * 100));
        }
        return lista;
    }

    /**
     * el método recibe el nombre que vamos a dar al fichero y también la lista que vamos a guardar en él
     * @param nombre
     * @param lista
     * @return la ruta en la que está el fichero
     */
    public static String crearFicheroBinario(String nombre, List<Integer> lista) {
        String ruta = "Binarios\\src\\ejercicios\\hoja2\\" + nombre + ".dat";
        // para grabar el fichero
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(lista);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ruta;
    }

    public static void imprimeLista(List<Integer> lista) {
        // si utilizamos stream
        //lista.stream().forEach(elemento -> System.out.print(elemento + " "));

        // otra forma es con for o foreach
        for (Integer elemento: lista) {
            System.out.print(elemento + " ");
        }
        System.out.println(); // añadimos esto al final para que lo siguiente que imprimamos sea en otra línea
    }

}
