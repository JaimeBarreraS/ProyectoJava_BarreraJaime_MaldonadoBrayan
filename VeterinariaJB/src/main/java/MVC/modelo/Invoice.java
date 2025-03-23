package MVC.modelo;

import java.sql.Date;

public class Invoice {
    private int id;
    private People costumer;
    private Date date;
    private double total;
    private double tax;
    private String cufe;
    private String qr;

    public Invoice(int id, People costumer, Date date, double total, double tax, String cufe, String qr) {
        this.id = id;
        this.costumer = costumer;
        this.date = date;
        this.total = total;
        this.tax = tax;
        this.cufe = cufe;
        this.qr = qr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public People getCostumer() {
        return costumer;
    }

    public void setCostumer(People costumer) {
        this.costumer = costumer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getCufe() {
        return cufe;
    }

    public void setCufe(String cufe) {
        this.cufe = cufe;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }
}
