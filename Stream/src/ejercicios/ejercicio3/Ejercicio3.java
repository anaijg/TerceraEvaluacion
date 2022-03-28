package ejercicios.ejercicio3;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ejercicio3 {
    public static void main(String[] args) {
    // Metemos todo en un String
    String cadena = "Abadejo, Abejaruco, Abeja, Abejorro, Águila, Alacrán, Antílope, Babuino, Bacalao, Ballena, Barracuda, Bisonte, Búho, Caballo, Cebra, Chimpancé, Ciervo, Conejo, Cotorra, " +
            "Coyote, Debalí, Jirafa, Kiwi, Koala, Lagarto, Lince, Lobo, Mapache, Medusa, " +
            "Delfín, Dromedario, Elefante, Erizo, Foca, Gacela, Golondrina, Guepardo, Halcón, Hiena, Hormiga, Hurón, Iguana, JaMosca, Murciélago, Nutria, Ñu, Oso, Oveja, Paloma, Pantera, Perezoso, Reno, Ruiseñor, Salamandra, Sapo, Serpiente, Tiburón, Tigre, Tortuga, Urraca, Vaca, Yak, Zorro";

    cadena = cadena.replace(" ", ""); // quito los espacios dentro del String

    // la clase String tiene un método para estos casos: split() -> divide el String en elementos mirando qué carácter es el que los separa, y los guarda en un array
    String[] animales = cadena.split(",");

    // el método split sirve para coger un "fichero" con elementos separados por un cierto carácter y guardarlos en un array
        //System.out.println(Arrays.toString(animales));
        //System.out.println(animales[15]);

//        a) Crea un stream a partir de la lista.
            // o sea, del array
        Arrays.stream(animales)
                .forEach(animal -> System.out.print(animal + " "));
//        b) Muestra todos los animales que comiencen por una letra introducida por teclado.
        Arrays.stream(animales)
                .filter(animal -> animal.startsWith("A"))
                .forEach(animal -> System.out.println(animal));

//        c) Muestra el animal que tenga el nombre más largo, y el que tenga el nombre más corto
         String nombreLargo = Arrays.stream(animales)
                .max((a1, a2) -> a1.length() - a2.length())
                 .get(); // OJO; devuelve un optional, hay que poner el get
        System.out.println("Animal con el nombre más largo: " + nombreLargo);

        String nombreCorto = Arrays.stream(animales)
                .min((a1, a2) -> a1.length() - a2.length())
                .get();
        System.out.println("Animal con el nombre más corto: " + nombreCorto);
//        d) Muestra el número de animales que contiene la lista. --> o sea, el array
        long númeroAnimales = Arrays.stream(animales)
                .count();
        System.out.println("Número de animales: " + númeroAnimales);

    }
}
