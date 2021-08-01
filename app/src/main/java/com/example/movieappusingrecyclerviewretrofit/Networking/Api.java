package com.example.movieappusingrecyclerviewretrofit.Networking;

import com.example.movieappusingrecyclerviewretrofit.Model_Class.SingleUserInfo;
import com.example.movieappusingrecyclerviewretrofit.Model_Class.usersResponsModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("api/users?page=2")
    Call<usersResponsModel> USERS_RESPONS_MODEL_CALL();

    @GET("api/users/2")
    Call<SingleUserInfo> SINGLE_USER_INFO_CALL();


}
