package comparadoresLambda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Zacarías", "Zapatero", 33));
        personas.add(new Persona("Yeison", "Ybarra", 25));
        personas.add(new Persona("María", "Avia", 28));
        personas.add(new Persona("Genara", "Daroca", 44));
        personas.add(new Persona("Ana María", "Flores", 15));
        imprimir(personas);

        System.out.println("\nOrdenados por nombre: ");
        //ComparadorNombre cNom = new ComparadorNombre();
        //personas.sort(new ComparadorNombre());
        personas.sort((Persona p1, Persona p2) -> p1.getNombre().compareTo(p2.getNombre()));
        imprimir(personas);


        System.out.println("\nOrdenar por apellidos: ");
        personas.sort((Persona p1, Persona p2) -> p1.getApellido().compareTo(p2.getApellido()));
        imprimir(personas);

        System.out.println("\nOrdenar por edad: ");
        personas.sort((Persona p1, Persona p2) -> p1.getEdad() - p2.getEdad());
        imprimir(personas);

    }

    static void imprimir(List<Persona> lista) {
        for (Persona elemento: lista) {
            System.out.println(elemento);
        }
    }
}