package MVC.modelo;

import java.util.Date;

public class Inventory {
    private int id;
    private String name;
    private String type;
    private String manufacturer;
    private String stock;
    private Date espirationDate;

    public Inventory() {}

    public Inventory(int id) {
        this.id = id;
    }

    public Inventory(int id, String name, String type, String manufacturer, String stock, Date espirationDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.stock = stock;
        this.espirationDate = espirationDate;
    }

    public int getId() {
        return id;
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

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Date getEspirationDate() {
        return espirationDate;
    }

    public void setEspirationDate(Date espirationDate) {
        this.espirationDate = espirationDate;
    }
}
