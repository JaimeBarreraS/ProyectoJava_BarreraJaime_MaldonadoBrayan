package MVC.controlador;

import MVC.modelo.Inventory;
import MVC.modelo.Supplier;
import MVC.modelo.dao.InventoryDAO;
import MVC.modelo.dao.SupplierDAO;
import MVC.vista.vistaGestionInventory;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
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
            view.showMessage("Error al listar mascotas: " + e.getMessage());
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
                String expirationText = view.getTxtExpiration().getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Ajusta el formato si es necesario
                LocalDate localDate = LocalDate.parse(expirationText, formatter);
                java.sql.Date sqlDate = Date.valueOf(localDate);

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
                view.getTxtStock().setText(String.valueOf(inventory.getStock()));
                view.getTxtExpiration().setText(inventory.getExpirationDate().toString());
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