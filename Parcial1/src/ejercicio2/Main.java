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
        eliminarFicha("Blanquita");
    }

    public static void crearCarpeta() {
        String ruta = "Parcial1\\src\\ejercicio2\\Archivador";
        File f = new File(ruta);
        if (!f.exists()) {
            f.mkdir();
        }
    }

    public static void crearFicha() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Animal: ");
        String animal = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Color: ");
        String color = sc.nextLine();

        String ruta = "Parcial1\\src\\ejercicio2\\Archivador";
        File f = new File(ruta + "\\" + nombre);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write("Nombre: " + nombre);
            fw.write("\nAnimal: " + animal);
            fw.write("\nEdad: " + edad);
            fw.write("\nColor: " + color);
            fw.write("\nFecha: " + LocalDate.now().getDayOfMonth() + "\\" + LocalDate.now().getMonthValue() +"\\" + LocalDate.now().getYear());
            fw.close();
        } catch (IOException e) {
            System.out.println("No se ha podido crear la ficha: " + e.getMessage());
            //e.printStackTrace();
        }
    }

    public static void eliminarFicha(String nombre) {
        String ruta = "Parcial1\\src\\ejercicio2\\Archivador";
        File f = new File(ruta + "\\" + nombre);
        boolean eliminado = f.delete();
        if (eliminado) {
            System.out.println("La ficha de " + nombre + " ha sido eliminada.");
        }
    }

}
