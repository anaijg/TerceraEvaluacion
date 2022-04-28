package ejemplos;

import java.sql.*;

public class EjemploUpdate {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:./JDBC/src/empresa2.db";
        try {
            Connection con = DriverManager.getConnection(url);
            String actualizar = "UPDATE empleado SET salario = salario * 1.1 WHERE nombre LIKE 'S%';";
            Statement st = con.createStatement();
            int registrosActualizados = st.executeUpdate(actualizar);
            System.out.println("Se han actualizado " + registrosActualizados + " registros.");

            System.out.println("\n\n");

            // AHORA VAMOS A VER QUÉ REGISTROS SE HAN ACTUALIZADO
            String select = "SELECT nombre, salario FROM empleado WHERE nombre LIKE 'S%';";
            ResultSet rs = st.executeQuery(select);
            // ahora recorro el ResultSet para mostrar los datos
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + ": " + rs.getDouble("salario") + " €");
            }


            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
