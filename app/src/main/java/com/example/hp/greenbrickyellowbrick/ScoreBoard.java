package com.example.hp.greenbrickyellowbrick;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DecimalFormat;

import moh.theamazingappco.bricks.BuildConfig;
import moh.theamazingappco.bricks.HardModeActivity;
import moh.theamazingappco.bricks.R;

public class ScoreBoard extends AppCompatActivity {

    TextView tEasyWin,tEasyLose,tHardwin,tHardlose,tEasyPerc,tHardPerc,tEasyCStreak,tHardCStreak
            ,tEasyHStreak,tHardHStreak,tEasyFG,tEasyLG,tHardFG,tHardLG;

    TextView tWin,tLost,tWinperc,tAS,tMS,tFG,tLG;

    Button btnShare,btnRefresh;

    int iEasyWin,iEasyLose,iHardwin,iHardlose,iEasyCStreak,iHardCStreak
            ,iEasyHStreak,iHardHStreak,iEasyFG,iEasyLG,iHardFG,iHardLG;

    private static final DecimalFormat df = new DecimalFormat("0.00");
    double dEasyPerc,dHardPerc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        getSupportActionBar().setTitle("Bricks Stats");

        tEasyWin = (TextView) findViewById(R.id.tvEasyWin);
        tEasyLose = (TextView) findViewById(R.id.tvEasyLost);
        tHardwin = (TextView) findViewById(R.id.tvHardWin);
        tHardlose = (TextView) findViewById(R.id.tvHardLost);
        tEasyPerc = (TextView) findViewById(R.id.tvEasyWinPerc);
        tHardPerc = (TextView) findViewById(R.id.tvHardWinPerc);
        tEasyCStreak = (TextView) findViewById(R.id.tvEasyCurStreak);
        tHardCStreak = (TextView) findViewById(R.id.tvHardCurStreak);
        tEasyHStreak = (TextView) findViewById(R.id.tvEasyMaxStreak);
        tHardHStreak = (TextView) findViewById(R.id.tvHardMaxStreak);
        tEasyFG = (TextView) findViewById(R.id.tvEasyFirstGuess);
        tEasyLG = (TextView) findViewById(R.id.tvEasyLastGuess);
        tHardFG = (TextView) findViewById(R.id.tvHardFirstGuess);
        tHardLG = (TextView) findViewById(R.id.tvHardLastGuess);

        tWin = (TextView) findViewById(R.id.tvWin);
        tLost = (TextView) findViewById(R.id.tvLost);
        tWinperc = (TextView) findViewById(R.id.tvWinperc);
        tAS = (TextView) findViewById(R.id.tvCurStreak);
        tMS = (TextView) findViewById(R.id.tvMaxStreak);
        tFG = (TextView) findViewById(R.id.tvFirstGuess);
        tLG = (TextView) findViewById(R.id.tvLastGuess);

        tWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScoreBoard.this, "Your total wins",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tLost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScoreBoard.this, "Your total losses",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tWinperc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScoreBoard.this, "Your win percentage",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScoreBoard.this, "Your current ongoing streak",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScoreBoard.this, "Maximum streak you achieved",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tFG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScoreBoard.this, "Number of times guessed in the first attempt",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tLG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScoreBoard.this, "Number of times guessed in the last attempt",
                        Toast.LENGTH_SHORT).show();
            }
        });




        btnRefresh = (Button) findViewById(R.id.btnRefresh);
        btnShare = (Button) findViewById(R.id.btnShare);

        SharedPreferences sharedPreferences
                = getSharedPreferences("BricksData",
                MODE_PRIVATE);

        iEasyWin = sharedPreferences.getInt("EasyWin",0);
        iEasyLose = sharedPreferences.getInt("EasyLose",0);
        iHardwin = sharedPreferences.getInt("HardWin",0);
        iHardlose = sharedPreferences.getInt("HardLose",0);
        iEasyCStreak = sharedPreferences.getInt("EasyCStreak",0);
        iHardCStreak = sharedPreferences.getInt("CurrentStreak",0);
        iEasyHStreak = sharedPreferences.getInt("EasyHStreak",0);
        iHardHStreak = sharedPreferences.getInt("HighestStreak",0);
        iEasyFG = sharedPreferences.getInt("EasyFG",0);
        iEasyLG = sharedPreferences.getInt("EasyLG",0);
        iHardFG = sharedPreferences.getInt("HardFG",0);
        iHardLG = sharedPreferences.getInt("HardLG",0);

        double easyTotal = iEasyWin+iEasyLose;
        if(easyTotal==0)
            dEasyPerc = 0.00;
        else {

            dEasyPerc = (Double.valueOf(iEasyWin) / easyTotal) * 100;
        }

        double hardTotal = iHardwin+iHardlose;
        if(hardTotal==0)
            dHardPerc = 0.00;
        else
            dHardPerc = (Double.valueOf(iHardwin)/hardTotal)*100;


        tEasyWin.setText(""+iEasyWin);
        tEasyLose.setText(""+iEasyLose);
        tHardwin.setText(""+iHardwin);
        tHardlose.setText(""+iHardlose);
        tEasyPerc.setText(""+df.format(dEasyPerc)+"%");
        tHardPerc.setText(""+df.format(dHardPerc)+"%");
        tEasyCStreak.setText(""+iEasyCStreak);
        tHardCStreak.setText(""+iHardCStreak);
        tEasyHStreak.setText(""+iEasyHStreak);
        tHardHStreak.setText(""+iHardHStreak);
        tEasyFG.setText(""+iEasyFG);
        tEasyLG.setText(""+iEasyLG);
        tHardFG.setText(""+iHardFG);
        tHardLG.setText(""+iHardLG);

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ScoreBoard.this);
                builder.setTitle("Reset Your Progress");
                builder.setMessage("Are you sure you want to reset your progress?");

                // add the buttons
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tEasyWin.setText(""+0);
                        tEasyLose.setText(""+0);
                        tHardwin.setText(""+0);
                        tHardlose.setText(""+0);
                        tEasyPerc.setText(""+df.format(0));
                        tHardPerc.setText(""+df.format(0));
                        tEasyCStreak.setText(""+0);
                        tHardCStreak.setText(""+0);
                        tEasyHStreak.setText(""+0);
                        tHardHStreak.setText(""+0);
                        tEasyFG.setText(""+0);
                        tEasyLG.setText(""+0);
                        tHardFG.setText(""+0);
                        tHardLG.setText(""+0);

                        SharedPreferences sharedPreferences
                                = getSharedPreferences("BricksData",
                                MODE_PRIVATE);
                        SharedPreferences.Editor myEdit
                                = sharedPreferences.edit();

                        myEdit.putInt("EasyWin",0);
                        myEdit.putInt("EasyLose",0);
                        myEdit.putInt("HardWin",0);
                        myEdit.putInt("HardLose",0);
                        myEdit.putInt("EasyCStreak",0);
                        myEdit.putInt("CurrentStreak",0);
                        myEdit.putInt("EasyHStreak",0);
                        myEdit.putInt("HighestStreak",0);
                        myEdit.putInt("EasyFG",0);
                        myEdit.putInt("EasyLG",0);
                        myEdit.putInt("HardFG",0);
                        myEdit.putInt("HardLG",0);

                        myEdit.commit();
                    }
                });
                builder.setNegativeButton("Cancel", null);
                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Bricks");
                    String shareMessage= "\nI challenge you to beat my bricks win percentage of "+ df.format(dEasyPerc)+"% in Easy mode and "+df.format(dHardPerc)+"% in Hard mode\n\n Install Bricks now\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });
    }

}