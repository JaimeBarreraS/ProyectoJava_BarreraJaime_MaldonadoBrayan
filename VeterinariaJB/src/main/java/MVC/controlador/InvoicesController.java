package MVC.controlador;

import MVC.modelo.Inventory;
import MVC.modelo.Invoice;
import MVC.modelo.People;
import MVC.modelo.dao.InventoryDAO;
import MVC.modelo.dao.InvoiceDAO;
import MVC.modelo.dao.PeopleDAO;
import MVC.vista.vistaGestionFacturas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import javax.swing.*;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.List;

public class InvoicesController {
    private vistaGestionFacturas view;
    private InventoryDAO inventoryDAO;
    private PeopleDAO peopleDAO;
    private InvoiceDAO invoiceDAO;
    
    public InvoicesController(vistaGestionFacturas view){
        this.view = view;
        this.inventoryDAO = new InventoryDAO();
        this.peopleDAO = new PeopleDAO();
        this.invoiceDAO = new InvoiceDAO();
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
    
    public void listPurchase(){
        try{
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
            view.showMessage("Error al listar carrito " + e.getMessage());
        }
    }
    
    
    List<Inventory> carrito = new ArrayList<>(); //Lista en la que se van a guardar los productos
                                                 //que se van a comprar 
    public void addProduct(){
        try{
            int idProducto = Integer.parseInt(view.getTxtID().getText());
            //String Cliente = view.getBtnClient().getSelectedItem().toString();
            Inventory inventory = new Inventory(
                Integer.parseInt(view.getTxtID().getText()),
                inventoryDAO.getNameProduct(idProducto),
                Integer.parseInt(view.getTxtCantidad().getText()),
                inventoryDAO.getPriceProduct(idProducto)      
            );
            boolean ExistsInPurchase = true;
            for (Inventory c : carrito) {
                if(c.getId() == inventory.getId()){
                    ExistsInPurchase = true;
                    if(inventoryDAO.getStockProduct(c.getId())< c.getStock()+inventory.getStock()){
                        view.showMessage("Estás excendiendo la cantidad que hay en Stock");
                        limpiarCampos();
                        listPurchase();
                        break;
                    }
                    else{
                        c.setStock(c.getStock()+inventory.getStock());
                        listPurchase();
                    }                    
                }
                else{
                    ExistsInPurchase = false;
                }
            }
            
            if(ExistsInPurchase == false || carrito.isEmpty()){
            int newStock = inventoryDAO.getStockProduct(inventory.getId())-inventory.getStock();
                    if(newStock>0){
                        carrito.add(inventory);
                        limpiarCampos();
                        listPurchase();
                    }
                    else{
                        view.showMessage("No puedes añadir más de la cantidad que hay en stock");
                        limpiarCampos();
                        listPurchase();
                    } 
            }
        }
        catch(Exception e){
            view.showMessage("Error al agregar producto" + e.getMessage());
        }           
    }
    public void crearFactura(){         
        try{
            if(carrito.isEmpty()){
                view.showMessage("No se puede crear la factura ya que no se han añadido productos");
            }
            else{
                boolean aceptar = false;
                for (Inventory c : carrito) {
                    int newStock = inventoryDAO.getStockProduct(c.getId())-c.getStock();
                    if(newStock<= 0){
                        carrito.remove(c);
                        limpiarCampos();
                        listInventory();
                        listPurchase();
                        view.showMessage("No se pueden adquirir más productos de los que hay en Stock");
                        aceptar = false;
                        break;
                    }
                    else{
                        aceptar = true;          
                        inventoryDAO.updateProduct(newStock, c.getId());
                        listInventory();
                        listPurchase();
                    }
                }
                if(!aceptar){
                    view.showMessage("No se pudo realizar la compra");
                    
                }
                else{
                    String clientName = view.getBtnClient().getSelectedItem().toString();
                        int idClient = peopleDAO.getIdPeople(clientName);
                        Date fechaActual = new Date(System.currentTimeMillis());
                        double total = 0;
                        for (Inventory ca : carrito) {
                            total+=ca.getStock()*ca.getPrice();
                        }
                        double totalTax = total*0.19;
                        
                        Invoice invoice = new Invoice(
                            new People(idClient, clientName, null, null, null, null, null, null), // Cliente,
                            fechaActual,
                            total,
                            totalTax,
                            null,
                            null
                        );                      
                        invoiceDAO.addInvoice(invoice);  
                }
            }
        }
        catch(Exception e){
            view.showMessage("Error al realizar la compra " + e.getMessage());
        }  
    }
    
    public void limpiarCampos(){
        view.limpiarCampos();
    }
    
    public void limpiarCarrito(){
        carrito.clear();
        listPurchase();
    }
    
    public void CreateInvoice() {
        try {
            JFileChooser fileChooser = new JFileChooser(); //Se crea un selector de archivos
            fileChooser.setDialogTitle("Guardar Factura"); //El titulo del cuadro de diálogo
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //Lo limita a seleccionar solo archivos
            fileChooser.setSelectedFile(new File("factura.pdf")); //Se le sugiere un nombre al archivo de la factura

            int userSelection = fileChooser.showSaveDialog(null);

            // Si el usuario no selecciona nada, se sale de la función
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File fileToSave = fileChooser.getSelectedFile();
            String rutaArchivo = fileToSave.getAbsolutePath();
            // Asegura que el archivo termine en ".pdf" para evitar inconvenientes
            if (!rutaArchivo.toLowerCase().endsWith(".pdf")) {
                rutaArchivo += ".pdf"; // Y si no tiene la terminación ".pdf" se la agrega
            }
            String nombreCliente = view.getBtnClient().getSelectedItem().toString(); //Se obtiene el nombre del cliente con el que se va a relacionar la factura
            
            //Se crea el documento y se abre para agregarle la información
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
            document.open();

            // Crear tabla para el encabezado (2 columnas: Título y Logo)
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);
            headerTable.setWidths(new float[]{80, 20}); // se le da 80% del espacio para el título y el otro 20% para el logo

            // personalización de la celda del título
            Font tituloFuente = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            PdfPCell tituloCell = new PdfPCell(new Phrase("Factura - VeterinariaJB", tituloFuente));
            tituloCell.setBorder(Rectangle.NO_BORDER); // Sin bordes
            tituloCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tituloCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            headerTable.addCell(tituloCell);

            // personalización de la celda del logo
            try {
                Image logo = Image.getInstance("./src/main/resources/media/logo.png"); // Ruta del logo
                logo.scaleAbsolute(80, 80); // Tamaño del logo

                PdfPCell logoCell = new PdfPCell(logo, false);
                logoCell.setBorder(Rectangle.NO_BORDER); // Sin bordes
                logoCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                headerTable.addCell(logoCell);
            } catch (Exception e) {
                System.out.println("No se pudo cargar el logo: " + e.getMessage());
                headerTable.addCell(""); // Celda vacía si no hay logo
            }

            document.add(headerTable);
            document.add(new Paragraph("\n"));

            // Información del cliente
            document.add(new Paragraph("Cliente: " + nombreCliente));
            document.add(new Paragraph("Fecha: " + java.time.LocalDate.now())); // Se crea la factura con la fecha actual
            document.add(new Paragraph("\n"));

            // Validar si hay productos en el carrito antes de generar la tabla
            // Aunque ya se confirma esto antes, es para estar 100% seguro
            if (carrito.isEmpty()) {
                document.add(new Paragraph("No hay productos en esta compra."));
            } else {
                // Crear tabla de productos
                PdfPTable table = new PdfPTable(5); // 5 columnas
                table.setWidthPercentage(100);

                // Encabezados de la tabla
                table.addCell("ID Producto");
                table.addCell("Nombre");
                table.addCell("Cantidad");
                table.addCell("Precio Unitario");
                table.addCell("Subtotal");

                double total = 0;

                for (Inventory item : carrito) {
                    table.addCell(String.valueOf(item.getId()));
                    table.addCell(item.getName());
                    table.addCell(String.valueOf(item.getStock()));  // Cantidad
                    table.addCell(String.format("$%.2f", (double)item.getPrice())); // Precio Unitario
                    double subtotal = item.getStock() * item.getPrice();
                    table.addCell(String.format("$%.2f", subtotal)); // Subtotal
                    total += subtotal;
                }

                document.add(table);
                document.add(new Paragraph("\n"));

                // Calcular impuesto (19%)
                double iva = total * 0.19;
                double totalConIva = total + iva;

                // Mostrar subtotales
                Paragraph subtotalParrafo = new Paragraph("Subtotal: $" + String.format("%.2f", total), 
                new Font(Font.FontFamily.HELVETICA, 12));
                subtotalParrafo.setAlignment(Element.ALIGN_RIGHT);
                document.add(subtotalParrafo);

                Paragraph ivaParrafo = new Paragraph("impuestos: $" + String.format("%.2f", iva), 
                new Font(Font.FontFamily.HELVETICA, 12));
                ivaParrafo.setAlignment(Element.ALIGN_RIGHT);
                document.add(ivaParrafo);

                // Total de la factura con IVA
                Paragraph totalParrafo = new Paragraph("Total a pagar: $" + String.format("%.2f", totalConIva), 
                new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
                totalParrafo.setAlignment(Element.ALIGN_RIGHT);
                document.add(totalParrafo);
            }

            // Mensaje de despedida
            document.add(new Paragraph("\nGracias por visitar la VeterinariaJB"));
            document.add(new Paragraph("\nSu mascota es nuestra prioridad :)"));

            document.close();
            view.showMessage("Factura generada exitosamente en: " + rutaArchivo);
        } catch(Exception e) {
            view.showMessage("Error al generar factura: "+e.getMessage());
        }
    }
}    
