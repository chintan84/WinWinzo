package com.guideforwinjo.winzogoldwin.tipswinzo.ADS;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.guideforwinjo.winzogoldwin.R;

import java.util.ArrayList;

public class LocalAdsAdapter extends RecyclerView.Adapter<LocalAdsAdapter.ViewHolder> {
    Context context;
    ArrayList<AppDetail> localAdsArrayList;

    public LocalAdsAdapter(Context context, ArrayList<AppDetail> localAdsArrayList) {
        this.context = context;
        this.localAdsArrayList = localAdsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.localads_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(localAdsArrayList.get(position).getApp_name());
        Glide.with(context).load(localAdsArrayList.get(position).getApp_icon()).into(holder.imgIcon);

        holder.gostore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAppStore(localAdsArrayList.get(position).getApp_url());
            }
        });

    }

    private void gotoAppStore(final String packagename) {
        context.startActivity(new Intent(
                Intent.ACTION_VIEW,
                Uri.parse(packagename)));
    }

    @Override
    public int getItemCount() {
        return localAdsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CardView gostore;
        public ImageView imgIcon;

        public TextView name;


        public ViewHolder(@NonNull View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.name);
            this.imgIcon = (ImageView) view.findViewById(R.id.imgIcon);


            this.name.setSelected(true);
            this.gostore = view.findViewById(R.id.gostore);
        }
    }
}
