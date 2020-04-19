package moh.theamazingappco.bricks;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {


    RadioButton rbEasy,rbHard;

    Button btnPlay,btnHelp;

    private InterstitialAd mInterstitialAd;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mInterstitialAd = new InterstitialAd(this);
        initializeInterstitialAd("ca-app-pub-6189499490928275~1410551068");
        loadInterstitialAd("ca-app-pub-6189499490928275/1988796256");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                mInterstitialAd.getAdListener().onAdClosed();
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                if(rbEasy.isChecked()) {
                    Intent i = new Intent(getApplicationContext(), GameActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Intent i = new Intent(getApplicationContext(), HardModeActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnHelp = (Button) findViewById(R.id.btnHelp);

        rbEasy = (RadioButton) findViewById(R.id.easyMode);
        rbHard = (RadioButton) findViewById(R.id.hardMode);

        getSupportActionBar().setTitle("GreenBrick RedBrick");

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbEasy.isChecked()) {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                        Intent i = new Intent(getApplicationContext(), GameActivity.class);
                        startActivity(i);
                        finish();
                    }


                }
                if(rbHard.isChecked()){
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                        Intent i = new Intent(getApplicationContext(), HardModeActivity.class);
                        startActivity(i);
                        finish();
                    }

                }
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent i = new Intent(getApplicationContext(),HelpActivity.class);
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
    public void initializeInterstitialAd(String s){
        MobileAds.initialize(this, s);
    }
    public void loadInterstitialAd(String s){
        mInterstitialAd.setAdUnitId(s);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }
}
