package com.example.collegefinder.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.collegefinder.MainActivity;
import com.example.collegefinder.Model.RequestLogin;
import com.example.collegefinder.R;
import com.example.collegefinder.Utilities.LoginApi;

import retrofit2.Call;
import retrofit2.Callback;

public class Login extends AppCompatActivity {

    TextView btn;

    EditText etUserName, etPassword;

    Button btnLogin;
    LoginApi loginApi = new LoginApi();

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        btn= findViewById(R.id.tvSignUp);
//        etUserName = findViewById(R.id.etUserName);
//        etPassword = findViewById(R.id.etPassword);
//        btnLogin = findViewById(R.id.btnLogin);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkCredentials();
////                RequestLogin requestLogin = new RequestLogin(etUserName.getText().toString(),etPassword.getText().toString());
////                startActivity(new Intent(Login.this, MainActivity.class));
//            }
//        });
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Login.this, Register.class));
//            }
//        });
//    }
//    private void checkCredentials() {
//        String username = etUserName.getText().toString();
//        String password = etPassword.getText().toString();
//
//        if (username.isEmpty()){
//            showError(etUserName,"Your username is not valid!");
//        } else if (password.isEmpty()) {
//            showError(etPassword,"Password is blank");
//        } else {
//            // Create a RequestLogin object with the username and password
//            RequestLogin requestLogin = new RequestLogin(username, password);
//
//            // Call the loginUser method of the LoginApi class
//            LoginApi.loginUser(username, password, new Callback<Object>() {
//                @Override
//                public void onResponse(@NonNull Call<Object> call, @NonNull retrofit2.Response<Object> response) {
//                    if (response.isSuccessful()) {
//                        Log.d("api called", "success "  + response.raw().request());
//                        // Login successful, start MainActivity
//                        startActivity(new Intent(Login.this, MainActivity.class));
//                        finish();
//                        System.out.println("done");
//                    } else {
//                        // Login failed, show error message
//                        Log.d("api called", "failure");
//
//                        showError(etPassword, "Invalid username or password");
//                    }
//                }
//
//                @Override
//                public void onFailure(@NonNull Call<Object> call, @NonNull Throwable t) {
//                    // Request failed, show error message
//                    Log.d("api called", "success "  + t.getMessage());
//
//                    showError(etPassword, "Failed to connect to server");
//                }
//            });
//        }
//    }
//
//    private void showError(EditText input, String a) {
//        input.setError(a);
//        input.requestFocus();
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = findViewById(R.id.tvSignUp);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Login.this, MainActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
}