package com.example.smarthome;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class about extends AppCompatActivity {
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        t = (TextView) findViewById(R.id.about);
        Typeface myCustomFont=Typeface.createFromAsset(getAssets(),"fonts/Rustic.otf");
        t.setTypeface(myCustomFont);

        t = (TextView) findViewById(R.id.about1);
        Typeface myCustomFont1=Typeface.createFromAsset(getAssets(),"fonts/Rustic.otf");
        t.setTypeface(myCustomFont1);

        t = (TextView) findViewById(R.id.about2);
        Typeface myCustomFont2=Typeface.createFromAsset(getAssets(),"fonts/Rustic.otf");
        t.setTypeface(myCustomFont2);

        t = (TextView) findViewById(R.id.about3);
        Typeface myCustomFont3=Typeface.createFromAsset(getAssets(),"fonts/Rustic.otf");
        t.setTypeface(myCustomFont3);
    }
}
