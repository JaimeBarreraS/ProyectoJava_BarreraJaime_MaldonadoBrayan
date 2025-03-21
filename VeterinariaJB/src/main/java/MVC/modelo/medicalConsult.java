package MVC.modelo;

import java.sql.Time;
import java.util.Date;

public class medicalConsult {
    private int id;
    private Date date;
    private Time time;
    private String reason;
    private String diagnostic;
    private String recommendations;
    private String state;

    public medicalConsult(){}

    public medicalConsult(int id) {
        this.id = id;
    }

    public medicalConsult(int id, Date date, Time time, String reason, String diagnostic, String recommendations, String state) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.diagnostic = diagnostic;
        this.recommendations = recommendations;
        this.state = state;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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
}


