package com.example.movieappusingrecyclerviewretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.movieappusingrecyclerviewretrofit.Adapter.DataAdapter;
import com.example.movieappusingrecyclerviewretrofit.Model_Class.FetchUserRespons;
import com.example.movieappusingrecyclerviewretrofit.Networking.RetrofitClient;
import com.example.movieappusingrecyclerviewretrofit.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<com.example.movieappusingrecyclerviewretrofit.Model_Class.data> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Call<FetchUserRespons> call = RetrofitClient.getInstance().getApi().fetchUser();
        call.enqueue(new Callback<FetchUserRespons>() {
            @Override
            public void onResponse(Call<FetchUserRespons> call, Response<FetchUserRespons> response) {
                if (response.isSuccessful())
                {
                    data = response.body().getData();
                    recyclerView.setAdapter(new DataAdapter(getApplicationContext(),data));
                }
                else {
                    Toast.makeText(MainActivity.this, "Eroroo of Code", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchUserRespons> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}