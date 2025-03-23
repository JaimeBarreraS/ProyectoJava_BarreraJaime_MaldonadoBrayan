package MVC.modelo.dao;

import MVC.modelo.Invoice;
import MVC.modelo.People;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {
    private Connection connection;

    public InvoiceDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar una factura
    public void addInvoice(Invoice invoice) {
        String sql = "INSERT INTO invoice (costumer_id, date, total, tax, cufe, qr) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, invoice.getCostumer().getId());
            statement.setDate(2, new java.sql.Date(invoice.getDate().getTime()));
            statement.setDouble(3, invoice.getTotal());
            statement.setDouble(4, invoice.getTax());
            statement.setString(5, invoice.getCufe());
            statement.setString(6, invoice.getQr());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener todas las facturas
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        String sql = "SELECT i.*, p.name AS costumer_name FROM invoice i JOIN people p ON i.costumer_id = p.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                People costumer = new People(
                        resultSet.getInt("costumer_id"),
                        resultSet.getString("costumer_name"),
                        null, null, null, null, null, null
                );
                Invoice invoice = new Invoice(
                        resultSet.getInt("id"),
                        costumer,
                        resultSet.getDate("date"),
                        resultSet.getDouble("total"),
                        resultSet.getDouble("tax"),
                        resultSet.getString("cufe"),
                        resultSet.getString("qr")
                );
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    // Metodo para buscar una factura por ID
    public Invoice getInvoiceById(int id) {
        String sql = "SELECT i.*, p.name AS costumer_name FROM invoice i JOIN people p ON i.costumer_id = p.id WHERE i.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                People costumer = new People(
                        resultSet.getInt("costumer_id"),
                        resultSet.getString("costumer_name"),
                        null, null, null, null, null, null
                );
                return new Invoice(
                        resultSet.getInt("id"),
                        costumer,
                        resultSet.getDate("date"),
                        resultSet.getDouble("total"),
                        resultSet.getDouble("tax"),
                        resultSet.getString("cufe"),
                        resultSet.getString("qr")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar una factura
    public void updateInvoice(Invoice invoice) {
        String sql = "UPDATE invoice SET costumer_id = ?, date = ?, total = ?, tax = ?, cufe = ?, qr = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, invoice.getCostumer().getId());
            statement.setDate(2, new java.sql.Date(invoice.getDate().getTime()));
            statement.setDouble(3, invoice.getTotal());
            statement.setDouble(4, invoice.getTax());
            statement.setString(5, invoice.getCufe());
            statement.setString(6, invoice.getQr());
            statement.setInt(7, invoice.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar una factura
    public void deleteInvoice(int id) {
        String sql = "DELETE FROM invoice WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
