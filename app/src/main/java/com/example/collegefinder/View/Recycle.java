package com.example.collegefinder.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.collegefinder.Model.ResponseModel;
import com.example.collegefinder.R;
import com.example.collegefinder.Utilities.apiController;
import com.example.collegefinder.Utilities.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Recycle extends AppCompatActivity {

    RecyclerView recView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        recView = findViewById(R.id.recView);
        recView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(new ArrayList<>(), this);
        recView.setAdapter(myAdapter);

        processdata();
    }

    public void processdata() {
        Call<List<ResponseModel>> call = apiController
                .getInstance()
                .getapi()
                .getData();

        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<ResponseModel>> call, @NonNull Response<List<ResponseModel>> response) {
                if (response.isSuccessful()) {
                    List<ResponseModel> dataList = response.body();
                    if (dataList != null && !dataList.isEmpty()) {
                        myAdapter.updateList(new ArrayList<>(dataList));
                    } else {
                        Toast.makeText(Recycle.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Recycle.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ResponseModel>> call, @NonNull Throwable t) {
                Toast.makeText(Recycle.this, "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
