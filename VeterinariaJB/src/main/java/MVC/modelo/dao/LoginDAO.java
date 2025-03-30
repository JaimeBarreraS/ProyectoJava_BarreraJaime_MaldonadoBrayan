package MVC.modelo.dao;

import MVC.modelo.Login;
import MVC.modelo.Role;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
    private Connection connection;

    public LoginDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar
    public void addLogin(Login login) {
        String sql = "INSERT INTO login (user, password, role_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login.getUser());
            statement.setString(2, login.getPassword());
            statement.setInt(3, login.getRole().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener
    public List<Login> getAllLogins() {
        List<Login> logins = new ArrayList<>();
        String sql = "SELECT l.*, r.name AS role_name FROM login l JOIN role r ON l.role_id = r.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getInt("role_id"),
                        resultSet.getString("role_name")
                );
                Login login = new Login(
                        resultSet.getInt("id"),
                        resultSet.getString("user"),
                        resultSet.getString("password"),
                        role
                );
                logins.add(login);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logins;
    }

    // Metodo para buscar un login por ID
    public Login getLoginById(int id) {
        String sql = "SELECT l.*, r.name AS role_name FROM login l JOIN role r ON l.role_id = r.id WHERE l.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Role role = new Role(
                        resultSet.getInt("role_id"),
                        resultSet.getString("role_name")
                );
                return new Login(
                        resultSet.getInt("id"),
                        resultSet.getString("user"),
                        resultSet.getString("password"),
                        role
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar un login
    public void updateLogin(Login login) {
        String sql = "UPDATE login SET user = ?, password = ?, role_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login.getUser());
            statement.setString(2, login.getPassword());
            statement.setInt(3, login.getRole().getId());
            statement.setInt(4, login.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar un login
    public void deleteLogin(int id) {
        String sql = "DELETE FROM login WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Login validarYTraerUsuario(String username, String password) {
        String sql = "SELECT * FROM login WHERE user = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Role role = new Role(rs.getInt("role_id"), null);
                return new Login(
                        rs.getInt("id"),
                        rs.getString("user"),
                        rs.getString("password"),
                        role
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}