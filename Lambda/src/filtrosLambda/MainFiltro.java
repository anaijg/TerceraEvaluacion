package filtrosLambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainFiltro {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Zacarias", "Zapatero", 33));
        personas.add(new Persona("Yeison", "Zapatero", 33));
        personas.add(new Persona("Yeison", "Ybarra", 25));
        personas.add(new Persona("Joseph", "Ybarra", 25));
        personas.add(new Persona("Maria", "Avia", 28));
        personas.add(new Persona("Michael", "Gutierrez", 28));
        personas.add(new Persona("Genara", "Daroca", 44));
        personas.add(new Persona("Genaro", "Valle", 44));
        personas.add(new Persona("Ana Maria", "Flores", 15));
        personas.add(new Persona("Eva", "Zapatero", 44));
        //imprimir(personas);

        // Pedimos un nombre para filtrar
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre para filtrar: ");
        String nombre = sc.nextLine();

        //List<Persona> resultado = buscarPorNombre(nombre, personas);
        //imprimir(resultado);

        FiltroPersonaNombre filtroPersonaNombre = new FiltroPersonaNombre(nombre);
        //  si quiero filtrar por apellido, crearía la clase correspondiente y la instancio aquí
        // y los mismo para filtrar por edad
        List<Persona> resultado = buscarPorFiltro(filtroPersonaNombre, personas);
        imprimir(resultado);


    }

    static void imprimir(List<Persona> lista) {
        for (Persona elemento: lista) {
            System.out.println(elemento);
        }
    }

    // Mëtodo filtrar por nombre: hemos creado la interfaz FiltroPersona
    // Y luego hemos hecho una clase que la implementa: FiltroPersonNombre
    // ahora en vez de pasar un nombrer le vamos a pasar un filtro
    // devuelve otra lista con las personas que tienen ese nombre
    static List<Persona> buscarPorFiltro(FiltroPersona filtro, List<Persona> listaCompleta) {
        // creamos la lista que vamos a devolver
        List<Persona> listaFiltrada = new ArrayList<>();
        // recorrer la lista completa y, si el nombre coincide, metemos a la persona en la lista filtrada
        Iterator<Persona> it = listaCompleta.iterator();
        while (it.hasNext()) {
            Persona p = it.next(); // avanzamos una vez el iterador y "cogemos" esa persona
            // si la persona tiene ese nombre. la metemos en la listaFiltrada
            if (filtro.test(p)) {
                listaFiltrada.add(p);
            }
        }
        return listaFiltrada;
    }

    // con esta solución nos ahorramos un método para cada criterio, porque el filtro vale para todo
    // lo único es que ahora tendremos que instanciar la clase que implementa la interfaz (ver el main)
}
