package MVC.modelo;

public class Procedures {
    private int id;
    private String description;

    public Procedures() {}

    public Procedures(int id) {
        this.id = id;
    }

    public Procedures(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
