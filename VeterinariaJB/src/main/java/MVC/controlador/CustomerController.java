package MVC.controlador;

import MVC.modelo.People;
import MVC.modelo.dao.PeopleDAO;
import MVC.util.DatabaseConnection;
import MVC.vista.vistaGestionOwners;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

public class CustomerController {
    private vistaGestionOwners view; 
    private PeopleDAO peopleDAO;
    private Connection connection;

    public CustomerController(vistaGestionOwners view) {
        this.view = view;
        this.peopleDAO = new PeopleDAO();
        this.connection = DatabaseConnection.getConnection();
        this.view.setController(this);
    }
    
    private void initController() {
        view.getBtnAdd().addActionListener(e -> registerUser());
    }
    
    public void listCustomer(){
        try{
            List<People> people = peopleDAO.getAllOwners();
            DefaultTableModel model = (DefaultTableModel) view.getTableCustomer().getModel();
                model.setRowCount(0); 

                for (People p : people){
                    Object[] row = {
                        p.getId(),
                        p.getName(),
                        p.getIdentification(),
                        p.getPhone(),
                        p.getEmail()
                    };
                    model.addRow(row);
            } 
            view.limpiarCampos();
        }
        catch(Exception e){
            view.showMessage("Error al listar a los clientes: " + e.getMessage());
        }        
    }
    
        
    public void deleteCustomer(){
        try {
            int id = Integer.parseInt(view.getTxtID().getText());
            peopleDAO.deletePeople(id);
            view.showMessage("Eliminado correctamente");
            view.limpiarCampos();
            listCustomer();
        }
        catch(Exception e){
            view.showMessage("Error al eliminar cliente: " + e.getMessage());
        }
    }    
    
    public void updateCustomer(){
        try{
            People people = new People(
                    Integer.parseInt(view.txtID.getText()),
                    view.txtName.getText(),
                    view.txtIdentification.getText(),
                    view.txtphone.getText(),
                    view.txtEmail.getText()
            );
            peopleDAO.updatePeople(people);
            view.showMessage("Cliente actualizado correctamente.");
            view.limpiarCampos();
            listCustomer(); 
        }
        catch(Exception e){
            view.showMessage("Error al actualizar cliente: " + e.getMessage());
        }
    }
    
    public void searchCustomer(){
        try{
            int id = Integer.parseInt(view.getTxtID().getText());
            People people = peopleDAO.getPeopleById(id);
            if (people != null) {
                
                view.getTxtName().setText(people.getName());
                view.getTxtIdentification().setText(people.getIdentification());
                view.getTxtphone().setText(people.getPhone());
                view.getTxtEmail().setText(people.getEmail());              
            }
            else {
                view.showMessage("No se encontró al cliente con ID: " + id);
                view.limpiarCampos();
            }
        }    
        catch(Exception e){
            view.showMessage("Error al encontrar cliente: " + e.getMessage());
        }
    }
    
    public void registerUser() {
        
        System.out.println("Sí se está ingresando a registerUser");
        
        String selectedRole = (String) view.getjComboBox1().getSelectedItem();
        String username = view.getTxtName().getText().trim();
        String password = view.getTxtSignPass().getText().trim();
        String name = view.getTxtName().getText().trim();
        String identification = view.getTxtIdentification().getText().trim();
        String phone = view.getTxtphone().getText().trim();
        String email = view.getTxtEmail().getText().trim();

        if (selectedRole.equals("------")) {
            JOptionPane.showMessageDialog(view, "Seleccione una funcion", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (username.isEmpty() || password.isEmpty() || name.isEmpty() ||
                identification.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(view, "Introduzca una dirección de correo electronico valida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            if (userExists(username)) {
                JOptionPane.showMessageDialog(view, "El nombre de usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (identificationExists(identification)) {
                JOptionPane.showMessageDialog(view, "Numero de identificacion ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Get selected role ID
            int roleId = getRoleId(selectedRole);
            if (roleId == -1) {
                JOptionPane.showMessageDialog(view, "Rol no valido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            connection.setAutoCommit(false);

            try {
                int peopleId = insertPerson(name, identification, phone, email, roleId);
                insertIntoRoleTable(selectedRole, peopleId);
                insertLogin(username, password, roleId);
                connection.commit();
                JOptionPane.showMessageDialog(view, "Usuario registrado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } catch (SQLException ex) {
                connection.rollback();
                throw ex;
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error al registrar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private boolean isValidEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    private boolean userExists(String username) throws SQLException {
        String sql = "SELECT COUNT(*) FROM login WHERE user = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    private boolean identificationExists(String identification) throws SQLException {
        String sql = "SELECT COUNT(*) FROM people WHERE identification = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, identification);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    private int getRoleId(String roleName) throws SQLException {
        String sql = "SELECT id FROM role WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, roleName.toLowerCase());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }
        return -1;
    }

    private int insertPerson(String name, String identification, String phone, String email, int roleId) throws SQLException {
        String sql = "INSERT INTO people (name, identification, phone, email, role_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setString(2, identification);
            stmt.setString(3, phone);
            stmt.setString(4, email);
            stmt.setInt(5, roleId);

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No ha conseguido identificar a la Persona.");
                }
            }
        }
    }

    private void insertIntoRoleTable(String role, int peopleId) throws SQLException {
        String table = role.toLowerCase();
        String sql = "INSERT INTO " + table + " (people_id) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, peopleId);
            stmt.executeUpdate();
        }
    }

    private void insertLogin(String username, String password, int roleId) throws SQLException {
        String sql = "INSERT INTO login (user, password, role_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, roleId);
            stmt.executeUpdate();
        }
    }
    
    private void clearFields() {
    view.getTxtSignUser().setText("");
    view.getTxtSignPass().setText("");
    view.getTxtName().setText("");
    view.getTxtIdentification().setText("");
    view.getTxtphone().setText("");
    view.getTxtEmail().setText("");
    view.getjComboBox1().setSelectedIndex(0);
    }
}
