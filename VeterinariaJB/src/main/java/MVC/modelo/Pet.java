package MVC.modelo;

import java.util.Date;

public class Pet {
    private int id;
    private String name;
    private String specie;
    private String race;
    private int age;
    private Date dateBirth;
    private String sex;
    private String microchipTattoo;
    private String photo;
    private People costumer_id;

    public Pet(int id, String name, String specie, String race, int age, Date dateBirth, String sex, String microchipTattoo, String photo, People costumer) {
        this.id = id;
        this.name = name;
        this.specie = specie;
        this.race = race;
        this.age = age;
        this.dateBirth = dateBirth;
        this.sex = sex;
        this.microchipTattoo = microchipTattoo;
        this.photo = photo;
        this.costumer_id = costumer;
    }

    public Pet() {

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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMicrochipTattoo() {
        return microchipTattoo;
    }

    public void setMicrochipTattoo(String microchipTattoo) {
        this.microchipTattoo = microchipTattoo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public People getCostumer() {
        return costumer_id;
    }

    public void setCostumer(People costumer) {
        this.costumer_id = costumer;
    }
}
