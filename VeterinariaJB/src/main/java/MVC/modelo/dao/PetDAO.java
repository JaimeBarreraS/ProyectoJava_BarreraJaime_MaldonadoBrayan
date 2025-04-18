package MVC.modelo.dao;

import MVC.modelo.Pet;
import MVC.modelo.People;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    private Connection connection;

    // Constructor
    public PetDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar una mascota
    public void addPet(Pet pet) {
        String sql = "INSERT INTO pet (name, specie, race, age, date_birth, sex, microchip_tattoo, photo, costumer_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecie());
            statement.setString(3, pet.getRace());
            statement.setInt(4, pet.getAge());
            statement.setDate(5, new java.sql.Date(pet.getDateBirth().getTime()));
            statement.setString(6, pet.getSex());
            statement.setString(7, pet.getMicrochipTattoo());
            statement.setString(8, pet.getPhoto());
            statement.setInt(9, pet.getCostumer().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para registrar adopciones
    public void addAdoption(Pet pet) {
        String sql = "INSERT INTO pet (name, specie, race, age, sex,costumer_id) VALUES (?, ?, ?, ?, ?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecie());
            statement.setString(3, pet.getRace());
            statement.setInt(4, pet.getAge());
            statement.setString(5, pet.getSex());
            statement.setInt(6, pet.getCostumer().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener todas las mascotas
    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT p.*, pe.name AS owner_name FROM pet p JOIN people pe ON p.costumer_id = pe.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {

                java.sql.Date sqlDate = resultSet.getDate("date_birth");
                java.util.Date utilDate = (sqlDate != null) ? new java.util.Date(sqlDate.getTime()) : null;
                People owner = new People(
                        resultSet.getInt("costumer_id"),
                        resultSet.getString("owner_name"),
                        null, null, null, null, null, null
                );
                Pet pet = new Pet(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("specie"),
                        resultSet.getString("race"),
                        resultSet.getInt("age"),
                        utilDate,
                        resultSet.getString("sex"),
                        resultSet.getString("microchip_tattoo"),
                        resultSet.getString("photo"),
                        owner
                );
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // Metodo para buscar una mascota por ID
    public Pet getPetById(int id) {
        String sql = "SELECT p.*, pe.name AS owner_name FROM pet p JOIN people pe ON p.costumer_id = pe.id WHERE p.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                java.sql.Date sqlDate = resultSet.getDate("date_birth");
                java.util.Date utilDate = (sqlDate != null) ? new java.util.Date(sqlDate.getTime()) : null;
                
                People owner = new People(
                        resultSet.getInt("costumer_id"),
                        resultSet.getString("owner_name"),
                        null, null, null, null, null, null
                );
                
                return new Pet(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("specie"),
                        resultSet.getString("race"),
                        resultSet.getInt("age"),
                        utilDate,
                        resultSet.getString("sex"),
                        resultSet.getString("microchip_tattoo"),
                        resultSet.getString("photo"),
                        owner
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar una mascota
    public void updatePet(Pet pet) {
        String sql = "UPDATE pet SET name = ?, specie = ?, race = ?, age = ?, date_birth = ?, sex = ?, microchip_tattoo = ?, photo = ?, costumer_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecie());
            statement.setString(3, pet.getRace());
            statement.setInt(4, pet.getAge());
            statement.setDate(5, new java.sql.Date(pet.getDateBirth().getTime()));
            statement.setString(6, pet.getSex());
            statement.setString(7, pet.getMicrochipTattoo());
            statement.setString(8, pet.getPhoto());
            statement.setInt(9, pet.getCostumer().getId());
            statement.setInt(10, pet.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar una mascota
    public void deletePet(int id) {
        String sql = "DELETE FROM pet WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener todos los dueños
    public List<String> getAllOwners() {
        List<String> owners = new ArrayList<>();
        String sql = "SELECT name FROM people WHERE role_id = 4";
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

    // Metodo para obtener el ID de un dueño por su nombre
    public int getOwnerIdByName(String name) {
        String sql = "SELECT id FROM people WHERE name = ? AND role_id = 4";
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

    // Metodo para obtener todos los dueños
    public List<String> getAllVeterinarys() {
        List<String> owners = new ArrayList<>();
        String sql = "SELECT name FROM people WHERE role_id = 3";
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

    // Metodo para obtener el ID de un dueño por su nombre
    public int getVeterinaryIdByName(String name) {
        String sql = "SELECT id FROM people WHERE name = ? AND role_id = 3";
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

    public Pet getPetByName(String name) throws SQLException {
        String sql = "SELECT id, name FROM pet WHERE name = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Pet pet = new Pet();
                    pet.setId(rs.getInt("id"));
                    pet.setName(rs.getString("name"));
                    return pet;
                }
            }
        }
        return null;
    }
}