package MVC.modelo;

import java.sql.Date;

public class Inventory {
    private int id;
    private String name;
    private String type;
    private String manufacturer;
    private int stock;
    private int price;
    private Date expirationDate;
    private Supplier supplier;

    public Inventory(int id, String name, String type, String manufacturer, int stock, int price, Date expirationDate, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.stock = stock;
        this.price = price;
        this.expirationDate = expirationDate;
        this.supplier = supplier;
    }

    public Inventory(int id, int stock) {
        this.id = id;
        this.stock = stock;
    }

    public Inventory(int id, String name, int stock, int price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }    
}
