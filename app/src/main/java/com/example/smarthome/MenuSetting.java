package com.example.smarthome;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuSetting extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextView usernameText;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_setting);
        usernameText = findViewById(R.id.username);
        Button button = findViewById(R.id.signout_btn);

        final FirebaseUser user = mAuth.getInstance().getCurrentUser();
        if(user != null){
            String email = user.getEmail();
            usernameText.setText(email);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.getInstance().signOut();
            }
        });
    }


}
