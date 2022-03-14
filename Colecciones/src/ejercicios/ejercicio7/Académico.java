package ejercicios.ejercicio7;

public class Académico implements Comparable{
    /*
    Implementar la clase Académico, cuyos atributos son el nombre y el año de
ingreso. El criterio de ordenación natural será por nombres. --> sólo un atributo --> Comparable
     */
    String nombre;
    int añoIngreso;

    public Académico(String nombre, int añoIngreso) {
        this.nombre = nombre;
        this.añoIngreso = añoIngreso;
    }

    // El criterio de ordenación natural será por nombres. --> sólo un atributo --> Comparable
    @Override
    public int compareTo(Object o) {
        Académico a = (Académico) o; // convertimos el objeto del parámetro en un objeto de tipo Académico
        return this.nombre.compareTo(a.nombre);
    }
}
