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
    }

    static void imprimir(List<Persona> lista) {
        for (Persona elemento: lista) {
            System.out.println(elemento);
        }
    }
}