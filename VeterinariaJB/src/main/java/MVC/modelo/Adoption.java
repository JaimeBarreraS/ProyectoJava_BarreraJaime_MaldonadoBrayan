package MVC.modelo;

public class Adoption {
    private int id;
    private String name;
    private String specie;
    private String race;
    private int age;
    private String sex;
    private String state;
    private People costumer_id;


    public Adoption(String name, String specie, String race, int age, String sex, String state) {
        this.name = name;
        this.specie = specie;
        this.race = race;
        this.age = age;
        this.sex = sex;
        this.state = state;
    }

    public Adoption(int id, String name, String specie, String race, int age, String sex, String state) {
        this.id = id;
        this.name = name;
        this.specie = specie;
        this.race = race;
        this.age = age;
        this.sex = sex;
        this.state = state;
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

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public People getCostumer_id() {
        return costumer_id;
    }

    public void setCostumer_id(People costumer_id) {
        this.costumer_id = costumer_id;
    }
    
    
}
