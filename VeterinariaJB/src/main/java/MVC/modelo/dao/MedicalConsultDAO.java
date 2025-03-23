package MVC.modelo.dao;

import MVC.modelo.MedicalConsult;
import MVC.modelo.Pet;
import MVC.modelo.People;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalConsultDAO {
    private Connection connection;

    public MedicalConsultDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar
    public void addMedicalConsult(MedicalConsult medicalConsult) {
        String sql = "INSERT INTO medicalconsult (pet_id, date, time, reason, diagnostic, recommendations, state, veterinary_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, medicalConsult.getPet().getId());
            statement.setDate(2, new java.sql.Date(medicalConsult.getDate().getTime()));
            statement.setTime(3, medicalConsult.getTime());
            statement.setString(4, medicalConsult.getReason());
            statement.setString(5, medicalConsult.getDiagnostic());
            statement.setString(6, medicalConsult.getRecommendations());
            statement.setString(7, medicalConsult.getState());
            statement.setInt(8, medicalConsult.getVeterinary().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener
    public List<MedicalConsult> getAllMedicalConsults() {
        List<MedicalConsult> medicalConsults = new ArrayList<>();
        String sql = "SELECT mc.*, p.name AS pet_name, pe.name AS veterinary_name FROM medicalconsult mc " +
                "JOIN pet p ON mc.pet_id = p.id " +
                "JOIN people pe ON mc.veterinary_id = pe.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Pet pet = new Pet(
                        resultSet.getInt("pet_id"),
                        resultSet.getString("pet_name"),
                        null, null, 0, null, null, null, null, null
                );
                People veterinary = new People(
                        resultSet.getInt("veterinary_id"),
                        resultSet.getString("veterinary_name"),
                        null, null, null, null, null, null
                );
                MedicalConsult medicalConsult = new MedicalConsult(
                        resultSet.getInt("id"),
                        pet,
                        resultSet.getDate("date"),
                        resultSet.getTime("time"),
                        resultSet.getString("reason"),
                        resultSet.getString("diagnostic"),
                        resultSet.getString("recommendations"),
                        resultSet.getString("state"),
                        veterinary
                );
                medicalConsults.add(medicalConsult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalConsults;
    }

    // Metodo para buscar una consulta medica por ID
    public MedicalConsult getMedicalConsultById(int id) {
        String sql = "SELECT mc.*, p.name AS pet_name, pe.name AS veterinary_name FROM medicalconsult mc " +
                "JOIN pet p ON mc.pet_id = p.id " +
                "JOIN people pe ON mc.veterinary_id = pe.id WHERE mc.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Pet pet = new Pet(
                        resultSet.getInt("pet_id"),
                        resultSet.getString("pet_name"),
                        null, null, 0, null, null, null, null, null
                );
                People veterinary = new People(
                        resultSet.getInt("veterinary_id"),
                        resultSet.getString("veterinary_name"),
                        null, null, null, null, null, null
                );
                return new MedicalConsult(
                        resultSet.getInt("id"),
                        pet,
                        resultSet.getDate("date"),
                        resultSet.getTime("time"),
                        resultSet.getString("reason"),
                        resultSet.getString("diagnostic"),
                        resultSet.getString("recommendations"),
                        resultSet.getString("state"),
                        veterinary
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar una consulta medica
    public void updateMedicalConsult(MedicalConsult medicalConsult) {
        String sql = "UPDATE medicalconsult SET pet_id = ?, date = ?, time = ?, reason = ?, diagnostic = ?, recommendations = ?, state = ?, veterinary_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, medicalConsult.getPet().getId());
            statement.setDate(2, new java.sql.Date(medicalConsult.getDate().getTime()));
            statement.setTime(3, medicalConsult.getTime());
            statement.setString(4, medicalConsult.getReason());
            statement.setString(5, medicalConsult.getDiagnostic());
            statement.setString(6, medicalConsult.getRecommendations());
            statement.setString(7, medicalConsult.getState());
            statement.setInt(8, medicalConsult.getVeterinary().getId());
            statement.setInt(9, medicalConsult.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar
    public void deleteMedicalConsult(int id) {
        String sql = "DELETE FROM medicalconsult WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
