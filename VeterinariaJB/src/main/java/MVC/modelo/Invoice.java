package MVC.modelo;

import java.util.Date;

public class Invoice {
    private int id;
    private Date date;
    private int total;
    private int tax;
    private String cufe;
    private String qr;

    public Invoice() {}

    public Invoice(int id) {
        this.id = id;
    }

    public Invoice(int id, Date date, int total, int tax, String cufe, String qr) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.tax = tax;
        this.cufe = cufe;
        this.qr = qr;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
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
