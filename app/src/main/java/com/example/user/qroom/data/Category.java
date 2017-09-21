package com.example.user.qroom.data;

/**
 * Created by User on 19/09/2017.
 */

public class Category {

    int status;
    String namaKategori;
    int icon;

    public Category(int status, String namaKategori, int icon) {
        this.status = status;
        this.namaKategori = namaKategori;
        this.icon = icon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
