package com.example.collegefinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.collegefinder.View.AboutUs;
import com.example.collegefinder.View.ContactUs;
import com.example.collegefinder.View.Home;
import com.example.collegefinder.View.Recycle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    Home homeFragment = new Home();

    Recycle recycleActivity = new Recycle();
    ContactUs contactUsFragment = new ContactUs();
    AboutUs aboutUsFragment = new AboutUs();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.contact) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, contactUsFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutUsFragment).commit();
            return true;
        }else {
            return false;
        }
    }

}