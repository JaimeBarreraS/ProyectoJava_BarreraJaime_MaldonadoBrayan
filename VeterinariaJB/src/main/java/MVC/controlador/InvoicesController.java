package MVC.controlador;

import MVC.modelo.Inventory;
import MVC.modelo.dao.InventoryDAO;
import MVC.modelo.dao.PeopleDAO;
import MVC.vista.vistaGestionFacturas;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class InvoicesController {
    private vistaGestionFacturas view;
    private InventoryDAO inventoryDAO;
    private PeopleDAO peopleDAO;
    
    public InvoicesController(vistaGestionFacturas view){
        this.view = view;
        this.inventoryDAO = new InventoryDAO();
        this.peopleDAO = new PeopleDAO();
        this.view.setController(this);
        loadClients();
        listInventory();
    }
    
    private void loadClients(){
        List<String> clients = peopleDAO.getAllClientNames();
        System.out.println(clients);
        for(String c : clients){
            view.getBtnClient().addItem(c);
        }               
    }
    
    private void listInventory(){
        try {
            List<Inventory> inventory = inventoryDAO.getAllInventories();
            DefaultTableModel model = (DefaultTableModel) view.getTableInventary().getModel();
            model.setRowCount(0);
            for (Inventory inventories : inventory) {
                Object[] row = {
                        inventories.getId(),
                        inventories.getName(),
                        inventories.getType(),
                        inventories.getManufacturer(),
                        inventories.getSupplier().getName(),
                        inventories.getStock(),
                        inventories.getExpirationDate()!= null ? inventories.getExpirationDate() : "N/A",

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            view.showMessage("Error al listar mascotas: " + e.getMessage());
        }
    }
    
    public void addProduct(){
        try{
            int idProducto = Integer.parseInt(view.getTxtID().getText());
            String Cliente = view.getBtnClient().getSelectedItem().toString();
            
            System.out.println(idProducto + Cliente);
            
        }
        catch(Exception e){
            view.showMessage("Error al agregar producto" + e.getMessage());
        }
    }
}
