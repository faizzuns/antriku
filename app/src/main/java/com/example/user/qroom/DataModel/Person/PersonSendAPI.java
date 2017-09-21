package com.example.user.qroom.DataModel.Person;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by denail on 17/08/28.
 */

public interface PersonSendAPI {
    String URL_FILE = "/in_person.php";

    @FormUrlEncoded
    @POST(URL_FILE)
    void registerPerson(
        @Field("api_key") String apiKey,
        @Field("name") String name,
        @Field("email") String email,
        @Field("password") String password,
        Callback<Response> callback
    );
    void authPerson(
        @Field("api_key") String apiKey,
        @Field("email") String email,
        @Field("password") String password,
        Callback<Response> callback
    );
}
