package com.example.collegefinder.Utilities;


import com.example.collegefinder.Model.RequestLogin;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginApi {

    private static final String TAG = "LoginApi";

    public static Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("http://192.168.222.235/collegefinder/")
            .baseUrl("http://10.0.2.2/collegefinder/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ServiceApi serviceApi = retrofit.create(ServiceApi.class);

    public static void loginUser(String userName, String password, Callback<Object> callback) {
        RequestLogin requestLogin = new RequestLogin(userName, password);

        Call<Object> call = serviceApi.login(requestLogin);
        call.enqueue(callback);
    }

//    private static String hashPassword(String password) {
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
//            Log.e(TAG, "Error hashing password: " + e.getMessage());
//            return null;
//        }
//    }
}
