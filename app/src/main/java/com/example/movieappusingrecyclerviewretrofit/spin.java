package com.example.movieappusingrecyclerviewretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;
import com.example.movieappusingrecyclerviewretrofit.Model_Class.FetchUserRespons;
import com.example.movieappusingrecyclerviewretrofit.Model_Class.SpinData;
import com.example.movieappusingrecyclerviewretrofit.Model_Class.data;
import com.example.movieappusingrecyclerviewretrofit.Networking.RetrofitClient;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class spin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);
        LuckyWheel luckyWheel = findViewById(R.id.spin);
        TextView output = findViewById(R.id.name);

        luckyWheel.setTarget(0);

        luckyWheel.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                Toast.makeText(spin.this, "Target Reached ", Toast.LENGTH_SHORT).show();
            }
        });
        List<WheelItem> wheelitem = new ArrayList<>();
        wheelitem.add(new WheelItem(Color.LTGRAY, BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_name),"1"));
        wheelitem.add(new WheelItem(Color.LTGRAY, BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_name),"2"));
        wheelitem.add(new WheelItem(Color.LTGRAY, BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_name), "3"));

        luckyWheel.addWheelItems(wheelitem);
        Button button = findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText val = findViewById(R.id.target);
                String target =  val.getText().toString();
                int finalValue = Integer.parseInt(target);
                luckyWheel.rotateWheelTo(finalValue);

                Call<SpinData> call = RetrofitClient.getInstance().getApi().fetchUser();
                call.enqueue(new Callback<SpinData>() {

                    @Override
                    public void onResponse(Call<SpinData> call, Response<SpinData> response) {
                        if (response.isSuccessful())
                        {
                            Log.d(TAG, "onResponse: "+response.body().getDesignation());
                            Log.e(TAG, "onResponse: "+response.body().getDesignation() );


                        }

                    }

                    @Override
                    public void onFailure(Call<SpinData> call, Throwable t) {

                    }
                });

            }
        });


    }
}