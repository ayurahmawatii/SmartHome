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

public class LampControl2 extends AppCompatActivity {
    TextView t;
    DatabaseReference lampuKamar;
    float x1,x2;
    ImageView image;
    ToggleButton button;
    TransitionDrawable drawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp_control2);

        t= (TextView) findViewById(R.id.lamp1);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/Springwood.otf");
        t.setTypeface(myCustomFont);

        lampuKamar = FirebaseDatabase.getInstance().getReference().child("lampuKamar");
        image = findViewById(R.id.lampu_img);
        button = findViewById(R.id.saklar_btn);
        drawable = (TransitionDrawable) image.getDrawable();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.isChecked()) {
                    lampuKamar.setValue("1");
                    drawable.startTransition(750);
                }else {
                    lampuKamar.setValue("0");
                    drawable.reverseTransition(750);
                }
            }
        });
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                if(x2>x1) {
                    Intent lampukamar = new Intent(LampControl2.this, LampControl.class);
                    lampukamar.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    lampukamar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(lampukamar);

                }
        }
        return false;
    }

}
