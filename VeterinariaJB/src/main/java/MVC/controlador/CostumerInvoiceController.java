package MVC.controlador;

import MVC.modelo.Invoice;
import MVC.modelo.dao.InvoiceDAO;
import MVC.vista.vistaCostumerInvoice;
import MVC.vista.vistaVerCostumerInvoice;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CostumerInvoiceController {
    private vistaCostumerInvoice view;
    private InvoiceDAO invoiceDAO;

    public CostumerInvoiceController(vistaCostumerInvoice view) {
        this.view = view;
        this.invoiceDAO = new InvoiceDAO();
        this.view.setController(this);
        listInvoice();
        view.getJButton1().addActionListener(e -> viewInvoice());
    }

    private void listInvoice() {
        try {
            List<Invoice> invoice = invoiceDAO.getAllInvoices();
            DefaultTableModel modelo = (DefaultTableModel) view.getTableFac().getModel();
            modelo.setNumRows(0);
            for (Invoice invoices : invoice) {
                Object[] row = {
                        invoices.getId(),
                        invoices.getCostumer().getName(),
                        invoices.getDate(),
                        invoices.getTotal(),
                        invoices.getTax()
                };
                modelo.addRow(row);
            }
        } catch (Exception e) {
            view.showMessage("Error al listar facturas: " + e.getMessage());
        }
    }

    public void searchInvoice(){
        try {
            int id = Integer.parseInt(view.txtID.getText());
            Invoice invoice = invoiceDAO.getInvoiceById(id);

            if (invoice != null) {
                view.txtCliente.setText(invoice.getCostumer().getName());
                view.txtFecha.setText(invoice.getDate().toString());
                view.txtTotal.setText(String.valueOf(invoice.getTotal()));
                view.txtImpuesto.setText(String.valueOf(invoice.getTax()));

            } else {
                view.showMessage("Error al buscar factura: " + id);
            }
        } catch (Exception e){
            view.showMessage("Error al buscar factura: " + e.getMessage());
        }
    }

    public void viewInvoice() {
        try {
            vistaVerCostumerInvoice viewInvoice = new vistaVerCostumerInvoice();

            // Pasar los datos de la vista actual a la nueva vista
            viewInvoice.setTxtID(view.getTxtID());
            viewInvoice.setTxtCliente(view.getTxtCliente());
            viewInvoice.setTxtFecha(view.getTxtFecha());
            viewInvoice.setTxtTotal(view.getTxtTotal());
            viewInvoice.setTxtIva(view.getTxtImpuesto());
            viewInvoice.setTxtTotal2(view.getTxtTotal()); // Para el segundo campo de total

            viewInvoice.setVisible(true);
            view.setVisible(false);
            view.dispose();
        } catch (Exception e) {
            view.showMessage("Error al mostrar factura: " + e.getMessage());
        }
    }
}
