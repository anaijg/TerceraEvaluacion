package ejercicios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    /*
    2. Pedir un entero n por teclado, y, a continuación, pedir n números de tipo double, que iremos
insertando en un array. Guardar el array en un archivo binario con la extensión .dat.
     */
    public static void main(String[] args) {
        // Pedir un entero n por teclado,
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // y, a continuación, pedir n números de tipo double,
        // que iremos insertando en un array
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextDouble();
        }
        System.out.println(Arrays.toString(array));

        // Guardar el array en un archivo binario con la extensión .dat.
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Binarios\\src\\ejercicios\\" + n + ".dat"))) {

            out.writeObject(array);

        } catch (FileNotFoundException e) { // los catch tienen que ir del más particular al más general
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error genérico");
        }
    }
}
