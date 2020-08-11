package com.matrix.play;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import static com.matrix.play.Constants.ANIMATION_CIRCULAR_REVEAL_DURATION;
import static com.matrix.play.Constants.ANIMATION_LOGO_SPLASH_DURATION;
import static com.matrix.play.Constants.ANIMATION_TITLE_DURATION;


public class PlaySplashActivity extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.colorPrimary);
        configSplash.setAnimCircularRevealDuration(ANIMATION_CIRCULAR_REVEAL_DURATION);
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);

        //Customize Logo
        configSplash.setLogoSplash(R.drawable.ic_app_splash);
        configSplash.setAnimLogoSplashDuration(ANIMATION_LOGO_SPLASH_DURATION);
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);

        //Customize Title
        configSplash.setTitleSplash(getString(R.string.text_splash_screen_title));
        configSplash.setTitleTextColor(R.color.White);
        configSplash.setTitleTextSize(30f);
        configSplash.setAnimTitleDuration(ANIMATION_TITLE_DURATION);
        configSplash.setAnimTitleTechnique(Techniques.FadeIn);

    }

    @Override
    public void animationsFinished() {
        startActivity(new Intent(PlaySplashActivity.this, MainActivity.class));
        finish();
    }
}
