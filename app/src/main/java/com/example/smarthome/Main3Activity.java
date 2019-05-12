package com.example.smarthome;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main3Activity extends AppCompatActivity {
    DatabaseReference suhuRuangan ;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        t = findViewById(R.id.suhu);
        Typeface myCustomFont=Typeface.createFromAsset(getAssets(),"fonts/Springwood.otf");
        t.setTypeface(myCustomFont);

        suhuRuangan = FirebaseDatabase.getInstance().getReference().child("suhuRuangan");
    }

    @Override
    protected void onStart() {
        super.onStart();
        suhuRuangan.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String suhu = dataSnapshot.getValue(String.class)+"°"+"C";
                t.setText(suhu);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
