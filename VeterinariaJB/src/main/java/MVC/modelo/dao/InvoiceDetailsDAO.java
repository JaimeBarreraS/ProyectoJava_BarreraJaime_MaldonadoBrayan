package MVC.modelo.dao;

import MVC.modelo.InvoiceDetails;
import MVC.modelo.Invoice;
import MVC.modelo.Inventory;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDetailsDAO {
    private Connection connection;

    public InvoiceDetailsDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar un detalle de factura
    public void addInvoiceDetail(InvoiceDetails invoiceDetail) {
        String sql = "INSERT INTO invoicedetails (invoice_id, description, quantity, unitValue, subtotal, inventory_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, invoiceDetail.getInvoice().getId());
            statement.setString(2, invoiceDetail.getDescription());
            statement.setInt(3, invoiceDetail.getQuantity());
            statement.setDouble(4, invoiceDetail.getUnitValue());
            statement.setDouble(5, invoiceDetail.getSubtotal());
            statement.setInt(6, invoiceDetail.getInventory().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener los detalles de factura
    public List<InvoiceDetails> getAllInvoiceDetails() {
        List<InvoiceDetails> invoiceDetails = new ArrayList<>();
        String sql = "SELECT id.*, i.date AS invoice_date, inv.name AS inventory_name FROM invoicedetails id " +
                "JOIN invoice i ON id.invoice_id = i.id " +
                "JOIN inventory inv ON id.inventory_id = inv.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Invoice invoice = new Invoice(
                        resultSet.getInt("invoice_id"),
                        null, resultSet.getDate("invoice_date"), 0, 0, null, null
                );
                Inventory inventory = new Inventory(
                        resultSet.getInt("inventory_id"),
                        resultSet.getString("inventory_name"),
                        null, null, 0, 0, null, null
                );
                InvoiceDetails invoiceDetail = new InvoiceDetails(
                        resultSet.getInt("id"),
                        invoice,
                        resultSet.getString("description"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("unitValue"),
                        resultSet.getDouble("subtotal"),
                        inventory
                );
                invoiceDetails.add(invoiceDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoiceDetails;
    }

    // Metodo para buscar un detalle de factura por ID
    public InvoiceDetails getInvoiceDetailById(int id) {
        String sql = "SELECT id.*, i.date AS invoice_date, inv.name AS inventory_name FROM invoicedetails id " +
                "JOIN invoice i ON id.invoice_id = i.id " +
                "JOIN inventory inv ON id.inventory_id = inv.id WHERE id.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Invoice invoice = new Invoice(
                        resultSet.getInt("invoice_id"),
                        null, resultSet.getDate("invoice_date"), 0, 0, null, null
                );
                Inventory inventory = new Inventory(
                        resultSet.getInt("inventory_id"),
                        resultSet.getString("inventory_name"),
                        null, null, 0, 0, null, null
                );
                return new InvoiceDetails(
                        resultSet.getInt("id"),
                        invoice,
                        resultSet.getString("description"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("unitValue"),
                        resultSet.getDouble("subtotal"),
                        inventory
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar un detalle de factura
    public void updateInvoiceDetail(InvoiceDetails invoiceDetail) {
        String sql = "UPDATE invoicedetails SET invoice_id = ?, description = ?, quantity = ?, unitValue = ?, subtotal = ?, inventory_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, invoiceDetail.getInvoice().getId());
            statement.setString(2, invoiceDetail.getDescription());
            statement.setInt(3, invoiceDetail.getQuantity());
            statement.setDouble(4, invoiceDetail.getUnitValue());
            statement.setDouble(5, invoiceDetail.getSubtotal());
            statement.setInt(6, invoiceDetail.getInventory().getId());
            statement.setInt(7, invoiceDetail.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar un detalle de factura
    public void deleteInvoiceDetail(int id) {
        String sql = "DELETE FROM invoicedetails WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
