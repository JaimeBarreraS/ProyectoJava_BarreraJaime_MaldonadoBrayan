package MVC.modelo;

public class InvoiceDetails {
    private int id;
    private String description;
    private int quantity;
    private int unitValue;
    private int subtotal;

    public InvoiceDetails() {}

    public InvoiceDetails(int id) {
        this.id = id;
    }

    public InvoiceDetails(int id, String description, int quantity, int unitValue, int subtotal) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.unitValue = unitValue;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
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

    public int getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(int unitValue) {
        this.unitValue = unitValue;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
