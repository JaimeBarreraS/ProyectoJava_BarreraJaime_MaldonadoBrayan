package MVC.modelo.dao;

import MVC.modelo.TypeProcedures;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeProceduresDAO {
    private Connection connection;

    public TypeProceduresDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar
    public void addTypeProcedure(TypeProcedures typeProcedure) {
        String sql = "INSERT INTO typeprocedures (name, price) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, typeProcedure.getName());
            statement.setDouble(2, typeProcedure.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener
    public List<TypeProcedures> getAllTypeProcedures() {
        List<TypeProcedures> typeProcedures = new ArrayList<>();
        String sql = "SELECT * FROM typeprocedures";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                TypeProcedures typeProcedure = new TypeProcedures(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")
                );
                typeProcedures.add(typeProcedure);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeProcedures;
    }

    // Metodo para buscar un tipo de procedimiento por ID
    public TypeProcedures getTypeProcedureById(int id) {
        String sql = "SELECT * FROM typeprocedures WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new TypeProcedures(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar un tipo de procedimiento
    public void updateTypeProcedure(TypeProcedures typeProcedure) {
        String sql = "UPDATE typeprocedures SET name = ?, price = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, typeProcedure.getName());
            statement.setDouble(2, typeProcedure.getPrice());
            statement.setInt(3, typeProcedure.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar
    public void deleteTypeProcedure(int id) {
        String sql = "DELETE FROM typeprocedures WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
