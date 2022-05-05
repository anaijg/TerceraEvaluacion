package AppUniversidad.interfaz;

import AppUniversidad.modelo.Alumno;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Alumno a1 = new Alumno(1, "Alba Alonso", "Av. Andalucía, 3", "111111111");
        //System.out.println(a1);

        // Queremos meter este objeto en la base de datos -> tabla alumno
        // Conexión
        String url = "jdbc:sqlite:./JDBC/Universidad/Universidad.db";
        try (Connection con = DriverManager.getConnection(url)) { // con esta estructura try-with-resources no tengo que cerrar la conexión
            /*if (con.isValid(5)) {
                System.out.println("Conexión establecida");
            }*/
            // Vamos a insertar el alumno en un registro de la base de datos
            // los valores en las consultas parametrizadas siempre se ponen como ?
            String sql = "INSERT INTO alumno VALUES (?, ?, ?, ?);";
            // creamos la consulta parametrizada
            PreparedStatement pst = con.prepareStatement(sql);
            // le concretamos los valores
            pst.setInt(1, a1.getId());
            pst.setString(2,a1.getNombre());
            pst.setString(3,a1.getDireccion());
            pst.setString(4,a1.getTelefono());
            // ahora la ejecutamos
            //int registrosInsertados = pst.executeUpdate();
            //System.out.println("Se han insertado " + registrosInsertados + " registros.");


            // Ahora recuperamos los datos
            String consulta = "SELECT * FROM alumno;";
            pst = con.prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("nombre") + " - " + rs.getString("direccion") + " - " + rs.getString("telefono"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
