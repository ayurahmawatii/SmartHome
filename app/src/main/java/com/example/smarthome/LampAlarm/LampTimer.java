package com.example.smarthome.LampAlarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.smarthome.R;

import java.text.DateFormat;
import java.util.Calendar;

public class LampTimer extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    TextView textHeader;
    Button alarmOn,alarmOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp_timer);
        textHeader = findViewById(R.id.text_header);

        alarmOn = findViewById(R.id.btn_alarmOn);
        alarmOff = findViewById(R.id.btn_alarmOff);

        alarmOn.setOnClickListener(this);
        alarmOff.setOnClickListener(this);

        Typeface myCustomFont2=Typeface.createFromAsset(getAssets(),"fonts/Bunbun.ttf");
        textHeader.setTypeface(myCustomFont2);
    }
    @Override
    public void onClick(View v) {
        DialogFragment timePicker;
        switch (v.getId()){
            case R.id.btn_alarmOn:
                Toast.makeText(this, "Anda Bisa Mengatur Waktu Kapan Lampu Dihidupkan", Toast.LENGTH_SHORT).show();
                timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time_picker_on");
                break;
            case R.id.btn_alarmOff:
                Toast.makeText(this, "Anda Bisa Mengatur kapan Lampu Dimatikan", Toast.LENGTH_SHORT).show();
                timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time_picker_off");
        }

    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Fragment tes = (Fragment) getSupportFragmentManager().findFragmentByTag("time_picker_on");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        if(tes != null){
            Log.d("MASUK","ON");
            String kondisi = "1";
            startAlarm(c, kondisi);
            toastWaktu(c, kondisi);
        }else{
            Log.d("MASUK", "OFF");
            String kondisi = "0";
            startAlarm(c, kondisi);
            toastWaktu(c, kondisi);
        }

    }


    private void startAlarm(Calendar c, String kondisi){
        Log.d("STARTALARM AWAL","YA");
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        intent.putExtra("kondisi",kondisi);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
        Log.d("STARTALARM AKHIR","YA");
    }
    
    private void toastWaktu(Calendar c,String kondisi){
        String text = "Lampu ";
        if(kondisi == "1"){
            text += "Akan Dihidupkan Pada: ";
        }else{
            text += "Akan Dimatikan Pada: ";
        }
        text += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


}
