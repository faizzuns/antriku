package com.example.user.qroom.APIHandler;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.user.qroom.DataModel.Antrian.AntrianSendAPI;
import com.example.user.qroom.DataModel.Person.PersonSendAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by denail on 17/09/20.
 */

public class APICallLib {
    public static final String API_KEY = "a9319aebea880e49c0a46c5e26fe1445";
    public static final String URL_ROOT = "http://dummy.levyson.com/bnihackfest/";

    public static void auth(String email, String password, final OnSendResponse listener) {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(URL_ROOT)
                .build();
        PersonSendAPI api = adapter.create(PersonSendAPI.class);
        api.authPerson(API_KEY, email, password, new Callback<Response>() {
            @Override
            public void success(Response result, Response response) {
                BufferedReader reader;
                String output;
                try {
                    reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                    output = reader.readLine();
                    listener.onSuccess(output);
                } catch (IOException e) {
                    listener.onSuccess(null);
                }
            }
            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(error.toString());
            }
        });
    }

    public static void reserve(Integer id, String token, final OnSendResponse listener) {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(URL_ROOT)
                .build();
        AntrianSendAPI api = adapter.create(AntrianSendAPI.class);
        api.reserve(API_KEY, id, token, new Callback<Response>() {
            @Override
            public void success(Response result, Response response) {
                BufferedReader reader;
                String output;
                try {
                    reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                    output = reader.readLine();
                    listener.onSuccess(output);
                } catch (IOException e) {
                    listener.onSuccess(null);
                }
            }
            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(error.toString());
            }
        });
    }
}
