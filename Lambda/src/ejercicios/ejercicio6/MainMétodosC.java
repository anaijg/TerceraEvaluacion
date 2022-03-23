package ejercicios.ejercicio6;

import ejercicios.ejercicio2.Paciente;

import java.util.ArrayList;
import java.util.List;

public class MainMétodosC {
    public static void main(String[] args) {
        saludar("Don Pepito");

        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Felipe R.", 54, new String[]{"nauseas", "mareos"}));
        pacientes.add(new Paciente("Irene M.", 32, new String[]{"tos", "cansancio", "mareos"}));
        pacientes.add(new Paciente("Carmen C.", 15, new String[]{"ansiedad"}));
        pacientes.add(new Paciente("Santiago A.", 8, new String[]{"fractura de cadera"}));
        pacientes.add(new Paciente("Isabel A.", 60, new String[]{"tos", "amnesia", "fiebre", "dolor"}));
        imprimirPacientes(pacientes);

    }

    /*
    Escribe un método que reciba un nombre
y muestre un saludo.
     */
    static void saludar(String nombre) {
        System.out.println("Hola, " + nombre);
    }

   /*
   Escribe un método que reciba una lista de
pacientes (ver ejercicio anterior) y
muestre sus datos.
    */
    static void imprimirPacientes(List<Paciente> lista) {
        for (Paciente elemento: lista) {
            System.out.println(elemento);
        }
    }

}
