package MVC.modelo.dao;

import MVC.modelo.MedicalHistory;
import MVC.modelo.Pet;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalHistoryDAO {
    private Connection connection;

    public MedicalHistoryDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar
    public void addMedicalHistory(MedicalHistory medicalHistory) {
        String sql = "INSERT INTO medicalhistory (pet_id, allergies, pre_conditions, weight) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, medicalHistory.getPet().getId());
            statement.setString(2, medicalHistory.getAllergies());
            statement.setString(3, medicalHistory.getPreConditions());
            statement.setString(4, medicalHistory.getWeight());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener
    public List<MedicalHistory> getAllMedicalHistories() {
        List<MedicalHistory> medicalHistories = new ArrayList<>();
        String sql = "SELECT mh.*, p.name AS pet_name FROM medicalhistory mh JOIN pet p ON mh.pet_id = p.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Pet pet = new Pet(
                        resultSet.getInt("pet_id"),
                        resultSet.getString("pet_name"),
                        null, null, 0, null, null, null, null, null
                );
                MedicalHistory medicalHistory = new MedicalHistory(
                        resultSet.getInt("id"),
                        pet,
                        resultSet.getString("allergies"),
                        resultSet.getString("pre_conditions"),
                        resultSet.getString("weight")
                );
                medicalHistories.add(medicalHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalHistories;
    }

    // Metodo para buscar un historial medico por ID
    public MedicalHistory getMedicalHistoryById(int id) {
        String sql = "SELECT mh.*, p.name AS pet_name FROM medicalhistory mh JOIN pet p ON mh.pet_id = p.id WHERE mh.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Pet pet = new Pet(
                        resultSet.getInt("pet_id"),
                        resultSet.getString("pet_name"),
                        null, null, 0, null, null, null, null, null
                );
                return new MedicalHistory(
                        resultSet.getInt("id"),
                        pet,
                        resultSet.getString("allergies"),
                        resultSet.getString("pre_conditions"),
                        resultSet.getString("weight")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar un historial medico
    public void updateMedicalHistory(MedicalHistory medicalHistory) {
        String sql = "UPDATE medicalhistory SET pet_id = ?, allergies = ?, pre_conditions = ?, weight = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, medicalHistory.getPet().getId());
            statement.setString(2, medicalHistory.getAllergies());
            statement.setString(3, medicalHistory.getPreConditions());
            statement.setString(4, medicalHistory.getWeight());
            statement.setInt(5, medicalHistory.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar
    public void deleteMedicalHistory(int id) {
        String sql = "DELETE FROM medicalhistory WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
