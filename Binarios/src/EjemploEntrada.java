import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/**
 * Aquí vamos a leer el fichero enteros.dat
 * que hemos escrito número a número, con writeInt
 */
public class EjemploEntrada {
    public static void main(String[] args) {
        // como siempre, tenemos que indicarle dónde está el fichero binario a leer
        String ruta = "Binarios\\enteros.dat";
        // 1) Creamo un FileInputStream para el archivo, diciéndole la ruta del fichero
        try {
            FileInputStream ficheroEntrada = new FileInputStream(ruta);
            // 2) Necesitamos deserializar el fichero, que viene en bytes, y para eso creamos un flujo de entrada al que pasamos el fichero
            ObjectInputStream flujoEntrada = new ObjectInputStream(ficheroEntrada);
            // 3) Ya sólo nos queda leer los datos; para cada método write existe el método read correspondiente
            // como el fichero enteros.dat lo escribimos con writeInt(), vamos a leerlo con readInt()
            // como esos datos van a entrar en un array, vamos a declararlo antes
            int[] leidos = new int[10];
            for (int i = 0; i < leidos.length; i++) {
                leidos[i] = flujoEntrada.readInt(); // leo cada número del fichero y lo guardo en la posición que toque (i) del array
            }
            // ahora vemos si lo hemos leído bien, mostrando el contenido del array por pantalla
            System.out.println(Arrays.toString(leidos));


            flujoEntrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
