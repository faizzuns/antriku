package com.example.user.qroom;

import android.util.Log;

/**
 * Created by denail on 17/09/20.
 */

public class Print {
    public static final String id = "id";
    public static final String name = "name";

    public Print(Integer id, String name) {
        Log.d("TEST", String.valueOf(id + " " + name));
    }
}
