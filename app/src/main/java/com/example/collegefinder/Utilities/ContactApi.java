package com.example.collegefinder.Utilities;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.collegefinder.Model.ContactUsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactApi {

    public Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("http://192.168.101.11/collegefinder/")
            .baseUrl("http://10.0.2.2/collegefinder/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public ServiceApi serviceApi = retrofit.create(ServiceApi.class);
    public void registerContact(ContactUsModel contactUsModel){

        Call<Object> call = serviceApi.contactus(contactUsModel);
        Log.d("api call", "in data ");
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(@NonNull Call<Object> call, @NonNull Response<Object> response) {
                Log.d("api called", "in response");
                if (response.isSuccessful()) {
                    Log.d("api called", "Contact Us registered successfully");
                } else {
                    Log.e("api called", "Failed to register user: " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Object> call, @NonNull Throwable t) {
                Log.e("api called", "Failed to register contact us: " + t.getMessage());
            }
        });
    }
}
