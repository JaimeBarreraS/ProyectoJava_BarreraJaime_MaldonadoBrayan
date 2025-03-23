package MVC.modelo.dao;

import MVC.modelo.InventoryConsult;
import MVC.modelo.MedicalConsult;
import MVC.modelo.Inventory;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryConsultDAO {
    private Connection connection;

    public InventoryConsultDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar una relacion inventario-consulta
    public void addInventoryConsult(InventoryConsult inventoryConsult) {
        String sql = "INSERT INTO inventoryconsult (medicalConsult_id, inventory_id, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, inventoryConsult.getMedicalConsult().getId());
            statement.setInt(2, inventoryConsult.getInventory().getId());
            statement.setInt(3, inventoryConsult.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener las relaciones inventario-consulta
    public List<InventoryConsult> getAllInventoryConsults() {
        List<InventoryConsult> inventoryConsults = new ArrayList<>();
        String sql = "SELECT ic.*, mc.reason AS consult_reason, i.name AS inventory_name FROM inventoryconsult ic " +
                "JOIN medicalconsult mc ON ic.medicalConsult_id = mc.id " +
                "JOIN inventory i ON ic.inventory_id = i.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                MedicalConsult medicalConsult = new MedicalConsult(
                        resultSet.getInt("medicalConsult_id"),
                        null, null, null, resultSet.getString("consult_reason"), null, null, null, null
                );
                Inventory inventory = new Inventory(
                        resultSet.getInt("inventory_id"),
                        resultSet.getString("inventory_name"),
                        null, null, 0, null, null
                );
                InventoryConsult inventoryConsult = new InventoryConsult(
                        resultSet.getInt("id"),
                        medicalConsult,
                        inventory,
                        resultSet.getInt("quantity")
                );
                inventoryConsults.add(inventoryConsult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryConsults;
    }

    // Metodo para buscar una relacion inventario-consulta por ID
    public InventoryConsult getInventoryConsultById(int id) {
        String sql = "SELECT ic.*, mc.reason AS consult_reason, i.name AS inventory_name FROM inventoryconsult ic " +
                "JOIN medicalconsult mc ON ic.medicalConsult_id = mc.id " +
                "JOIN inventory i ON ic.inventory_id = i.id WHERE ic.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                MedicalConsult medicalConsult = new MedicalConsult(
                        resultSet.getInt("medicalConsult_id"),
                        null, null, null, resultSet.getString("consult_reason"), null, null, null, null
                );
                Inventory inventory = new Inventory(
                        resultSet.getInt("inventory_id"),
                        resultSet.getString("inventory_name"),
                        null, null, 0, null, null
                );
                return new InventoryConsult(
                        resultSet.getInt("id"),
                        medicalConsult,
                        inventory,
                        resultSet.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar una relacion inventario-consulta
    public void updateInventoryConsult(InventoryConsult inventoryConsult) {
        String sql = "UPDATE inventoryconsult SET medicalConsult_id = ?, inventory_id = ?, quantity = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, inventoryConsult.getMedicalConsult().getId());
            statement.setInt(2, inventoryConsult.getInventory().getId());
            statement.setInt(3, inventoryConsult.getQuantity());
            statement.setInt(4, inventoryConsult.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar una relacion inventario-consulta
    public void deleteInventoryConsult(int id) {
        String sql = "DELETE FROM inventoryconsult WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
