package ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploDelete {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:./JDBC/src/empresa2.db";
        try {
            Connection con = DriverManager.getConnection(url);
            // DELETE
            String delete = "DELETE FROM empleado WHERE id = 551;";
            Statement st = con.createStatement();
            int registrosBorrados = st.executeUpdate(delete);
            System.out.println("Se han eliminado " + registrosBorrados + " filas.");



            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
