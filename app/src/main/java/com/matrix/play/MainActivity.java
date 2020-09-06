package com.matrix.play;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.matrix.play.Constants.colors;
import static com.matrix.play.Constants.dnr;
import static com.matrix.play.Constants.nmr;
import static com.matrix.play.Constants.primaryColor;

public class MainActivity extends AppCompatActivity implements BottomNavigationViewEx.OnNavigationItemSelectedListener {

    public BottomNavigationViewEx bottomNav;
    public FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav = findViewById(R.id.bottom_nav_view);
        fab = (FloatingActionButton) findViewById(R.id.fabPlay);
        initBottomNavigationView();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNav.setCurrentItem(2);
                fab.setBackgroundTintList(ColorStateList.valueOf(Color
                        .parseColor(colors.get(nmr%dnr))));
                nmr++;
            }
        });
    }

    private void initBottomNavigationView() {
        bottomNav.enableAnimation(false);
        bottomNav.enableItemShiftingMode(false);
        bottomNav.enableShiftingMode(false);
        bottomNav.setIconSize(30, 30);
        bottomNav.setTextSize(10);
        fab.setBackgroundTintList(ColorStateList.valueOf(Color
                .parseColor(primaryColor)));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case R.id.home :
               item.setChecked(true);
               break;
           case R.id.search :
               item.setChecked(true);
               break;
           case R.id.play :
               item.setChecked(true);
               break;
           case R.id.create :
               item.setChecked(true);
               break;
           case R.id.account :
               item.setChecked(true);
               break;
       }
       return false;
    }
}