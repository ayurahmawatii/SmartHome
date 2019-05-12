package com.example.smarthome.dashboard;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.smarthome.MenuSetting;
import com.example.smarthome.R;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    ArrayList<DashboardModel> dashboardModelArrayList;
    RecyclerView recyclerView;
    DashboardAdapter dashboardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.setting:
                Intent setting = new Intent(this, MenuSetting.class);
                startActivity(setting);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
