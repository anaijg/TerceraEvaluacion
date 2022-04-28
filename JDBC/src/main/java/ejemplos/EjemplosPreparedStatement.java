package ejemplos;

import java.sql.*;

public class EjemplosPreparedStatement {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:./JDBC/src/empresa2.db";
        try {
            Connection con = DriverManager.getConnection(url);
            //String select = "SELECT nombre, puesto, fecha_nac, num_hijos FROM empleado WHERE num_hijos = 0 AND salario > 2000;";
            String select = "SELECT nombre, puesto, fecha_nac, num_hijos FROM empleado WHERE num_hijos = ? AND salario > ?;";
            PreparedStatement pst = con.prepareStatement(select);
            // ahora tenemos que especificar los valores
            pst.setInt(1, 0); // quiero que el primer ? me lo sustituya por 0
            pst.setDouble(2, 2000); // quiero que el segundo ? me lo sustituya por 2000
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " - " + rs.getString("puesto") + " - " +
                        rs.getString("fecha_nac") + " - " + rs.getInt("num_hijos"));
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
