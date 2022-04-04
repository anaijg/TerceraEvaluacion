import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio6 {
    public static void main(String[] args) {
        /*
        6. A partir de una lista de 100 enteros aleatorios entre 0 y 1000, determina cuál es
el mayor, cuál es el menor, la suma de todos ellos y el valor promedio.
         */
        List<Integer> lista = new ArrayList<>(); // creamos la lista
        // la rellenamos de enteros aleatorios de 0 a 1000
        for (int i = 0; i < 100; i++) {
            lista.add((int) (Math.random() * 1000 + 0));
        }
        System.out.println(Arrays.toString(lista.toArray())); // convertimos la lista en array y la imprimimos
        long elMayor = lista.stream()
                .max((n1, n2) -> n1 - n2)
                .get();

        long elMenor = lista.stream()
                .min((n1, n2) -> n1 - n2)
                .get();

        long suma = lista.stream()
                .reduce(0, (acumulador, elemento) -> acumulador + elemento);

        double promedio = (double) suma / (double) 100; // también se puede hacer con count

        System.out.println("Mayor: " + elMayor + "\tMenor: " + elMenor + "\tSuma: " + suma + "\tPromedio: " + promedio);


    }
}
