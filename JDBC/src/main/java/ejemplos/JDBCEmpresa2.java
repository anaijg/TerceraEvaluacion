package ejemplos;

import java.sql.*;

public class JDBCEmpresa2 {
    public static void main(String[] args) {
        // ¡¡OJO!!, las barras son las "normales"
        String url = "jdbc:sqlite:./JDBC/src/empresa2.db";
        // Necesitamos un objeto de tipo Connection
        try {
            // Al utilizar try-catch, debo cerrar la conexión cuando termine
            Connection con = DriverManager.getConnection(url);
            // probamos si podemos conectar con la BBDD
            /*if (con.isValid(5)) {
                System.out.println("Conexión válida");
            } else {
                System.out.println("Timeout");
            }*/

            //  Cualquier query es un objeto de tipo Statement
            Statement st = con.createStatement(); // con esto me crea un st en modo lectura y sin ir haca atrás
            // SELECT
            String consulta = "SELECT * FROM departamento;";
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) { // mientras haya una siguiente fila, pasamos a la siguiente
                // Leemos la fila campo a campo
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double presupuesto = rs.getDouble("presupuesto");
                System.out.println(id + "\t" + nombre + "\t" + presupuesto + " euros");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Excepción de base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
