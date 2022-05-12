package AppUniversidad.interfaz;

import AppUniversidad.dao.AsignaturaDAO;
import AppUniversidad.modelo.Asignatura;

import java.util.ArrayList;
import java.util.List;

public class MainAsignatura {
    public static void main(String[] args) {
        Asignatura a1 = new Asignatura(1, "Redes", 7, 130, 1);
        // la cargamos en la base de datos
        //AsignaturaDAO.create(a1);

        // Vamos a probar el método cargarLista
        List<Asignatura> asignaturas = new ArrayList<>();
        asignaturas.add(new Asignatura(2, "Programacion", 8, 140, 4));
        asignaturas.add(new Asignatura(3, "Bases de datos", 6, 120, 4));
        asignaturas.add(new Asignatura(4, "Lenguajes de Marcas", 4, 100, 4));
        //AsignaturaDAO.cargarLista(asignaturas);

        // Vamos a probar el método read
        //Asignatura resultado = AsignaturaDAO.read(1);
        //System.out.println(resultado);

        // Vamos a modificar una asignatura
        a1.setPrecio(70);
        //AsignaturaDAO.update(a1);

        // Eliminamos
        //AsignaturaDAO.delete(1);

        // Listamos las asignaturas
        AsignaturaDAO.listarAsignaturas();

    }
}
