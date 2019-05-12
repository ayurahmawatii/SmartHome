package com.example.smarthome;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView t = findViewById(R.id.suhu);
        Typeface myCustomFont=Typeface.createFromAsset(getAssets(),"fonts/fofbb_ital.ttf");
        t.setTypeface(myCustomFont);
    }
}
