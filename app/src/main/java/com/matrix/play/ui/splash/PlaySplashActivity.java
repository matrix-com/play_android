package com.matrix.play.ui.splash;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.matrix.play.ui.login.LoginActivity;
import com.matrix.play.ui.main.MainActivity;
import com.matrix.play.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;


import static com.matrix.play.util.Constants.SPLASH_ANIMATION_CIRCULAR_REVEAL_DURATION;
import static com.matrix.play.util.Constants.SPLASH_ANIMATION_PATH_FILL_DURATION;
import static com.matrix.play.util.Constants.SPLASH_ANIMATION_STROKE_DRAWING_DURATION;
import static com.matrix.play.util.Constants.SPLASH_ANIMATION_TITLE_DURATION;
import static com.matrix.play.util.Constants.SPLASH_ANIMATION_TITLE_SVG_PATH;
import static com.matrix.play.util.Constants.SPLASH_PATH_ORIGINAL_HEIGHT;
import static com.matrix.play.util.Constants.SPLASH_PATH_ORIGINAL_WIDTH;
import static com.matrix.play.util.Constants.SPLASH_PATH_STROKE_SIZE;
import static com.matrix.play.util.Constants.SPLASH_TITLE_TEXT_SIZE;


public class PlaySplashActivity extends AwesomeSplash {


    public void initSplash(ConfigSplash configSplash) {

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.colorPrimary);
        configSplash.setAnimCircularRevealDuration(SPLASH_ANIMATION_CIRCULAR_REVEAL_DURATION);
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Path
        configSplash.setPathSplash(SPLASH_ANIMATION_TITLE_SVG_PATH); //set path String
        configSplash.setOriginalHeight(SPLASH_PATH_ORIGINAL_HEIGHT); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(SPLASH_PATH_ORIGINAL_WIDTH); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(SPLASH_ANIMATION_STROKE_DRAWING_DURATION);
        configSplash.setPathSplashStrokeSize(SPLASH_PATH_STROKE_SIZE); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.White); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(SPLASH_ANIMATION_PATH_FILL_DURATION);
        configSplash.setPathSplashFillColor(R.color.White); //path object filling color


        //Customize Logo
        //configSplash.setLogoSplash(R.drawable.ic_app_splash);
        //configSplash.setAnimLogoSplashDuration(SPLASH_ANIMATION_LOGO_SPLASH_DURATION);
        //configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);

        //Customize Title
        configSplash.setTitleSplash(getString(R.string.text_splash_screen_title));
        configSplash.setTitleTextColor(R.color.White);
        configSplash.setTitleTextSize(SPLASH_TITLE_TEXT_SIZE);
        configSplash.setAnimTitleDuration(SPLASH_ANIMATION_TITLE_DURATION);
        configSplash.setAnimTitleTechnique(Techniques.FadeIn);

    }

    @Override
    public void animationsFinished() {
        startActivity(new Intent(PlaySplashActivity.this, LoginActivity.class));
        //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
}
