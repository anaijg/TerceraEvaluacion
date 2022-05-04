package ejercicios.ejercicio6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio6ConMétodos {
    /*
    Implementar un programa que registre la evolución temporal de la temperatura en una ciudad.
    La aplicación mostrará un menú que permita añadir nuevos registros de temperatura y mostrar el listado de todos los registros históricos.
    Cada registro constará de la temperatura en grados centígrados, introducida por teclado, y la fecha y hora, que se leerá del sistema en el momento de la creación del registro.
     */
    static Scanner sc = new Scanner(System.in);
    static String ruta = "Binarios\\src\\ejercicios\\ejercicio6\\registros.dat"; // como siempre es el mismo fichero, ponemos la ruta estática para acceder desde toda la clase

    public static void main(String[] args) {


        // Y ahora esta lista la grabamos en un fichero binario


        comprobarFichero();

        escribirRegistro();

        leerFichero();

    }

    private static void escribirRegistro() {
        // Pedimos la temperatura

        // Creamos un registro
        Registro r = new Registro(18);
        System.out.println(r.toString());

        // Recupera los registros que tenemos ya escritos
        List<Registro> lista = new ArrayList<>(); // cambiar esto para que sea leído

        // Añado el registro a la lista
        lista.add(r);

        // Escribo la lista en el fichero binario
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) { // utilizamos try-with-resources para no tener que cerrarlo nosotros, se cierra automáticamente
                out.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void comprobarFichero() {
        // Lo primero, por si acaso, es crear el fichero si no existe
        File f = new File(ruta);
        // si el fichero ya existe se saltará esta parte
        if (!f.exists()) {
            try {
                boolean creado = f.createNewFile();
                System.out.println("Se acaba de crear el fichero.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static ArrayList<Registro> leerFichero() {
        // Comprobamos si existe para que no nos salte una excepción
        comprobarFichero();

        // Ahora vamos a leer el fichero y que nos muestre lo que tiene por pantalla
        ArrayList<Registro> fichero = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ruta))) {
            // hemos escrito con writeObject -> readObject; he guardado un ArrayList, pues recupero eso mismo
            fichero = (ArrayList<Registro>) in.readObject(); // leo el contenido -> lo convierto en un ArrayList de Registro y lo guardo en la variable fichero
            // muestro el contenido de la lista recuperada
            fichero.stream().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado o ruta incorrecta.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fichero;
    }
}
