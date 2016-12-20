package com.example.bghosh.yhs_yb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {



    ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        mImageView = (ImageView) findViewById(R.id.imageView);
//        mImageView.setImageResource(R.drawable.yes_bank);
        Button startB = (Button) findViewById(R.id.startB);

        // create click listener
        OnClickListener oclBtnOk = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // change text of the TextView (tvOut)
                MainActivity.this.startActivity(new Intent(MainActivity.this, SurveyActivity.class));
            }
        };

        // assign click listener to the OK button (btnOK)
        startB.setOnClickListener(oclBtnOk);

    }






}
