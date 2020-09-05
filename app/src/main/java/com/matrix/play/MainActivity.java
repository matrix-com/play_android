package com.matrix.play;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    public BottomNavigationViewEx bottomNav;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav = findViewById(R.id.bottom_nav_view);
        fab = (FloatingActionButton) findViewById(R.id.fabPlay);
        initBottomNavigationView();

    }

    private void initBottomNavigationView() {
        bottomNav.enableAnimation(false);
        bottomNav.enableItemShiftingMode(false);
        bottomNav.enableShiftingMode(false);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ColorStateList csl = AppCompatResources.getColorStateList(getApplicationContext(), R.color.colorPrimary);
               fab.setBackgroundTintList(csl);
            }
        });
    }
}