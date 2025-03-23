package MVC.modelo;

public class InvoiceDetails {
    private int id;
    private Invoice invoice;
    private String description;
    private int quantity;
    private double unitValue;
    private double subtotal;
    private Inventory inventory;

    public InvoiceDetails(int id, Invoice invoice, String description, int quantity, double unitValue, double subtotal, Inventory inventory) {
        this.id = id;
        this.invoice = invoice;
        this.description = description;
        this.quantity = quantity;
        this.unitValue = unitValue;
        this.subtotal = subtotal;
        this.inventory = inventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
