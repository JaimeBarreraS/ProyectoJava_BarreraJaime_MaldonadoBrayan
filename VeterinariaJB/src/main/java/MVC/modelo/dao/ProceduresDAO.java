package MVC.modelo.dao;

import MVC.modelo.Procedures;
import MVC.modelo.MedicalConsult;
import MVC.modelo.TypeProcedures;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProceduresDAO {
    private Connection connection;

    public ProceduresDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar
    public void addProcedure(Procedures procedure) {
        String sql = "INSERT INTO procedures (medicalConsult_id, description, typeProcedures_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, procedure.getMedicalConsult().getId());
            statement.setString(2, procedure.getDescription());
            statement.setInt(3, procedure.getTypeProcedures().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener
    public List<Procedures> getAllProcedures() {
        List<Procedures> procedures = new ArrayList<>();
        String sql = "SELECT p.*, mc.reason AS consult_reason, tp.name AS procedure_name FROM procedures p " +
                "JOIN medicalconsult mc ON p.medicalConsult_id = mc.id " +
                "JOIN typeprocedures tp ON p.typeProcedures_id = tp.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                MedicalConsult medicalConsult = new MedicalConsult(
                        resultSet.getInt("medicalConsult_id"),
                        null, null, null, resultSet.getString("consult_reason"), null, null, null, null
                );
                TypeProcedures typeProcedures = new TypeProcedures(
                        resultSet.getInt("typeProcedures_id"),
                        resultSet.getString("procedure_name"),
                        0
                );
                Procedures procedure = new Procedures(
                        resultSet.getInt("id"),
                        medicalConsult,
                        resultSet.getString("description"),
                        typeProcedures
                );
                procedures.add(procedure);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return procedures;
    }

    // Metodo para buscar un procedimiento por ID
    public Procedures getProcedureById(int id) {
        String sql = "SELECT p.*, mc.reason AS consult_reason, tp.name AS procedure_name FROM procedures p " +
                "JOIN medicalconsult mc ON p.medicalConsult_id = mc.id " +
                "JOIN typeprocedures tp ON p.typeProcedures_id = tp.id WHERE p.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                MedicalConsult medicalConsult = new MedicalConsult(
                        resultSet.getInt("medicalConsult_id"),
                        null, null, null, resultSet.getString("consult_reason"), null, null, null, null
                );
                TypeProcedures typeProcedures = new TypeProcedures(
                        resultSet.getInt("typeProcedures_id"),
                        resultSet.getString("procedure_name"),
                        0
                );
                return new Procedures(
                        resultSet.getInt("id"),
                        medicalConsult,
                        resultSet.getString("description"),
                        typeProcedures
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar un procedimiento
    public void updateProcedure(Procedures procedure) {
        String sql = "UPDATE procedures SET medicalConsult_id = ?, description = ?, typeProcedures_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, procedure.getMedicalConsult().getId());
            statement.setString(2, procedure.getDescription());
            statement.setInt(3, procedure.getTypeProcedures().getId());
            statement.setInt(4, procedure.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar
    public void deleteProcedure(int id) {
        String sql = "DELETE FROM procedures WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
