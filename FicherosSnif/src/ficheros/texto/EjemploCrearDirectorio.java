package ficheros.texto;

import java.io.File;
import java.util.Scanner;

public class EjemploCrearDirectorio {
    public static void main(String[] args) {
        // empezamos teniendo clara la ruta y el nombre
        // quiero crear un fichero en esta ruta
        String ruta = "FicherosSnif\\src\\ficheros\\texto\\";
        // preguntamos qué nombre queremos darle
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del directorio:");
        String nombre = sc.nextLine();

        // A continuación, creamos el objeto File
        File nuevoDirectorio = new File(ruta + nombre);
        boolean creado = nuevoDirectorio.mkdir(); // te crea directamente ese directorio en concreto
        // si puede crear el directorio, en creado se almacenará true
        if (creado) {
            System.out.println("El directorio se ha creado correctamente.");
        } else { // si creado = false es que o ya existe o la ruta está mal
            System.out.println("El directorio ya existe o no existe la ruta especificada.");
            if (nuevoDirectorio.exists()) {
                System.out.println("La carpeta ya existe");
            } else {
                // vamos a comprobar si esa ruta existe
                File comprobarRuta = new  File(ruta);
                if (!comprobarRuta.exists()) {
                    System.out.println("La ruta no existe.");
                } else {
                    System.out.println("Yo qué sé.");
                }
            }
        }
    }
}
