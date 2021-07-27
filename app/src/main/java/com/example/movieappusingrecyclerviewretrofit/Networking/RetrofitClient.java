package com.example.movieappusingrecyclerviewretrofit.Networking;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;
//    private static String BASE_URL ="https://run.mocky.io/";
    private static String BASE_URL = "http://color.proinnovativesoftware.co/";
    //Api/Rebliss/GetMarkAttendanceUserInfo/0

    private RetrofitClient()
    {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if (retrofitClient == null)
        {
            retrofitClient= new RetrofitClient();
        }
        return retrofitClient;
    }
    public Api getApi()
    {
        return retrofit.create(Api.class);
    }


    //connection

}