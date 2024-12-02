package com.example.wscube1.ApiCallDemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiCallInterface {

    @Headers({"Accept: application/json"})
    @GET("/users")
    Call<List<UserModel>> getUser();

}
