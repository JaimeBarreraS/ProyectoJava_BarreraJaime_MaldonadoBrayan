package MVC.modelo;

public class Supplier {
    private int id;
    private String name;
    private String contact;
    private String phone;
    private String email;

    public Supplier() {}

    public Supplier(int id) {
        this.id = id;
    }

    public Supplier(int id, String name, String contact, String phone, String email) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.phone = phone;
        this.email = email;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
