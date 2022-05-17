package com.guideforwinjo.winzogoldwin.tipswinzo.Activity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadQureka;

import java.util.ArrayList;
import java.util.Random;

public class layWinAdapter extends RecyclerView.Adapter<layWinAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Integer> imageList;
    ArrayList<String> titleList;

    public layWinAdapter(Activity activity, ArrayList<Integer> imageList, ArrayList<String> titleList) {
        this.activity = activity;
        this.imageList = imageList;
        this.titleList = titleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.playwin_items_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(imageList.get(position));
        holder.ttitle.setText(titleList.get(position));

        int randnum = new Random().nextInt(10000);

        holder.usercnt.setText(""+randnum+" "+"User Playing");

        holder.playnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadQureka.Qreka(activity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView ttitle;
        TextView usercnt;
        RelativeLayout playnow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            ttitle = itemView.findViewById(R.id.ttitle);
            playnow = itemView.findViewById(R.id.playnow);
            usercnt = itemView.findViewById(R.id.usercnt);
        }
    }
}
