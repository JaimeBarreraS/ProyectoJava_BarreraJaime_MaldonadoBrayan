package MVC.modelo;

public class InventoryConsult {
    private int id;
    private int quantity;

    public InventoryConsult() {}

    public InventoryConsult(int id) {
        this.id = id;
    }

    public InventoryConsult(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
