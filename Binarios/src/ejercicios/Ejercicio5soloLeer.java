package ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5soloLeer {
    /*
    5.
    Grabar en el fichero numeros.dat una serie de números enteros no negativos introducidos por teclado. La serie acabará cuando escribamos -1.
    Abrir de núevo números.dat para lectura y leer todos los números hasta el final del fichero, mostrándolos por pantalla y copiándolos en un segundo fichero numerosCopia.dat.
     */
    public static void main(String[] args) {
        // Grabar en el fichero numeros.dat una serie de números enteros no negativos introducidos por teclado. La serie acabará cuando escribamos -1.
        Scanner sc = new Scanner(System.in);
        // como según entren los números tenemos que ir grabándolos en el fichero, voy a tener preparado to-do antes de pedir números
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Binarios\\src\\ejercicios\\numeros.dat"))) {
            // ya tengo to-do listo para grabar datos en el fichero
            int n = 0;
            do {
                n = sc.nextInt();
                // sólo lo grabaré si es >=0
                if (n >= 0) {
                    out.writeInt(n);
                }
            } while (n != -1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Aquí el fichero está ya cerrado

        //Abrir de núevo números.dat para lectura y leer todos los números hasta el final del fichero, mostrándolos por pantalla y copiándolos en un segundo fichero numerosCopia.dat.
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Binarios\\src\\ejercicios\\numeros.dat"))) { // abrimos el fichero para lectura
            // grabé los datos con writeInt() --> los voy a leer con readInt
            int n = 0;
            while (true) { // truco para que vaya avanzando en el fichero hasta que llegue al final, entonces saltará una excepción EOFexception y entonces parará
                 n = in.readInt();
                System.out.print(n + " ");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) { // tenemos que ponerla antes de IOException; y tenemos que añadirla para cuando lleguemos al final del fichero con el while(true)
            System.out.println("Final de fichero.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


   }
