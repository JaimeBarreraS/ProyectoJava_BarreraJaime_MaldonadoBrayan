package MVC.modelo;

import java.util.Date;

public class Vaccine {
    private int id;
    private String name;
    private String lot;
    private Date date_application;
    private Date next_dose;

    public Vaccine() {}

    public Vaccine(int id) {
        this.id = id;
    }

    public Vaccine(int id, String name, String lot, Date date_application, Date next_dose) {
        this.id = id;
        this.name = name;
        this.lot = lot;
        this.date_application = date_application;
        this.next_dose = next_dose;
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

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Date getDate_application() {
        return date_application;
    }

    public void setDate_application(Date date_application) {
        this.date_application = date_application;
    }

    public Date getNext_dose() {
        return next_dose;
    }

    public void setNext_dose(Date next_dose) {
        this.next_dose = next_dose;
    }
}
