package com.example.movieappusingrecyclerviewretrofit.Networking;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static Retrofit retrofit = null;
    private static String BASE_URL ="https://reqres.in/";

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static Api getApi() {
        return retrofit.create(Api.class);
    }

    private static OkHttpClient getOkHttpClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true);
        //Print Log
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
        builder.connectionPool(new ConnectionPool(0, 5, TimeUnit.MINUTES));
        return builder.readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

    }
}
