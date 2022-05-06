package AppUniversidad.interfaz;

import AppUniversidad.dao.AlumnoDAO;
import AppUniversidad.modelo.Alumno;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
       Alumno a1 = new Alumno(1, "Alba Alonso", "Av. Andalucía, 3", "111111111");
        //System.out.println(a1);

       //Alumno a2 = new Alumno(2,"Benito Blanco", "Calle Bruto, 1", "222222222");
       // Insertamos el alumno en la base de datos
        // tenemos que invocar al método create de la clase AlumnoDAO
        // como es un método estático, lo llamamos a través del nombre de la clase
        //AlumnoDAO.create(a2);

        // Recuperamos los datos de los dos alumnos
        for (int i = 1; i < 3; i++) {
            Alumno a = AlumnoDAO.read(i);
            System.out.println(a);
        }

        // Alba Alonso se muda a la calle Mundanza, 3
        a1.setDireccion("Hoy es viernes y el cuerpo lo sabe, 3");
        AlumnoDAO.update(a1);
        // Para ver si se ha modificado en la base de datos después de llamar al método update,
        // llamamos al método read para esta misma alumna
        AlumnoDAO.read(1);

        // Vamos a eliminar al id 2 de la base de datos
        AlumnoDAO.delete(2);


    }
}
