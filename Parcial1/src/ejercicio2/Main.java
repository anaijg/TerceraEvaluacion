package ejercicio2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        crearCarpeta();
        for (int i = 0; i < 3; i++) {
            crearFicha();
        }
        eliminarFicha("Garfield");
    }

    public static void crearCarpeta() {
        /*
        debe contener el código
necesario para crear una carpeta llamada Archivador, dentro del
paquete de este ejercicio, donde iremos guardando todas las fichas de
los pacientes. Tener en cuenta lo siguiente:
a. La ruta será relativa.
b. Comprobar si la carpeta existe. Si no existe, la creamos.
         */
        String ruta = "Parcial1\\src\\ejercicio2\\Archivador";
        File f = new File(ruta);
        // b. Comprobar si la carpeta existe. Si no existe, la creamos.
        if (!f.exists()) {
            boolean creada = f.mkdir();
            System.out.println("Creada");
        }
    }

    public static void crearFicha() {
        /*
        pide por teclado los datos de la mascota: nombre, animal (perro, gato,
etc...), edad y color, y los guardamos en un fichero que se llama igual que la mascota dentro de la carpeta
Archivador. También escribimos en cada ficha la fecha en que se crea.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Animal:");
        String animal = sc.nextLine();
        System.out.println("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Color: ");
        String color = sc.nextLine();

        String ruta = "Parcial1\\src\\ejercicio2\\Archivador\\" + nombre;
        File f = new File(ruta);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write("Nombre: " + nombre);
            fw.write("\nAnimal: " + animal);
            fw.write("\nEdad: " + edad);
            fw.write("\nColor: " + color);
            fw.write("\nFecha: " + LocalDate.now());


            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void eliminarFicha(String nombre) {
        /*
        le pasamos el nombre de la mascota y eliminamos la
ficha correspondiente. Si la operación tiene éxito debe indicárnoslo con un mensaje. Hay que gestionar las
posibles excepciones por cualquiera de los métodos existentes.
         */
        String ruta = "Parcial1\\src\\ejercicio2\\Archivador\\" + nombre;
        File f = new File(ruta);
        boolean eliminada = f.delete();
        if(eliminada) {
            System.out.println("Ficha eliminada");
        }
    }
}
