package MVC.modelo;

public class MedicalHistory {
    private int id;
    private Pet pet;
    private String allergies;
    private String preConditions;
    private String weight;

    public MedicalHistory(int id, Pet pet, String allergies, String preConditions, String weight) {
        this.id = id;
        this.pet = pet;
        this.allergies = allergies;
        this.preConditions = preConditions;
        this.weight = weight;
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

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getPreConditions() {
        return preConditions;
    }

    public void setPreConditions(String preConditions) {
        this.preConditions = preConditions;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
