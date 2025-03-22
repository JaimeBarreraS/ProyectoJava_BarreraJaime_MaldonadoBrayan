package MVC.modelo;

public class TypeProcedures {
    private int id;
    private String name;
    private int price;

    public TypeProcedures() {}

    public TypeProcedures(int id) {
        this.id = id;
    }

    public TypeProcedures(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
