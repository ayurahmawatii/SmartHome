package com.example.smarthome;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class LampControl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp_control);

        final ImageView image = findViewById(R.id.lampu_img);
        final ToggleButton button = findViewById(R.id.saklar_btn);
        final TransitionDrawable drawable = (TransitionDrawable) image.getDrawable();
        button.setChecked(false);
        if(button.isChecked()) {
            drawable.startTransition(750);
        } else {
            image.getDrawable();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.isChecked()) {
                    drawable.startTransition(750);
                }else {
                    drawable.reverseTransition(750);
                }
            }
        });
    }

}
