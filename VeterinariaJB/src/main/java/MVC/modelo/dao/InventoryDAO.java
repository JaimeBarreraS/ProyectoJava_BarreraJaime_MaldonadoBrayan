package MVC.modelo.dao;

import MVC.modelo.Inventory;
import MVC.modelo.Supplier;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {
    private Connection connection;

    public InventoryDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar
    public void addInventory(Inventory inventory) {
        String sql = "INSERT INTO inventory (name, type, manufacturer, stock, expirationDate, supplier_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, inventory.getName());
            statement.setString(2, inventory.getType());
            statement.setString(3, inventory.getManufacturer());
            statement.setInt(4, inventory.getStock());
            statement.setDate(5, new java.sql.Date(inventory.getExpirationDate().getTime()));
            statement.setInt(6, inventory.getSupplier().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener
    public List<Inventory> getAllInventories() {
        List<Inventory> inventories = new ArrayList<>();
        String sql = "SELECT i.*, s.name AS supplier_name FROM inventory i JOIN supplier s ON i.supplier_id = s.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Supplier supplier = new Supplier(
                        resultSet.getInt("supplier_id"),
                        resultSet.getString("supplier_name"),
                        null, null, null, null
                );
                Inventory inventory = new Inventory(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getString("manufacturer"),
                        resultSet.getInt("stock"),
                        resultSet.getDate("expirationDate"),
                        supplier
                );
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    // Metodo para buscar un inventario por ID
    public Inventory getInventoryById(int id) {
        String sql = "SELECT i.*, s.name AS supplier_name FROM inventory i JOIN supplier s ON i.supplier_id = s.id WHERE i.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Supplier supplier = new Supplier(
                        resultSet.getInt("supplier_id"),
                        resultSet.getString("supplier_name"),
                        null, null, null, null
                );
                return new Inventory(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getString("manufacturer"),
                        resultSet.getInt("stock"),
                        resultSet.getDate("expirationDate"),
                        supplier
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar un inventario
    public void updateInventory(Inventory inventory) {
        String sql = "UPDATE inventory SET name = ?, type = ?, manufacturer = ?, stock = ?, expirationDate = ?, supplier_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, inventory.getName());
            statement.setString(2, inventory.getType());
            statement.setString(3, inventory.getManufacturer());
            statement.setInt(4, inventory.getStock());
            statement.setDate(5, new java.sql.Date(inventory.getExpirationDate().getTime()));
            statement.setInt(6, inventory.getSupplier().getId());
            statement.setInt(7, inventory.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar
    public void deleteInventory(int id) {
        String sql = "DELETE FROM inventory WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
