package com.example.smarthome;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smarthome.dashboard.Dashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CheckAccount extends AppCompatActivity {
    TextView t;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    TextView emailText,verifyText;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkaccount);

        t = (TextView) findViewById(R.id.email_user);
        Typeface myCustomFont=Typeface.createFromAsset(getAssets(),"fonts/Rustic.otf");
        t.setTypeface(myCustomFont);

        t = (TextView) findViewById(R.id.verify_user);
        Typeface myCustomFont2=Typeface.createFromAsset(getAssets(),"fonts/Rustic.otf");
        t.setTypeface(myCustomFont2);

        t = (TextView) findViewById(R.id.verify_btn);
        Typeface myCustomFont3=Typeface.createFromAsset(getAssets(),"fonts/Rustic.otf");
        t.setTypeface(myCustomFont);

        t = (TextView) findViewById(R.id.signout);
        Typeface myCustomFont4=Typeface.createFromAsset(getAssets(),"fonts/Rustic.otf");
        t.setTypeface(myCustomFont2);


        Button button = (Button) findViewById(R.id.signout);
        Button verifbtn = findViewById(R.id.verify_btn);
        mAuth = FirebaseAuth.getInstance();
        emailText = findViewById(R.id.email_user);
        verifyText = (TextView) findViewById(R.id.verify_user);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String email = user.getEmail();
            emailText.setText(email);
            Log.d("EMAIL USER",email);


            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();
            if(emailVerified){
                verifbtn.setVisibility(0);
                Intent dashboard = new Intent(CheckAccount.this, Dashboard.class);
                startActivity(dashboard);
            }else{
                Log.d("VERIF?","BELUM");
                verifyText.setText("Please Verify Your Account");
                verifbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(CheckAccount.this, "Verification Email Sent", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }

        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null)
                {
                    startActivity(new Intent(CheckAccount.this, LoginActivity.class));
                }
            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });

    }
}
