package MVC.modelo;

public class Procedures {
    private int id;
    private MedicalConsult medicalConsult;
    private String description;
    private TypeProcedures typeProcedures;

    public Procedures(int id, MedicalConsult medicalConsult, String description, TypeProcedures typeProcedures) {
        this.id = id;
        this.medicalConsult = medicalConsult;
        this.description = description;
        this.typeProcedures = typeProcedures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicalConsult getMedicalConsult() {
        return medicalConsult;
    }

    public void setMedicalConsult(MedicalConsult medicalConsult) {
        this.medicalConsult = medicalConsult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeProcedures getTypeProcedures() {
        return typeProcedures;
    }

    public void setTypeProcedures(TypeProcedures typeProcedures) {
        this.typeProcedures = typeProcedures;
    }
}
