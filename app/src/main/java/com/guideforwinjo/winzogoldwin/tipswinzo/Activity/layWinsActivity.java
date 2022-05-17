package com.guideforwinjo.winzogoldwin.tipswinzo.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.BannerAds;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.QurekaLoad;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class layWinsActivity extends AppCompatActivity {

    CardView costom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_wins);

        costom = findViewById(R.id.costom);
        String costomad = sharedPreferences.getString("costomad", "");
        if (costomad.equalsIgnoreCase("on")) {
            costom.setVisibility(View.VISIBLE);
            costom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sharedPreferences.getString("costompk",""))));
                }
            });
        }

        BannerAds.showBannerAds(this, (LinearLayout) findViewById(R.id.banner_ad_container));
        QurekaLoad.loadQureka(this, (RecyclerView) findViewById(R.id.recyclerView));

    }
}