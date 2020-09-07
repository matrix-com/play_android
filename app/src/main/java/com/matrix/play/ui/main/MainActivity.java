package com.matrix.play.ui.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.matrix.play.R;
import com.matrix.play.util.SharedPreferenceKeys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import static com.matrix.play.util.Constants.PLAY_SHARED_PREFERENCE_NAME;
import static com.matrix.play.util.Constants.colors;
import static com.matrix.play.util.Constants.dnr;
import static com.matrix.play.util.Constants.nmr;
import static com.matrix.play.util.Constants.primaryColor;

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
        isFirstTimeLogin();
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

    public void isFirstTimeLogin(){
        SharedPreferences preferences = getSharedPreferences(PLAY_SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        boolean isFirstTimeLogin = preferences.getBoolean(SharedPreferenceKeys.IS_FIRST_TIME_LOGIN,true);
        if(isFirstTimeLogin){
            displayAlertDialogBox();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(SharedPreferenceKeys.IS_FIRST_TIME_LOGIN,false);
        }

    }
    public void displayAlertDialogBox(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setIcon(R.drawable.login_icon)
                .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}