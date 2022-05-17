
package com.guideforwinjo.winzogoldwin.tipswinzo.ADS;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.guideforwinjo.winzogoldwin.R;

import java.util.ArrayList;

public class Ads extends RecyclerView.Adapter<Ads.FinalVideoHolder> {
    Context context;
    int count = 0;
    public static ArrayList<String> imagegallary = new ArrayList<>();
    public static ArrayList<String> link = new ArrayList<>();
    public static ArrayList<String> name = new ArrayList<>();

    public int getItemViewType(int i) {
        return i;
    }

    public Ads(Context context2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, boolean z) {
        this.context = context2;
        this.imagegallary = arrayList;
        this.link = arrayList3;
        this.name = arrayList2;
        setHasStableIds(true);
    }

    public FinalVideoHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FinalVideoHolder(LayoutInflater.from(this.context).inflate(R.layout.skip_appdata_list_row, viewGroup, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onBindViewHolder(FinalVideoHolder finalVideoHolder, int i) {
        if (i / this.imagegallary.size() >= 1) {
            i -= this.imagegallary.size() * (i / this.imagegallary.size());
        }
        int finalI = i;
        finalVideoHolder.f112ab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Ads.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Ads.this.link.get(finalI))));
            }
        });

        finalVideoHolder.name.setText(this.name.get(i).toString());
        Glide.with(this.context).load(this.imagegallary.get(i)).into(finalVideoHolder.imgIcon);
    }

    public int getItemCount() {
        return this.imagegallary.size();
    }

    public class FinalVideoHolder extends RecyclerView.ViewHolder {

        public LinearLayout f112ab;
        public ImageView imgIcon;
        public TextView name;


        public FinalVideoHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.name);
            this.imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
            this.name.setSelected(true);
            this.f112ab = (LinearLayout) view.findViewById(R.id.onclick);
        }
    }
}
