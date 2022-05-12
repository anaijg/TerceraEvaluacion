package AppUniversidad.dao;

import AppUniversidad.modelo.Alumno;
import AppUniversidad.modelo.Asignatura;

import java.sql.*;
import java.util.List;

public class AsignaturaDAO {
    private static Connection conectar() {
        // Conexión
        String url = "jdbc:sqlite:./JDBC/Universidad/Universidad.db";
        try  {
            Connection con = DriverManager.getConnection(url);
            /*if (con.isValid(5)) {
                System.out.println("Conexión establecida");
            }*/
            return con;     // aquí devolvemos la conexión y salimos del método (no la cerramos)

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;   // si ha ido mal la conexión no devolveremos nada
    }

    public static void create(Asignatura asignatura) {
        // necesitamos la conexión
        Connection con = conectar(); //llamamos al método conectar

        // Vamos a insertar el alumno en un registro de la base de datos
        // los valores en las consultas parametrizadas siempre se ponen como ?
        String sql = "INSERT INTO asignatura VALUES (?, ?, ?, ?, ?);";
        // creamos la consulta parametrizada
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            // le concretamos los valores
            pst.setInt(1, asignatura.getId());
            pst.setString(2, asignatura.getNombre());
            pst.setInt(3, asignatura.getNumHoras());
            pst.setDouble(4,asignatura.getPrecio());
            pst.setInt(5, asignatura.getDepartamentoId());
            // ahora la ejecutamos
            int registrosInsertados = pst.executeUpdate();
            System.out.println("Se han insertado " + registrosInsertados + " registros.");

            // antes de salir del método, cerramos la conexión
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Queremos también un método que cargue una lista de asignaturas
     *  Queremos que devuelva el número de asignaturas que se han insertado
     */
    public static void cargarLista(List<Asignatura> lista) {
        // Recibo la lista, extraigo los objetos
        lista.stream().forEach(asignatura -> create(asignatura));
    }

    /**
     * Devuelve una asignatrua de la base de datos
     * @param id
     * @return
     */
    public static Asignatura read(int id) {
        // Conectamos con la base de datos
        Connection con = conectar();

        // Ahora recuperamos los datos
        Asignatura a = null; // declaro aquí esta variable para poder devolverla fuera del try
        String consulta = "SELECT * FROM asignatura WHERE id = ?;"; // los valores con ?
        try {
            PreparedStatement pst = con.prepareStatement(consulta);
            // concretamos el ?
            pst.setInt(1, id); // en la consulta seleccionamos el id que nos dicen por parámetro
            ResultSet rs = pst.executeQuery();
            // antes de salir del método con el return vamos a cerrar la conexión

            // en el rs están los datos del alumno,
            // como tenemos que devolver una Asignatura, creamos un objeto asignatura con los datos del rs.
            while (rs.next()) {
                a = new Asignatura(rs.getInt("id"), rs.getString("nombre"),
                        rs.getInt("num_horas"), rs.getDouble("precio"), rs.getInt("departamento_id"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * Imprimimos todas las asignaturas que tenemos     *
     * y que nos cuente cuántas hay
     */
    public static void listarAsignaturas() {
        String sql = "SELECT asignatura.id, asignatura.nombre, departamento.nombre FROM asignatura JOIN departamento ON (asignatura.departamento_id = departamento.id);";
        Connection con = conectar();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int contador = 0;
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " - " +
                        rs.getString(2) + " dpto. " +
                        rs.getString(3));
                contador++;
            }
            System.out.println("Se han encontrado " + contador + " asignaturas.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Asignatura asignatura) {
        Connection con = conectar();
        String sql = "UPDATE asignatura SET nombre = ?, num_horas = ?, precio = ? WHERE id = ?;"; // el id nunca lo cambiamos
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, asignatura.getNombre());
            pst.setInt(2, asignatura.getNumHoras());
            pst.setDouble(3, asignatura.getPrecio());
            pst.setInt(4, asignatura.getDepartamentoId());
            int registrosModificados = pst.executeUpdate();
            System.out.println("Se han modificado " + registrosModificados + " registros.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        Connection con = conectar();
        String sql = "DELETE FROM asignatura WHERE id = ?;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            int registrosEliminados= pst.executeUpdate();
            System.out.println("Se han eliminado " + registrosEliminados + " registros.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
