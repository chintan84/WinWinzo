package com.guideforwinjo.winzogoldwin.tipswinzo.Guide;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.FBPreLoadAds;
import com.guideforwinjo.winzogoldwin.R;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class TitlAdpter extends RecyclerView.Adapter<TitlAdpter.ViewHolder> {


    String[][] strArr;


    Activity activity;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView custm_title;
        TextView secondary_titile;
        TextView number;
        LinearLayout linear;

        public ViewHolder(TitlAdpter blueTitlAdpter, View view) {
            super(view);
            custm_title = view.findViewById(R.id.custm_title);
            secondary_titile = view.findViewById(R.id.secondary_titile);
            number = view.findViewById(R.id.number);
            this.linear = (LinearLayout) view.findViewById(R.id.linear);

            custm_title.setSelected(true);
        }
    }

    public TitlAdpter(String[][] strArr, Activity activity) {
        this.strArr = strArr;
        this.activity = activity;
    }

    public int getItemCount() {
        return this.strArr.length;
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.number.setText("" + (i + 1));
        viewHolder.custm_title.setText(this.strArr[i][0]);
        viewHolder.secondary_titile.setText(this.strArr[i][1]);
        viewHolder.linear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TitlAdpter.this.activity, Description_Activity.class);
                intent.putExtra("title", TitlAdpter.this.strArr[i][0]);
                intent.putExtra("description", TitlAdpter.this.strArr[i][1]);
                new FBPreLoadAds().ShowParaMeterIntertistialAds(activity, intent, sharedPreferences.getString("check_inter_guidepage2", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
                    public void onAdClicked() {
                    }

                    public void onAdsDismissed() {
                    }

                    public void onAdsFailedToLoad(int i) {
                    }

                    public void onAdsLoaded() {
                    }

                    public void onAllEmpty() {
                    }

                    public void onLoggingImpression() {
                    }
                });
            }
        });
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_title, viewGroup, false));
    }
}
