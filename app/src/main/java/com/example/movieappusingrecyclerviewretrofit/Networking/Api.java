package com.example.movieappusingrecyclerviewretrofit.Networking;

import com.example.movieappusingrecyclerviewretrofit.Model_Class.FetchUserRespons;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("v3/c2b5a5f0-dfc7-4057-8409-5b67bb1c1883")
    Call<FetchUserRespons> fetchUser();

}
