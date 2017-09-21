package com.example.user.qroom.DataModel.Person;

import com.example.user.qroom.DataModel.Place.PlaceModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by User on 04/09/2017.
 */

public interface PersonGetAPI {

    @GET("/out_person.php?")
    Call<PersonModel> getPersonData(@Query("id") String id);
}
