
package com.example.user.qroom.DataModel.Person;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dataset {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("antrian_id")
    @Expose
    private Integer antrianId;
    @SerializedName("antrian_numb")
    @Expose
    private Integer antrianNumb;
    @SerializedName("antrian_code")
    @Expose
    private String antrianCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAntrianId() {
        return antrianId;
    }

    public void setAntrianId(Integer antrianId) {
        this.antrianId = antrianId;
    }

    public Integer getAntrianNumb() {
        return antrianNumb;
    }

    public void setAntrianNumb(Integer antrianNumb) {
        this.antrianNumb = antrianNumb;
    }

    public String getAntrianCode() {
        return antrianCode;
    }

    public void setAntrianCode(String antrianCode) {
        this.antrianCode = antrianCode;
    }

}
