package com.example.collegefinder.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collegefinder.Model.RequestRegister;
import com.example.collegefinder.R;
import com.example.collegefinder.Utilities.ClientApi;

public class Register extends AppCompatActivity {

    TextView click;

    Button bttn;

    private EditText etUserName, etEmail, etPassword, etRePass, etFirstName, etLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        click = findViewById(R.id.tvAlready);
        etUserName = findViewById(R.id.etUserName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etRePass = findViewById(R.id.etRePass);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName =findViewById(R.id.etLastName);


        bttn = findViewById(R.id.btnRegister);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
                RequestRegister registerRequest = new RequestRegister(etFirstName.getText().toString(), etLastName.getText().toString(), etUserName.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString());
                ClientApi clientApi = new ClientApi();
                clientApi.registerUser(registerRequest);
                System.out.println(registerRequest);
                showSuccessToast("Data saved successfully!");
            }
        });


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }

    private void checkCredentials() {
        String username = etUserName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String repassed = etRePass.getText().toString();

        if (username.isEmpty() || username.length()<7){
            showError(etUserName,"Your username is not valid!");
        } else if (!email.contains("@")) {
            showError(etEmail,"Email is not correct");
        } else if (password.isEmpty() || password.length()<7) {
            showError(etPassword,"Password must be greater than 7 character");
        } else if (repassed.isEmpty()) {
            showError(etRePass, "Your Password is empty");
        } else if (!repassed.equals(password)) {
            showError(etRePass, "Your password didn't match");
        } else {
            System.out.println();
        }
    }

    private void showError(EditText input, String a) {
        input.setError(a);
        input.requestFocus();
    }

    private void showSuccessToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}