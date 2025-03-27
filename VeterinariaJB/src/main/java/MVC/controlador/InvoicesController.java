package MVC.controlador;

import MVC.modelo.Inventory;
import MVC.modelo.dao.InventoryDAO;
import MVC.modelo.dao.PeopleDAO;
import MVC.vista.vistaGestionFacturas;
import java.util.ArrayList;
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
                        inventories.getPrice(),
                        inventories.getExpirationDate()!= null ? inventories.getExpirationDate() : "N/A",

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            view.showMessage("Error al listar mascotas: " + e.getMessage());
        }
    }
    List<Inventory> carrito = new ArrayList<>(); //Lista en la que se van a guardar los productos
                                                 //que se van a comprar 
    public void addProduct(){
        try{
            int idProducto = Integer.parseInt(view.getTxtID().getText());
            String Cliente = view.getBtnClient().getSelectedItem().toString();
            Inventory inventory = new Inventory(
                Integer.parseInt(view.getTxtID().getText()),
                inventoryDAO.getNameProduct(idProducto),
                Integer.parseInt(view.getTxtCantidad().getText()),
                inventoryDAO.getPriceProduct(idProducto)      
            );
            
            carrito.add(inventory);
            DefaultTableModel model = (DefaultTableModel) view.getTablePurchase().getModel();
            model.setRowCount(0);
            for (Inventory c : carrito) {
                Object[] row = {
                    c.getId(),
                    c.getName(),
                    c.getStock(),
                    c.getPrice(),
                    c.getPrice()*c.getStock()
                };
                model.addRow(row);
            }            
        }
        catch(Exception e){
            view.showMessage("Error al agregar producto" + e.getMessage());
        }           
    }
    public void crearFactura(){         
        try{
            for (Inventory c : carrito) {
                c.getStock();
                
            }
            limpiarCampos();
            listInventory();
        }
        catch(Exception e){
            view.showMessage("Error al realizar la compra " + e.getMessage());
        }  
    }
    
    public void limpiarCampos(){
        view.limpiarCampos();
    }
}
