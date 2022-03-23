package ejercicios.ejercicio6;

import ejercicios.ejercicio2.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainConsumer {
    public static void main(String[] args) {
       /*
       Define un Consumer que reciba un nombre y
muestre un saludo.
        */
        Consumer<String> saluda = nombre -> System.out.println(nombre);
        // Con métodos referencia
        Consumer<String> saluda2 = System.out::println;
        saluda2.accept("Don Pepito");

     /*
     Define un Consumer que reciba una lista de
pacientes y muestre sus datos.
      */
        Consumer<List<Paciente>> imprimirPacientes = lista -> {
            for (Paciente elemento: lista) {
                System.out.println(elemento);
            }
        };
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Felipe R.", 54, new String[]{"nauseas", "mareos"}));
        pacientes.add(new Paciente("Irene M.", 32, new String[]{"tos", "cansancio", "mareos"}));
        pacientes.add(new Paciente("Carmen C.", 15, new String[]{"ansiedad"}));
        pacientes.add(new Paciente("Santiago A.", 8, new String[]{"fractura de cadera"}));
        pacientes.add(new Paciente("Isabel A.", 60, new String[]{"tos", "amnesia", "fiebre", "dolor"}));

        imprimirPacientes.accept(pacientes);
    }
}
