package MVC.modelo;

import java.sql.Date;

public class Vaccine {
    private int id;
    private Pet pet;
    private String name;
    private String lot;
    private String manufacturer;
    private Date dateApplication;
    private Date nextDose;

    public Vaccine(int id, Pet pet, String name, String lot, String manufacturer, Date dateApplication, Date nextDose) {
        this.id = id;
        this.pet = pet;
        this.name = name;
        this.lot = lot;
        this.manufacturer = manufacturer;
        this.dateApplication = dateApplication;
        this.nextDose = nextDose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(Date dateApplication) {
        this.dateApplication = dateApplication;
    }

    public Date getNextDose() {
        return nextDose;
    }

    public void setNextDose(Date nextDose) {
        this.nextDose = nextDose;
    }
}
