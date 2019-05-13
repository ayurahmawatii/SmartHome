package com.example.smarthome;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    TextView t;
    TextView tagline;
    Animation bottom,top;
    ImageView lambang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        lambang = findViewById(R.id.lambang);
        t = (TextView) findViewById(R.id.tagline_app);
        Typeface myCustomFont=Typeface.createFromAsset(getAssets(),"fonts/Highest.ttf");
        t.setTypeface(myCustomFont);

        tagline = findViewById(R.id.tagline_app);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom);
        top = AnimationUtils.loadAnimation(this,R.anim.top);
        tagline.setAnimation(bottom);
        lambang.setAnimation(top);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        }, 2000L); //3000 L = 3 detik
    }
}
