package com.guideforwinjo.winzogoldwin.tipswinzo.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.FBPreLoadAds;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.llGamesActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.layWinsActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Model.Category;
import com.guideforwinjo.winzogoldwin.tipswinzo.Guide.Language_Activity;

import java.util.ArrayList;
import java.util.Random;

public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.MyViewHolder> {
    private Activity activity;
    ArrayList<Category> arrayList;

    public DashBoardAdapter(Activity activity, ArrayList<Category> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(activity).inflate(R.layout.dashboard_items, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {

        myViewHolder.profileicon.setImageResource(arrayList.get(i).getImageicon());

        myViewHolder.ttitle.setText(arrayList.get(i).getTitle());
        myViewHolder.relative.setBackgroundResource(arrayList.get(i).getBackImage());
        myViewHolder.tvlive.setBackgroundResource(arrayList.get(i).getBackImage());
        myViewHolder.linear.setBackgroundResource(arrayList.get(i).getBackImage());

        int randnum = new Random().nextInt(100000);

        myViewHolder.usercnt.setText("" + randnum);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (i == 0) {
                    Intent intent = new Intent(activity, layWinsActivity.class);
                    new FBPreLoadAds().ShowParaMeterIntertistialAds(activity, intent, FirstActivity.sharedPreferences.getString("check_inter_home", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
                } else if (i == 3) {
                    Intent intent = new Intent(activity, Language_Activity.class);
                    new FBPreLoadAds().ShowParaMeterIntertistialAds(activity, intent, FirstActivity.sharedPreferences.getString("check_inter_home", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
                } else {
                    Intent intent = new Intent(activity, llGamesActivity.class);
                    intent.putExtra("pos", i);
                    new FBPreLoadAds().ShowParaMeterIntertistialAds(activity, intent, FirstActivity.sharedPreferences.getString("check_inter_home", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView profileicon;
        TextView ttitle;
        TextView tvlive;
        TextView usercnt;
        RelativeLayout relative;
        LinearLayout linear;

        public MyViewHolder(View view) {
            super(view);
            this.ttitle = (TextView) view.findViewById(R.id.ttitle);
            this.tvlive = (TextView) view.findViewById(R.id.tvlive);
            this.profileicon = (ImageView) view.findViewById(R.id.profileicon);
            this.relative = view.findViewById(R.id.relative);
            this.linear = view.findViewById(R.id.linear);
            this.usercnt = view.findViewById(R.id.usercnt);
        }
    }
}
