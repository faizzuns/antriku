package com.example.user.qroom.data;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.ArrayList;

/**
 * Created by User on 20/09/2017.
 */

@Table( database = MyDatabase.class)
public class Info extends BaseModel{

    @Column
    @PrimaryKey
            int id;
    @Column
        String judul;
    @Column
        String deskripsi;
    @Column
    String listSyarat;
    @Column
    String listStatus;

    public Info(){}

    public Info(String judul, String deskripsi,String listSyarat,String listStatus) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.listStatus = listStatus;
        this.listSyarat = listSyarat;
        this.id = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListSyarat() {
        return listSyarat;
    }

    public void setListSyarat(String listSyarat) {
        this.listSyarat = listSyarat;
    }

    public String getListStatus() {
        return listStatus;
    }

    public void setListStatus(String listStatus) {
        this.listStatus = listStatus;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}

