package MVC.controlador;

import MVC.modelo.Inventory;
import MVC.modelo.Supplier;
import MVC.modelo.dao.InventoryDAO;
import MVC.modelo.dao.SupplierDAO;
import MVC.vista.vistaGestionInventory;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InventoryController {
    private vistaGestionInventory view;
    private InventoryDAO inventoryDAO;
    private SupplierDAO supplierDAO;

    public InventoryController(vistaGestionInventory view) {
        this.view = view;
        this.inventoryDAO = new InventoryDAO();
        this.supplierDAO = new SupplierDAO();
        this.view.setController(this);
        loadSuppliers();
    }
     
    private void loadSuppliers() {
        List<String> suppliers = supplierDAO.getAllSupplierss();
        System.out.println("Proveedores obtenidos: " + suppliers);
        for (String supplier : suppliers) {
            view.getBtnSupplier().addItem(supplier);
        }
    } 
    
    public void listInventory(){
        try {
            List<Inventory> inventory = inventoryDAO.getAllInventories();
            DefaultTableModel model = (DefaultTableModel) view.getTableInventary().getModel();
            model.setRowCount(0);
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            for (Inventory inventories : inventory) {
                Object[] row = {
                        inventories.getId(),
                        inventories.getName(),
                        inventories.getType(),
                        inventories.getManufacturer(),
                        inventories.getSupplier().getName(),
                        inventories.getPrice(),
                        inventories.getStock(),
                        inventories.getExpirationDate()!= null ? inventories.getExpirationDate() : "N/A",

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            view.showMessage("Error al listar productos: " + e.getMessage());
        }
    }
    
    
    
    public void listReabastecer(){
        try {
            List<Inventory> inventory = inventoryDAO.getAllInventories();
            List<Inventory> reabastecer = inventoryDAO.getAllReabastecer();            
            System.out.println(reabastecer.size());
            DefaultTableModel model2 = (DefaultTableModel) view.getTableReabastecer().getModel();
            model2.setRowCount(0);
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            for (Inventory r : reabastecer) {
                System.out.println(r);
                Object[] row = {
                        r.getId(),
                        r.getName(),
                        r.getType(),
                        r.getManufacturer(),
                        r.getSupplier().getName(),
                        r.getPrice(),
                        r.getStock(),
                        r.getExpirationDate()!= null ? r.getExpirationDate() : "N/A",

                };
                model2.addRow(row);
            }
        } catch (Exception e) {
            view.showMessage("Error al listar productos: " + e.getMessage());
        }
    }

    public void addInventory(){
        try{
            List<Inventory> inventoryy = inventoryDAO.getAllInventories();
            List<String> namesProducts = new ArrayList<>();
            for (Inventory inventory : inventoryy) {
                namesProducts.add(inventory.getName());
            }
            String nameProduct = view.getTxtName().getText();


            if(namesProducts.contains(nameProduct)){
                int idSupplier = inventoryDAO.getIdProduct(nameProduct);
                int actualStock = inventoryDAO.getCantProduct(nameProduct);
                int newStock = Integer.parseInt(view.txtStock.getText());
                int totalStock = actualStock + newStock;
                inventoryDAO.updateProduct(totalStock,idSupplier);
                view.showMessage("El producto ya existe en el sistema, se ha actualizado su cantidad");
                view.limpiarCampos();
                listInventory();
            }
            else{
                String supplierName = view.getBtnSupplier().getSelectedItem().toString();
                int supplierID = supplierDAO.getSupplierIdByName(supplierName);
                java.util.Date selectedDate = view.getTxtExpiration().getDate();
                java.sql.Date sqlDate = selectedDate != null ? new java.sql.Date(selectedDate.getTime()) : null;

                Inventory inventory = new Inventory(
                        0,
                        view.getTxtName().getText(),
                        view.getTxtType().getText(),
                        view.getTxtManufacturer().getText(),
                        Integer.parseInt(view.getTxtStock().getText()),
                        Integer.parseInt(view.getTxtPrice().getText()),
                        sqlDate,
                        new Supplier(supplierID, supplierName, null, null, null, null)
                );
                inventoryDAO.addInventory(inventory);
                view.showMessage("agregado exitosamente");
                listInventory();
                listReabastecer();
                view.limpiarCampos();
            }

        }
        catch(Exception e){
            view.showMessage("Error al agregar al inventario: " + e.getMessage());
        }
    }

    public void searchInventory(){
        try{
            int id = Integer.parseInt(view.getTxtID().getText());
            Inventory inventory = inventoryDAO.getInventoryById(id);
            if(inventory != null){
                view.getTxtName().setText(inventory.getName());
                view.getTxtType().setText(inventory.getType());
                view.getTxtManufacturer().setText(inventory.getManufacturer());
                view.getTxtPrice().setText(String.valueOf(inventory.getPrice()));
                view.getTxtStock().setText(String.valueOf(inventory.getStock()));
                if (inventory.getExpirationDate() != null) {
                view.getTxtExpiration().setDate(new java.util.Date(inventory.getExpirationDate().getTime()));
                } else {
                    view.getTxtExpiration().setDate(null); // Limpiar el JDateChooser
                }
                view.getBtnSupplier().setSelectedItem(inventory.getSupplier().getName());
            }
            else {
                view.showMessage("No se encontro el producto dentro del inventario");
                view.limpiarCampos();
            }
        }
        catch (Exception e){
            view.showMessage("Error al buscar en inventario: " + e.getMessage());
            view.limpiarCampos();
        }
    }

    public void limpiarCampos(){
        view.limpiarCampos();
    }
}