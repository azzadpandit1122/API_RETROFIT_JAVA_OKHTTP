package com.example.movieappusingrecyclerviewretrofit;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movieappusingrecyclerviewretrofit.Model_Class.SingleUserInfo;
import com.example.movieappusingrecyclerviewretrofit.Networking.Api;
import com.example.movieappusingrecyclerviewretrofit.Networking.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUserProfile extends AppCompatActivity {
    ImageView profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user_profile);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SingleUserProfile.this, MainActivity.class));
            }
        });
        profileImage = findViewById(R.id.imageView2);
        TextView FistName = findViewById(R.id.textView);
        TextView LastName = findViewById(R.id.textView5);
        TextView Email = findViewById(R.id.textView6);

        Call<SingleUserInfo> call = RetrofitManager.getApiClient().create(Api.class).SINGLE_USER_INFO_CALL();
        call.enqueue(new Callback<SingleUserInfo>() {
            @Override
            public void onResponse(Call<SingleUserInfo> call, Response<SingleUserInfo> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: "+response.body().toString());
                    Glide.with(SingleUserProfile.this).load(response.body().getData().getAvatar()).apply(new RequestOptions().error(R.drawable.ic_launcher_background)).into(profileImage);
                    FistName.setText(response.body().getData().getFirst_name());
                    LastName.setText(response.body().getData().getLast_name());
                    Email.setText(response.body().getData().getEmail());
                }
            }

            @Override
            public void onFailure(Call<SingleUserInfo> call, Throwable t) {
                Toast.makeText(SingleUserProfile.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}