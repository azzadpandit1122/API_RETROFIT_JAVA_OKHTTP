package com.example.movieappusingrecyclerviewretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.movieappusingrecyclerviewretrofit.Adapter.DataAdapter;
import com.example.movieappusingrecyclerviewretrofit.Model_Class.usersResponsModel;
import com.example.movieappusingrecyclerviewretrofit.Networking.Api;
import com.example.movieappusingrecyclerviewretrofit.Networking.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.open);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleUserProfile.class));

            }
        });

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Call<usersResponsModel> call = RetrofitManager.getApiClient().create(Api.class).USERS_RESPONS_MODEL_CALL();
        call.enqueue(new Callback<usersResponsModel>() {
            @Override
            public void onResponse(Call<usersResponsModel> call, Response<usersResponsModel> response) {
                if (response.isSuccessful())
                {
                 //   data = response.body().getData();
                    recyclerView.setAdapter(new DataAdapter(getApplicationContext(),response.body().getData()));
                }
            }

            @Override
            public void onFailure(Call<usersResponsModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
//

    }
}