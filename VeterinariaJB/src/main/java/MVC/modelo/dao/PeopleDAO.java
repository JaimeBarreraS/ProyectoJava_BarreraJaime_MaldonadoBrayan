package MVC.modelo.dao;


import MVC.modelo.People;
import MVC.modelo.Role;
import MVC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleDAO {
    private Connection connection;

    public PeopleDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Metodo para agregar
    public void addPeople(People people) {
        String sql = "INSERT INTO people (name, identification, phone, email, role_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, people.getName());
            statement.setString(2, people.getIdentification());
            statement.setString(3, people.getPhone());
            statement.setString(4, people.getEmail());
            statement.setInt(5, people.getRole().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener todas las personas
    public List<People> getAllPeople() {
        List<People> peopleList = new ArrayList<>();
        String sql = "SELECT p.*, r.name AS role_name FROM people p JOIN role r ON p.role_id = r.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getInt("role_id"),
                        resultSet.getString("role_name")
                );
                People people = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("identification"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        role,
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at")
                );
                peopleList.add(people);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peopleList;
    }
    
    //Metodo para obtener a todos los clientes
    public List<People> getAllOwners(){
        List<People> ownerList = new ArrayList<>();
        String sql = "SELECT p.*, r.name AS role_name FROM people p JOIN role r ON p.role_id = r.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getInt("role_id"),
                        resultSet.getString("role_name")
                );
                People people = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("identification"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        role,
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at")
                );
                ownerList.add(people);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ownerList;
    }

    // Metodo para buscar una persona por ID
    public People getPeopleById(int id) {
        String sql = "SELECT p.*, r.name AS role_name FROM people p JOIN role r ON p.role_id = r.id WHERE p.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Role role = new Role(
                        resultSet.getInt("role_id"),
                        resultSet.getString("role_name")
                );
                return new People(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("identification"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        role,
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo para actualizar una persona
    public void updatePeople(People people) {
        String sql = "UPDATE people SET name = ?, identification = ?, phone = ?, email = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, people.getName());
            statement.setString(2, people.getIdentification());
            statement.setString(3, people.getPhone());
            statement.setString(4, people.getEmail());
            statement.setInt(5, people.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar una persona
    public void deletePeople(int id) {
        String sql = "DELETE FROM people WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para obtener los nombres de los clientes
    public List<String> getAllClientNames() {
        List<String> clients = new ArrayList<>();
        String sql = "SELECT name FROM people";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                clients.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
    
    public int getIdPeople(String ProductName) {
        String sql = "Select id from people where name = ?";
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
}
