package com.example.user.qroom;

/**
 * Created by denail on 17/09/20.
 */

public class Data {
    public Integer id;
    public String name;

    public Data(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
