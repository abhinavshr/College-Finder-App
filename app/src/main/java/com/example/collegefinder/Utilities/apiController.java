package com.example.collegefinder.Utilities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiController {
    private static final String url = "http://10.0.2.2/collegefinder/";
    private static apiController clientobject;
    private static Retrofit retrofit;

    apiController(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized apiController getInstance(){
        if(clientobject==null)
            clientobject= new apiController();

        return clientobject;
    }

    public apiset getapi(){
        return retrofit.create(apiset.class);
    }
}
