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
        String sql = "INSERT INTO inventory (name, type, manufacturer, stock, price, expirationDate, supplier_id) VALUES (?, ?, ?, ?, ?, ?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, inventory.getName());
            statement.setString(2, inventory.getType());
            statement.setString(3, inventory.getManufacturer());
            statement.setInt(4, inventory.getStock());
            statement.setInt(5,inventory.getPrice());
            statement.setDate(6, new java.sql.Date(inventory.getExpirationDate().getTime()));
            statement.setInt(7, inventory.getSupplier().getId());
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
                        resultSet.getInt("price"),
                        resultSet.getInt("stock"),
                        resultSet.getDate("expirationdate"),
                        supplier
                );
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }
    
    public List<Inventory> getAllReabastecer() {
        List<Inventory> inventories = new ArrayList<>();
        String sql = "SELECT i.*, s.name AS supplier_name FROM inventory i JOIN supplier s ON i.supplier_id = s.id where stock <= 5";
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
                        resultSet.getInt("price"),
                        resultSet.getInt("stock"),
                        resultSet.getDate("expirationdate"),
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
                        resultSet.getInt("price"),
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

    public void updateProduct(int stock ,int id) {
        String sql = "UPDATE inventory SET stock = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, stock);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCantProduct(String productName) {
        String sql = "Select stock from inventory where name = ?";
        int stock = 0;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, productName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    stock = rs.getInt("stock");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }

    public int getIdProduct(String ProductName) {
        String sql = "Select id from inventory where name = ?";
        int id = 0;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, ProductName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public int getPriceProduct(int ProductID) {
        String sql = "Select price from inventory where id = ?";
        int price = 0;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, ProductID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    price = rs.getInt("price");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }
    
    
    public String getNameProduct(int ProductID) {
        String sql = "Select name from inventory where id = ?";
        String name = "";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, ProductID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    name = rs.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
    
    public void updateQuantity(int quantity, int id) {
        String sql = "UPDATE inventory SET stock = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, quantity);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getStockProduct(int ProductID) {
        String sql = "Select stock from inventory where id = ?";
        int stock = 0;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, ProductID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    stock = rs.getInt("stock");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }
}
