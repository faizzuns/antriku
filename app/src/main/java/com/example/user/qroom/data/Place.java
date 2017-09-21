package com.example.user.qroom.data;

/**
 * Created by User on 19/09/2017.
 */

public class Place {
    int id;
    String namaTempat;
    String location;
    int jamBuka;
    int jamTutup;
    int foto;

    public Place(int id,String namaTempat, String location, int jamBuka, int jamTutup, int foto) {
        this.id = id;
        this.namaTempat = namaTempat;
        this.location = location;
        this.jamBuka = jamBuka;
        this.jamTutup = jamTutup;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getJamBuka() {
        return jamBuka;
    }

    public void setJamBuka(int jamBuka) {
        this.jamBuka = jamBuka;
    }

    public int getJamTutup() {
        return jamTutup;
    }

    public void setJamTutup(int jamTutup) {
        this.jamTutup = jamTutup;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
