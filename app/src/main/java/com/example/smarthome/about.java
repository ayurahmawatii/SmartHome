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

    }
}
