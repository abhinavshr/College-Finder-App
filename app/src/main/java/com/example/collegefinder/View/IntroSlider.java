package com.example.collegefinder.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.collegefinder.R;

public class IntroSlider extends AppCompatActivity {

    private static final String TAG = "IntroSlider";
    private Button next;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_silder);

        next = findViewById(R.id.btnNext);
        viewPager = findViewById(R.id.viewpager);

        int[] layout = {
                R.layout.firstintro,
                R.layout.secondintro,
                R.layout.thirdintro
        };

        viewPager.setAdapter(new PagerAdapter() {
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                LayoutInflater layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = layoutInflater.inflate(layout[position],container,false );
                container.addView(view);
                return view;
            }

            @Override
            public int getCount() {
                return layout.length;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                View view = (View) object;
                container.removeView(view);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e(TAG, "onPageSelected: "+position );
                if(position == 2){
                    next.setText("Explore");
                }else {
                    next.setText(R.string.next);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = viewPager.getCurrentItem();
                if(current < layout.length-1){
                    viewPager.setCurrentItem(current + 1);
                } else {
                    launchDashboard();
                }
            }

            private void launchDashboard() {
                startActivity(new Intent(IntroSlider.this, Login.class));
            }
        });
    }
}