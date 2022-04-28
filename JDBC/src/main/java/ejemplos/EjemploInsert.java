package ejemplos;

import java.sql.*;

public class EjemploInsert {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:./JDBC/src/empresa2.db";
        // Conexión:
        try {
            Connection con = DriverManager.getConnection(url);
            /*if (con.isValid(5)) {
                System.out.println("Válida");
            }*/
            // Ahora ya interactúo con la BBDD
            String insertar = "INSERT INTO empleado VALUES (551, 111, 'Ingeniero', 780, '1990-04-28', '2022-04-28', 1000, 0, 0, 'Gonzalez, Carlos Alberto');";
            Statement st = con.createStatement();
            int filasAñadidas = st.executeUpdate(insertar);
            System.out.println("Se han añadido " + filasAñadidas + " filas.");

            // Vamos a ver la fila que hemos añadido
            /*String select = "SELECT * FROM empleado WHERE id = 551;";
            ResultSet rs = st.executeQuery(select);
            rs.next(); // avanzamos un registro; el cursor ahora apunta al primer registro
            System.out.println("ID: " + rs.getInt("id") + " - nombre: " + rs.getString("nombre"));
            */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
