package MVC.modelo;

import java.sql.Date;
import java.sql.Time;

public class MedicalConsult {
    private int id;
    private Pet pet;
    private String date;
    private String time;
    private String reason;
    private String diagnostic;
    private String recommendations;
    private String state;
    private People veterinary;

    public MedicalConsult(int id, Pet pet, String date, String time, String reason, String diagnostic, String recommendations, String state, People veterinary) {
        this.id = id;
        this.pet = pet;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.diagnostic = diagnostic;
        this.recommendations = recommendations;
        this.state = state;
        this.veterinary = veterinary;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public People getVeterinary() {
        return veterinary;
    }

    public void setVeterinary(People veterinary) {
        this.veterinary = veterinary;
    }
}
