package com.example.user.qroom.DataModel.Antrian;

import com.example.user.qroom.DataModel.Place.PlaceModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by User on 04/09/2017.
 */

public interface AntrianGetAPI {

    @GET("/out_antrian.php?")
    Call<AntrianModel> getAntrianByPlace(@Query("place_id") Integer placeId);
    Call<AntrianModel> getAntrianById(@Query("id") Integer id);
}
