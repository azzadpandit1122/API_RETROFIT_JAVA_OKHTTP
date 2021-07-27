package com.example.movieappusingrecyclerviewretrofit.Networking;

import com.example.movieappusingrecyclerviewretrofit.Model_Class.FetchUserRespons;
import com.example.movieappusingrecyclerviewretrofit.Model_Class.SpinData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface Api {
    @GET("Api/Rebliss/GetMarkAttendanceUserInfo/0")
    Call<SpinData> fetchUser();

}
