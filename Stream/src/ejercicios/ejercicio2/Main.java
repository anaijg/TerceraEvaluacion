package ejercicios.ejercicio2;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        /*Nombre Edad Arma Es humano
        Gandalf Integer.MAX_VALUE Bastón No
        Aragorn 88 Espada Sí
        Gimli 140 Hacha No
        Legolas 2931 Arco No
        Boromir 41 Espada Sí
        Frodo 51 Anillo No
        Sam 33 Espada No
    */
        List<Personaje> personajes = new ArrayList<>();
        personajes.add(new Personaje("Gandalf", Integer.MAX_VALUE, Personaje.Arma.BASTÓN, false));
        personajes.add(new Personaje("Aragorn", 88, Personaje.Arma.ESPADA, true));
        personajes.add(new Personaje("Gimli", 140, Personaje.Arma.HACHA, false));
        personajes.add(new Personaje("Legolas", 2931, Personaje.Arma.ARCO, false));
        personajes.add(new Personaje("Boromir", 41, Personaje.Arma.ESPADA, true));
        personajes.add(new Personaje("Frodo", 51, Personaje.Arma.ANILLO, false));
        personajes.add(new Personaje("Sam", 33, Personaje.Arma.ESPADA, false));
        System.out.println(personajes);

//        Filtrar los personajes que sean jóvenes (menos de 90 años) y lleven espada.
        System.out.println("\"Jóvenes\" con espada:");
        personajes.stream()
                .filter(personaje -> personaje.getEdad() <= 90 && personaje.getArma().equals(Personaje.Arma.ESPADA))
                .forEach(personaje -> System.out.print(personaje));
//        Filtrar los personajes que no usan espada.
            // filtraremos los que tienen espada, que es más fácil, y lo que nos dé lo negaremos
        System.out.println("\nPersonajes sin espada");
        personajes.stream()
                .filter(personaje -> !personaje.getArma().equals(Personaje.Arma.ESPADA))
                .forEach(personaje -> System.out.print(personaje));

//        Muestra los personajes ordenados por orden alfabético.
        System.out.println("\nPersonajes por orden alfabético: ");
        // en el sorted le tenemos que indicar por qué criterio queremos ordenar,
        // igual que vimos con los comparadores
        personajes.stream()
                .sorted((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()))
                .forEach(personaje -> System.out.print(personaje));

//        Muestra los personajes humanos.
        System.out.println("\nPersonajes humanos");
        personajes.stream()
                .filter(personaje -> personaje.isEsHumano())
                .forEach(personaje -> System.out.print(personaje));

//        Muestra el personaje más viejo.
        System.out.println("\nPersonaje más viejo:");
        // queremos obtener la edad mayor, la máxima de todas las edades de la lista
        Personaje personajeMasViejo = personajes.stream()
                .max((p1, p2) -> p1.getEdad() - p2.getEdad())
                .get();
        System.out.println(personajeMasViejo);

        /* System.out.println(personajeMasViejo = personajes.stream()
                .max((p1, p2) -> p1.getEdad() - p2.getEdad())
                .get());
        */

    }
}
