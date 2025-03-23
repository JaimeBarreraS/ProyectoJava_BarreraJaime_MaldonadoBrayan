package MVC.modelo.dao;

import MVC.modelo.Vaccine;
import MVC.modelo.Pet;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VaccineDAO {
    private Connection connection;

    public VaccineDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar
    public void addVaccine(Vaccine vaccine) {
        String sql = "INSERT INTO vaccine (pet_id, name, lot, manufacturer, date_application, next_dose) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, vaccine.getPet().getId());
            statement.setString(2, vaccine.getName());
            statement.setString(3, vaccine.getLot());
            statement.setString(4, vaccine.getManufacturer());
            statement.setDate(5, new java.sql.Date(vaccine.getDateApplication().getTime()));
            statement.setDate(6, new java.sql.Date(vaccine.getNextDose().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener
    public List<Vaccine> getAllVaccines() {
        List<Vaccine> vaccines = new ArrayList<>();
        String sql = "SELECT v.*, p.name AS pet_name FROM vaccine v JOIN pet p ON v.pet_id = p.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Pet pet = new Pet(
                        resultSet.getInt("pet_id"),
                        resultSet.getString("pet_name"),
                        null, null, 0, null, null, null, null, null
                );
                Vaccine vaccine = new Vaccine(
                        resultSet.getInt("id"),
                        pet,
                        resultSet.getString("name"),
                        resultSet.getString("lot"),
                        resultSet.getString("manufacturer"),
                        resultSet.getDate("date_application"),
                        resultSet.getDate("next_dose")
                );
                vaccines.add(vaccine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaccines;
    }

    // Metodo para buscar una vacuna por ID
    public Vaccine getVaccineById(int id) {
        String sql = "SELECT v.*, p.name AS pet_name FROM vaccine v JOIN pet p ON v.pet_id = p.id WHERE v.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Pet pet = new Pet(
                        resultSet.getInt("pet_id"),
                        resultSet.getString("pet_name"),
                        null, null, 0, null, null, null, null, null
                );
                return new Vaccine(
                        resultSet.getInt("id"),
                        pet,
                        resultSet.getString("name"),
                        resultSet.getString("lot"),
                        resultSet.getString("manufacturer"),
                        resultSet.getDate("date_application"),
                        resultSet.getDate("next_dose")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar una vacuna
    public void updateVaccine(Vaccine vaccine) {
        String sql = "UPDATE vaccine SET pet_id = ?, name = ?, lot = ?, manufacturer = ?, date_application = ?, next_dose = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, vaccine.getPet().getId());
            statement.setString(2, vaccine.getName());
            statement.setString(3, vaccine.getLot());
            statement.setString(4, vaccine.getManufacturer());
            statement.setDate(5, new java.sql.Date(vaccine.getDateApplication().getTime()));
            statement.setDate(6, new java.sql.Date(vaccine.getNextDose().getTime()));
            statement.setInt(7, vaccine.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar
    public void deleteVaccine(int id) {
        String sql = "DELETE FROM vaccine WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
