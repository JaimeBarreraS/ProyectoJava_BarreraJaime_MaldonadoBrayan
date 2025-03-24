package MVC.controlador;

import MVC.util.DatabaseConnection;
import MVC.vista.vistaSignUp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SignUpController {
    private vistaSignUp view;
    private Connection connection;

    public SignUpController(vistaSignUp view) {
        this.view = view;
        this.connection = DatabaseConnection.getConnection();
        initController();
    }

    private void initController() {
        view.getBtnSignUp().addActionListener(e -> registerUser());
    }

    private void registerUser() {
        String selectedRole = (String) view.getJComboBox1().getSelectedItem();
        String username = view.getTxtSignUser().getText().trim();
        String password = view.getTxtSignPass().getText().trim();
        String name = view.getTxtName().getText().trim();
        String identification = view.getTxtIdentification().getText().trim();
        String phone = view.getTxtPhone().getText().trim();
        String email = view.getTxtEmail().getText().trim();

        if (selectedRole.equals("------")) {
            JOptionPane.showMessageDialog(view, "Seleccione una funcion", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (username.isEmpty() || password.isEmpty() || name.isEmpty() ||
                identification.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(view, "Introduzca una dirección de correo electronico valida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            if (userExists(username)) {
                JOptionPane.showMessageDialog(view, "El nombre de usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (identificationExists(identification)) {
                JOptionPane.showMessageDialog(view, "Numero de identificacion ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Get selected role ID
            int roleId = getRoleId(selectedRole);
            if (roleId == -1) {
                JOptionPane.showMessageDialog(view, "Rol no valido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            connection.setAutoCommit(false);

            try {
                int peopleId = insertPerson(name, identification, phone, email, roleId);
                insertIntoRoleTable(selectedRole, peopleId);
                insertLogin(username, password, roleId);
                connection.commit();
                JOptionPane.showMessageDialog(view, "Usuario registrado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } catch (SQLException ex) {
                connection.rollback();
                throw ex;
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error al registrar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    private boolean userExists(String username) throws SQLException {
        String sql = "SELECT COUNT(*) FROM login WHERE user = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    private boolean identificationExists(String identification) throws SQLException {
        String sql = "SELECT COUNT(*) FROM people WHERE identification = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, identification);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    private int getRoleId(String roleName) throws SQLException {
        String sql = "SELECT id FROM role WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, roleName.toLowerCase());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }
        return -1;
    }

    private int insertPerson(String name, String identification, String phone, String email, int roleId) throws SQLException {
        String sql = "INSERT INTO people (name, identification, phone, email, role_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setString(2, identification);
            stmt.setString(3, phone);
            stmt.setString(4, email);
            stmt.setInt(5, roleId);

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No ha conseguido identificar a la Persona.");
                }
            }
        }
    }

    private void insertIntoRoleTable(String role, int peopleId) throws SQLException {
        String table = role.toLowerCase();
        String sql = "INSERT INTO " + table + " (people_id) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, peopleId);
            stmt.executeUpdate();
        }
    }

    private void insertLogin(String username, String password, int roleId) throws SQLException {
        String sql = "INSERT INTO login (user, password, role_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, roleId);
            stmt.executeUpdate();
        }
    }

    private void clearFields() {
        view.getTxtSignUser().setText("");
        view.getTxtSignPass().setText("");
        view.getTxtName().setText("");
        view.getTxtIdentification().setText("");
        view.getTxtPhone().setText("");
        view.getTxtEmail().setText("");
        view.getJComboBox1().setSelectedIndex(0);
    }
}