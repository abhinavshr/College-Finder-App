package com.example.collegefinder.Utilities;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.collegefinder.Model.RequestRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientApi {

    public Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("http://192.168.101.11/collegefinder/")
            .baseUrl("http://10.0.2.2/collegefinder/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public ServiceApi serviceApi = retrofit.create(ServiceApi.class);
    public void registerUser(RequestRegister registerRequest){
        Call<Object> call = serviceApi.register(registerRequest);
        Log.d("api call", "in data ");
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(@NonNull Call<Object> call, @NonNull Response<Object> response) {
                Log.d("api called", "in response");
                if (response.isSuccessful()) {
                    Log.d("api called", "User registered successfully");
                } else {
                    Log.e("api called", "Failed to register user: " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Object> call, @NonNull Throwable t) {
                Log.e("api called", "Failed to register user: " + t.getMessage());
            }
        });
    }
//    public static String hashPassword(String password) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            byte[] messageDigest = md.digest(password.getBytes());
//            StringBuilder hexString = new StringBuilder();
//            for (byte b : messageDigest) {
//                String hex = Integer.toHexString(0xff & b);
//                if (hex.length() == 1) hexString.append('0');
//                hexString.append(hex);
//            }
//            return hexString.toString();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }
}