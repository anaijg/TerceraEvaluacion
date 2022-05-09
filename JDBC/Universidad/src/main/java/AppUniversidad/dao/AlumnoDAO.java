package AppUniversidad.dao;

import AppUniversidad.modelo.Alumno;

import java.sql.*;
import java.util.List;

/**
 * Esta clase contiene toda la gestión de los alumnos
 * en la base de datos: altas, bajas, consultas y modificaciones (CRUD)
 */
public class AlumnoDAO {
    /**
     * El método conectar crea una conexión con la base de datos y la devuelve
     * @return conexión con la base de datos
     */
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

    public static void create(Alumno alumno) {
        // necesitamos la conexión
        Connection con = conectar(); // llamamos al método conectar

        // Vamos a insertar el alumno en un registro de la base de datos
        // los valores en las consultas parametrizadas siempre se ponen como ?
        String sql = "INSERT INTO alumno VALUES (?, ?, ?, ?);";
        // creamos la consulta parametrizada
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            // le concretamos los valores
            pst.setInt(1, alumno.getId());
            pst.setString(2,alumno.getNombre());
            pst.setString(3,alumno.getDireccion());
            pst.setString(4,alumno.getTelefono());
            // ahora la ejecutamos
            int registrosInsertados = pst.executeUpdate();
            System.out.println("Se han insertado " + registrosInsertados + " registros.");

            // antes de salir del método, cerramos la conexión
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recibe el id de un alumno, lo recupera de la base de datos y devuelve un objeto de tipo Alumno con los datos encontrados
     * @param id del alumno
     * @return Alumno encontrado en la base de datos
     */
    public static Alumno read(int id) {
            // Conectamos con la base de datos
        Connection con = conectar();

        // Ahora recuperamos los datos
        Alumno a = null; // declaro aquí esta variable para poder devolverla fuera del try
        String consulta = "SELECT * FROM alumno WHERE id = ?;"; // los valores con ?
        try {
            PreparedStatement pst = con.prepareStatement(consulta);
            // concretamos el ?
            pst.setInt(1, id); // en la consulta seleccionamos el id que nos dicen por parámetro
            ResultSet rs = pst.executeQuery();
            // antes de salir del método con el return vamos a cerrar la conexión

            // en el rs están los datos del alumno,
            // como tenemos que devolver un Alumno, creamos el alumno con los datos del rs.
            while (rs.next()) {
                a = new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("telefono"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public static void update(Alumno alumno) {
        Connection con = conectar();
        String sql = "UPDATE alumno SET nombre = ?, direccion = ?, telefono = ? WHERE id = ?;"; // el id nunca lo cambiamos
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, alumno.getNombre());
            pst.setString(2, alumno.getDireccion());
            pst.setString(3, alumno.getTelefono());
            pst.setInt(4, alumno.getId());
            int registrosModificados = pst.executeUpdate();
            System.out.println("Se han modificado " + registrosModificados + " registros.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        Connection con = conectar();
        String sql = "DELETE FROM alumno WHERE id = ?;";
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

    public static int obtenerUltimoId() {
        Connection con = conectar();
        String sql = "SELECT MAX(id) FROM alumno;";
        ResultSet rs = null;
        int ultimoId = 0;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            if (!rs.equals(null)) {
                // si está vacío no entra aquí y el ultimoId se mantiene en 0
                ultimoId = rs.getInt(1); // guardamos en ultimoId el contenido de la columna única que nos devuelve el MAX
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener último id: " + e.getMessage());
            e.printStackTrace();
        }
        return ultimoId;
    }




}
