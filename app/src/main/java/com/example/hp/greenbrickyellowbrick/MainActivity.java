package com.example.hp.greenbrickyellowbrick;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import moh.theamazingappco.bricks.GameActivity;
import moh.theamazingappco.bricks.HardModeActivity;
import moh.theamazingappco.bricks.HelpActivity;
import moh.theamazingappco.bricks.R;


public class MainActivity extends AppCompatActivity {


    RadioButton rbEasy,rbHard;

    Button btnPlay,btnHelp,btnStats;
    TextView cs,hs,it;
    RadioGroup rg;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        it = (TextView) findViewById(R.id.infoText);
        rg = (RadioGroup) findViewById(R.id.radgrp);



        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnHelp = (Button) findViewById(R.id.btnHelp);
        btnStats = (Button) findViewById(R.id.btnScore);

        rbEasy = (RadioButton) findViewById(R.id.easyMode);
        rbHard = (RadioButton) findViewById(R.id.hardMode);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.easyMode :
                        it.setText("In Easy Mode you get 10 tries to guess the word.\nYou can use random 4 letter words.");
                        break;
                    case R.id.hardMode:
                        it.setText("In Hard Mode you get 7 tries to guess the word.\nYou can only use dictionary words.");
                        break;
                }
            }
        });

        getSupportActionBar().setTitle("Bricks");

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbEasy.isChecked()) {

                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                        Intent i = new Intent(getApplicationContext(), GameActivity.class);
                        startActivity(i);
                        finish();



                }
                if(rbHard.isChecked()){

                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                        Intent i = new Intent(getApplicationContext(), HardModeActivity.class);
                        startActivity(i);
                        finish();


                }
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent i = new Intent(getApplicationContext(), HelpActivity.class);
            startActivity(i);

            }
        });

        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ScoreBoard.class);
                startActivity(i);

            }
        });

    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit this game", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
