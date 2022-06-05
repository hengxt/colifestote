package com.example.colifestote.data.api;

import com.example.colifestote.data.bean.Hole;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HoleService {

    @GET("/hole/all")
    Call<List<Hole>> getAll();


    @POST("/hole/insert")
    Call<String> insertOne(
            @Body Hole hole
    );


}
