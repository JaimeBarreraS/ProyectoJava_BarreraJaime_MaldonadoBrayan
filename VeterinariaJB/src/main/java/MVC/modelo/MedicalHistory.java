package MVC.modelo;

public class MedicalHistory {
    private int id;
    private String allergies;
    private String pre_conditions;
    private String weight;

    public MedicalHistory() {
    }

    public MedicalHistory(int id) {
        this.id = id;
    }

    public MedicalHistory(int id, String allergies, String pre_conditions, String weight) {
        this.id = id;
        this.allergies = allergies;
        this.pre_conditions = pre_conditions;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getPre_conditions() {
        return pre_conditions;
    }

    public void setPre_conditions(String pre_conditions) {
        this.pre_conditions = pre_conditions;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
