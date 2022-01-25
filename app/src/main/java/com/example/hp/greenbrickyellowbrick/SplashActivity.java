package com.example.hp.greenbrickyellowbrick;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import moh.theamazingappco.bricks.R;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME = 1500; //This is 1.5 seconds
    ImageView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        myView = (ImageView) findViewById(R.id.imageView6);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(myView, "alpha",  1f, .3f);
        fadeOut.setDuration(1000);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(myView, "alpha", .3f, 1f);
        fadeIn.setDuration(1000);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(fadeIn).after(fadeOut);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mAnimationSet.start();
            }
        });
        mAnimationSet.start();

        //Code to start timer and take action after the timer ends
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do any action here. Now we are moving to next page
                Intent mySuperIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mySuperIntent);
                /* This 'finish()' is for exiting the app when back button pressed
                 *  from Home page which is ActivityHome
                 */
                finish();
            }
        }, SPLASH_TIME);
    }
}
