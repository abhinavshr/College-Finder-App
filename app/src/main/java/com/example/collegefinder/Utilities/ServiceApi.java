package com.example.collegefinder.Utilities;


import com.example.collegefinder.Model.ContactUsModel;
import com.example.collegefinder.Model.RequestLogin;
import com.example.collegefinder.Model.RequestRegister;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceApi {
    @POST("register.php")
    Call<Object> register(@Body RequestRegister request);

    @POST("user.php")
    Call<Object> login(@Body RequestLogin request);

    @POST("contactus.php")
    Call<Object> contactus(@Body ContactUsModel request);
}
