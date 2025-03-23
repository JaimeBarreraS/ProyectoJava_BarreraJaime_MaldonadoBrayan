package MVC.modelo;

public class InventoryConsult {
    private int id;
    private MedicalConsult medicalConsult;
    private Inventory inventory;
    private int quantity;

    public InventoryConsult(int id, MedicalConsult medicalConsult, Inventory inventory, int quantity) {
        this.id = id;
        this.medicalConsult = medicalConsult;
        this.inventory = inventory;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicalConsult getMedicalConsult() {
        return medicalConsult;
    }

    public void setMedicalConsult(MedicalConsult medicalConsult) {
        this.medicalConsult = medicalConsult;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
