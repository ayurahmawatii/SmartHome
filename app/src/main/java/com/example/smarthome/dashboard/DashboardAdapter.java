package com.example.smarthome.dashboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smarthome.LampControl;
import com.example.smarthome.Main3Activity;
import com.example.smarthome.R;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {
    Context context;
    ArrayList<DashboardModel> dashboardModelArrayList;

    public DashboardAdapter(ArrayList<DashboardModel> dashboardModelArrayList, Context context) {
        this.dashboardModelArrayList = dashboardModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardAdapter.ViewHolder viewHolder, final int i) {
        String get_header = dashboardModelArrayList.get(i).getHeader();
        viewHolder.setTextHeader(get_header);
        int get_img = dashboardModelArrayList.get(i).getImage();
        viewHolder.setImage(get_img);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i) {
                    case 0 :
                        Intent lampuKamar = new Intent(context, LampControl.class);
                        context.startActivity(lampuKamar);
                        break;
                    case 1 :
                        Intent suhu = new Intent(context, Main3Activity.class);
                        context.startActivity(suhu);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dashboardModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textHeader;
        ImageView images;
        View myView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myView = itemView;
            cardView = itemView.findViewById(R.id.cardview);
        }

        public void setTextHeader(String text) {
            textHeader = myView.findViewById(R.id.header);
            textHeader.setText(text);
        }

        public void setImage (int   i){
            images = myView.findViewById(R.id.dash_img);
            images.setImageResource(i);
        }

    }
}
