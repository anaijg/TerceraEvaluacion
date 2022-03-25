package ejemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class EjemplosColección {
    public static void main(String[] args) {
        // creamos una lista con 20 números aleatorios entre 10 y -10
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lista.add((int) (Math.random() * 21 -10));
        }
        /*for (Integer e: lista) {
            System.out.print(e + " ");
        }

        System.out.println("\n");*/
        Stream<Integer> listaStream = lista.stream();
        listaStream.sorted().forEach(n -> System.out.print(n + " ")); // operación terminal, no me deja seguir usándolo

        System.out.println();
        listaStream = lista.stream(); // con esto lo reasignamos
        //listaStream.distinct().forEach(n -> System.out.print(n + " ")); // y entonces puedo seguir usándolo hasta volver a cerrarlo
        // ahora tendría que volver a reasignarlo, etc...


        // para evitar el error por cerrar el stream, y evitarnos el paso de reasignar (aunque se puede hacer así),
        // lo que vamos a hacer en general es no asignarlo a una variable de tipo Stream, sino crearlo, usarlo y cerrarlo todo seguido
        // DIGO EN GENERAL, NO SIEMPRE TIENE QUE SER ASÍ
        System.out.println("\nFiltrado");
        lista.stream()
                .filter(n -> n >= 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\nObtengo los elementos distintos que tiene la colección");
        lista.stream()
                .distinct()
                .forEach(n -> System.out.print(n + " "));

        // vamos a ordenar los elementos que tenemos
        System.out.println("\nOrdenados");
        lista.stream()
                .sorted()
                .distinct()
                .forEach(n -> System.out.print(n + " "));

        // map -> transforma los elementos de la colección en otra cosa
        // vamos a obtener el valor absoluto de los números de la lista
        System.out.println("\nObtenemos valor absoluto");
        lista.stream()
                .map(n -> Math.abs(n))
                .sorted()
                .forEach(n -> System.out.print(n + " "));

        System.out.println("\nMostramos el primer elemento de la lista");
        Optional resultado = lista.stream()
                .findFirst(); // el tipo optional lo guardamos en una variable
        System.out.println(resultado); // y lo mostramos tal cual
        // para obtener el elemento que contiene un optional, usamos el método get
        System.out.println(resultado.get());

        System.out.println("\nMostramos el número más grande de la lista");
        Integer máximo = lista.stream()
                .max((n1, n2) -> n1 - n2)
                .get();// como devuelve un optional, pongo al final el get
        System.out.println(máximo);

        System.out.println("\nContamos los elmentos de la lista");
        long numElementos = lista.stream()
                .count();
        System.out.println(numElementos);


        System.out.println("Suma de todos los elementos de la lista: ");
        // como el resultado final es un único número, lo guardamos en una variable y luego la imprimimos
        int suma = lista.stream().reduce(0, (acumulator, elemento) -> acumulator + elemento);
        System.out.println("Suma de todos: " + suma);

        // El ejemplo de la otra página con explicaciones, pero no hacer mucho caso
/*
        System.out.println("\nReduce con string");
        List<String> letters = List.of("A","B","C","D","A","E","A");

        AtomicInteger i = new AtomicInteger();
        letters.stream()
                .reduce("", (acumulator, element)-> {
                    if (element.equalsIgnoreCase("A")) {
                        i.getAndIncrement();
                        System.out.println("Dentro del if  "+ acumulator + "(" + i + ")"  + element);
                        return acumulator+element;

                    }
                    System.out.println("Fuera del if  "+ acumulator);
                    return acumulator;
                });

*/
    }
}
