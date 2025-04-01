package MVC.modelo.dao;

import MVC.modelo.Adoption;
import MVC.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdoptionDAO {
    private Connection connection;

    public AdoptionDAO() {
        connection = DatabaseConnection.getConnection();
    }
    
    public void addPet(Adoption adoption){
        String sql = "INSERT INTO adoption (name, specie, race, age, sex,state) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, adoption.getName());
                statement.setString(2, adoption.getSpecie());
                statement.setString(3, adoption.getRace());
                statement.setInt(4, adoption.getAge());
                statement.setString(5, adoption.getSex());
                statement.setString(6, adoption.getState());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    
    public List<String> getAllPets() {
        List<String> owners = new ArrayList<>();
        String sql = "SELECT name FROM adoption";
        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                owners.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return owners;
    }
    
    public List<Adoption> getPets() {
        List<Adoption> pets = new ArrayList<>();
        String sql = "SELECT * from adoption";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Adoption adoption = new Adoption(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("specie"),
                        resultSet.getString("race"),
                        resultSet.getInt("age"),
                        resultSet.getString("sex"),
                        resultSet.getString("state")
                );
                pets.add(adoption);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }
    
    public void deletePet(int id) {
        String sql = "DELETE FROM adoption WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            }
    }
    
    public int getIdPet(String Name) {
        String sql = "Select id from adoption where name = ?";
        int id = 0;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, Name);
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
}