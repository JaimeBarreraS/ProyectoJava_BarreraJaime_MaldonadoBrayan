package MVC.modelo.dao;

import MVC.modelo.Supplier;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {
    private Connection connection;

    public SupplierDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar
    public void addSupplier(Supplier supplier) {
        String sql = "INSERT INTO supplier (name, contact, phone, email, address) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, supplier.getName());
            statement.setString(2, supplier.getContact());
            statement.setString(3, supplier.getPhone());
            statement.setString(4, supplier.getEmail());
            statement.setString(5, supplier.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        String sql = "SELECT * FROM supplier";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Supplier supplier = new Supplier(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("contact"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("address")
                );
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    // Metodo para buscar un proveedor por ID
    public Supplier getSupplierById(int id) {
        String sql = "SELECT * FROM supplier WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Supplier(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("contact"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar un proveedor
    public void updateSupplier(Supplier supplier) {
        String sql = "UPDATE supplier SET name = ?, contact = ?, phone = ?, email = ?, address = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, supplier.getName());
            statement.setString(2, supplier.getContact());
            statement.setString(3, supplier.getPhone());
            statement.setString(4, supplier.getEmail());
            statement.setString(5, supplier.getAddress());
            statement.setInt(6, supplier.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar
    public void deleteSupplier(int id) {
        String sql = "DELETE FROM supplier WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Metodo para obtener los nombres de los proveedores
    public List<String> getAllSupplierss() {
        List<String> suppliers = new ArrayList<>();
        String sql = "SELECT name FROM supplier";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                suppliers.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }
    
        public int getSupplierIdByName(String name) {
        String sql = "SELECT id FROM supplier WHERE name = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
