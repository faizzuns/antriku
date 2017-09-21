package com.example.user.qroom.DataModel.Place;

import com.example.user.qroom.DataModel.Place.PlaceModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by User on 04/09/2017.
 */

public interface PlaceAPI {

    @GET("/out_place.php?")
    Call<PlaceModel> getAllPlace();
    Call<PlaceModel> getFilteredPlace(@Query("keyword") String keyword);
    Call<PlaceModel> getPlaceById(@Query("id") Integer id);
}
