package com.example.movieappusingrecyclerviewretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.movieappusingrecyclerviewretrofit.Adapter.DataAdapter;
import com.example.movieappusingrecyclerviewretrofit.Model_Class.FetchUserRespons;
import com.example.movieappusingrecyclerviewretrofit.Model_Class.data;
import com.example.movieappusingrecyclerviewretrofit.Networking.RetrofitClient;
import com.example.movieappusingrecyclerviewretrofit.R;
import com.example.movieappusingrecyclerviewretrofit.spin;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<data> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = findViewById(R.id.open);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, spin.class);
                startActivity(myIntent);
            }
        });
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

//        Call<FetchUserRespons> call = RetrofitClient.getInstance().getApi().fetchUser();
//        call.enqueue(new Callback<FetchUserRespons>() {
//            @Override
//            public void onResponse(Call<FetchUserRespons> call, Response<FetchUserRespons> response) {
//                if (response.isSuccessful())
//                {
//                    data = response.body().getData();
//                    recyclerView.setAdapter(new DataAdapter(getApplicationContext(),data));
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "Eroroo of Code", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<FetchUserRespons> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}