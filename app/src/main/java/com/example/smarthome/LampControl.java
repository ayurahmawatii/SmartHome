package com.example.smarthome;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.TransitionDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LampControl extends AppCompatActivity {
    TextView t;
    DatabaseReference lampuUtama ;
    ToggleButton button;
    ImageView image;
    TransitionDrawable drawable;
    float x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp_control);

        t= (TextView) findViewById(R.id.lamp);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/Springwood.otf");
        t.setTypeface(myCustomFont);

        lampuUtama = FirebaseDatabase.getInstance().getReference().child("lampuUtama");
        button = findViewById(R.id.saklar_btn);
        image = findViewById(R.id.lampu_img);
        drawable = (TransitionDrawable) image.getDrawable();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.isChecked()) {
                    lampuUtama.setValue("1");
                    drawable.startTransition(750);
                }else {
                    lampuUtama.setValue("0");
                    drawable.reverseTransition(750);
                }
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                if(x2<x1) {
                    Intent lampukamar = new Intent(LampControl.this, LampControl2.class);
                    startActivity(lampukamar);
                }
        }
        return false;
    }

}
