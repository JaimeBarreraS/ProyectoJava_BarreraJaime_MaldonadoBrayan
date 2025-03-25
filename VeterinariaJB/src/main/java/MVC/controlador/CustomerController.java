package MVC.controlador;

import MVC.modelo.People;
import MVC.modelo.dao.PeopleDAO;
import MVC.vista.vistaGestionOwners;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CustomerController {
    private vistaGestionOwners view; 
    private PeopleDAO peopleDAO;

    public CustomerController(vistaGestionOwners view) {
        this.view = view;
        this.peopleDAO = new PeopleDAO();
        this.view.setController(this);
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
    
    public void addCustomer(){
        view.limpiarCampos();
    }
    
    public void updateCustomer(){
        try{
            People people = new People(
                    Integer.parseInt(view.txtID.getText()),
                    view.txtName.getText(),
                    view.txtIdentification.getText(),
                    view.txtPhone.getText(),
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
                view.getTxtPhone().setText(people.getPhone());
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
}
