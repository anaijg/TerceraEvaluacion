package AppUniversidad.dao;

import AppUniversidad.modelo.Departamento;

import java.sql.*;

public class DepartamentoDAO {

    // conectar
    private static Connection conectar() {
        // Conexión
        String url = "jdbc:sqlite:./JDBC/Universidad/Universidad.db";
        try {
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

    // crea un registro en la tabla departamento
    public static void create(Departamento departamento) {
        Connection con = conectar();
        String sql = "INSERT INTO departamento (id, nombre) VALUES (?, ?);";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, departamento.getId());
            pst.setString(2, departamento.getNombre());
            int resultado = pst.executeUpdate();
            System.out.println("Se han insertado " + resultado + " departamento/s.");
            con.close();
        } catch (SQLException throwables) {
            System.out.println("Error al insertar departamento. " + throwables.getMessage());
            throwables.printStackTrace();
        }
    }

    public static Departamento read(int id ) {
        Departamento departamento = null;
        Connection con = conectar();
        String sql = "SELECT * FROM departamento WHERE id = ?;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id); // el id que paso por parámetro
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                departamento = new Departamento(rs.getInt("id"), rs.getString("nombre"));
            }
            con.close();
        } catch (SQLException throwables) {
            System.out.println("Error al recuperar datos del departamento. " + throwables.getMessage());
            throwables.printStackTrace();
        }
        return departamento;
    }

}
