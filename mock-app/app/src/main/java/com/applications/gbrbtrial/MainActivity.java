package com.applications.gbrbtrial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private BottomSheetBehavior mBottomSheet;
    private RadioButton mEasy;
    private RadioButton mHard;
    private MaterialButton mButton;
    private RadioGroup mRadioGroup;
    private TextView mInfoBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEasy = findViewById(R.id.mEasy);
        mHard = findViewById(R.id.mHard);

        mButton = findViewById(R.id.mButton);
        mRadioGroup = findViewById(R.id.mRadioGroup);

        View bottomSheet = findViewById(R.id.mBottomSheetBehaviour);
        mBottomSheet = BottomSheetBehavior.from(bottomSheet);

        mInfoBox = findViewById(R.id.mInfoBox);

        FloatingActionButton mFAB = findViewById(R.id.mFAB);

        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEasy.isChecked())
                    Toast.makeText(MainActivity.this, "Easy", Toast.LENGTH_SHORT).show();
                else if (mHard.isChecked())
                    Toast.makeText(MainActivity.this, "Hard", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Not Selected", Toast.LENGTH_SHORT).show();
            }
        });

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)  {
                    case R.id.mEasy:
                        mInfoBox.setText("In Easy Mode you get 10 tries to guess the word.\nEasy Mode does not count towards streak.");
                        break;
                    case R.id.mHard:
                        mInfoBox.setText("In Hard Mode you get 7 tries to guess the word.\nHard Mode counts towards your streak.\nYou can watch ad's to increase your tries.");
                        break;
                }
            }
        });

    }
}