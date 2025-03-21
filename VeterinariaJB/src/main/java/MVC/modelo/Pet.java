package MVC.modelo;

import java.util.Date;

public class Pet {
    private int id;
    private String name;
    private String specie;
    private String race;
    private int age;
    private Date date_birth;
    private String microchip_tatto;
    private String photo;

    public Pet() {}

    public Pet(int id) {
        this.id = id;
    }

    public Pet(int id, String name, String specie, String race, int age, Date date_birth, String microchip_tatto, String photo) {
        this.id = id;
        this.name = name;
        this.specie = specie;
        this.race = race;
        this.age = age;
        this.date_birth = date_birth;
        this.microchip_tatto = microchip_tatto;
        this.photo = photo;
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

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public String getMicrochip_tatto() {
        return microchip_tatto;
    }

    public void setMicrochip_tatto(String microchip_tatto) {
        this.microchip_tatto = microchip_tatto;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
