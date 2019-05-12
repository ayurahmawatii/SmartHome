package com.example.smarthome.dashboard;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.smarthome.LoginActivity;
import com.example.smarthome.R;
import com.example.smarthome.Register;
import com.example.smarthome.mode;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    ArrayList<DashboardModel> dashboardModelArrayList;
    RecyclerView recyclerView;
    DashboardAdapter dashboardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView setting = (TextView) findViewById(R.id.login_page);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, mode.class);
                startActivity(intent);

        dashboardModelArrayList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        initializeData();
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        dashboardAdapter = new DashboardAdapter(dashboardModelArrayList,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(dashboardAdapter);
    }

    private void initializeData() {
        String[] listHeader = getResources().getStringArray(R.array.item_cardview);
        TypedArray images = getResources().obtainTypedArray(R.array.item_cardview_img);
        for (int i=0; i < listHeader.length; i++ ){
            DashboardModel dashboardModel= new DashboardModel();
            dashboardModel.setHeader(listHeader[i]);
            dashboardModel.setImage(images.getResourceId(i,0));
            dashboardModelArrayList.add(dashboardModel);
        }
        images.recycle();
    }
}
