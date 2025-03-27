package MVC.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/veterinariajb";
                String user = "root";
                String password = "Brayansamuel12";
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"No se pudo conectar a la base de datos" + e.toString());
            }
        }
        return connection;
    }
}
