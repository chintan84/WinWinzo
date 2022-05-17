package com.guideforwinjo.winzogoldwin.tipswinzo.Guide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.BannerAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.NativeAds;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadAtme;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadGamezop;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadQureka;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

@SuppressLint("WrongConstant")
public class GuideMain_Activity extends AppCompatActivity {

    String[][] dataArr;
    CardView costom;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_guide_main);

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

        NativeAds blueNativeAds = new NativeAds(this);
        blueNativeAds.loadFBNativeAd((RelativeLayout) findViewById(R.id.native_ADmobAds_Layout));


        if (getIntent().getBooleanExtra("Langauage", false)) {
            dataArr = new String[][]{new String[]{getResources().getString(R.string.str_1), getResources().getString(R.string.desc_1)}, new String[]{getResources().getString(R.string.str_2), getResources().getString(R.string.desc_2)}, new String[]{getResources().getString(R.string.str_3), getResources().getString(R.string.desc_3)}, new String[]{getResources().getString(R.string.str_4), getResources().getString(R.string.desc_4)}, new String[]{getResources().getString(R.string.str_5), getResources().getString(R.string.desc_5)}, new String[]{getResources().getString(R.string.str_6), getResources().getString(R.string.desc_6)}, new String[]{getResources().getString(R.string.str_7), getResources().getString(R.string.desc_7)}};
        } else {
            dataArr = new String[][]{new String[]{getResources().getString(R.string.str_1_), getResources().getString(R.string.desc_1_)}, new String[]{getResources().getString(R.string.str_2_), getResources().getString(R.string.desc_2_)}, new String[]{getResources().getString(R.string.str_3_), getResources().getString(R.string.desc_3_)}, new String[]{getResources().getString(R.string.str_4_), getResources().getString(R.string.desc_4_)}, new String[]{getResources().getString(R.string.str_5_), getResources().getString(R.string.desc_5_)}, new String[]{getResources().getString(R.string.str_6_), getResources().getString(R.string.desc_6_)}, new String[]{getResources().getString(R.string.str_7_), getResources().getString(R.string.desc_7_)}};
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        TitlAdpter blueTitlAdpter = new TitlAdpter(dataArr, this);
        recyclerView.setAdapter(blueTitlAdpter);

        if (FirstActivity.sharedPreferences.getString("check_qureka_mode", "").equalsIgnoreCase("on")) {
            findViewById(R.id.card).setVisibility(View.VISIBLE);
            findViewById(R.id.card1).setVisibility(View.GONE);
        }


        findViewById(R.id.qurekabtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadQureka.Qreka(GuideMain_Activity.this);
            }
        });

        findViewById(R.id.atmebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadAtme.Atme(GuideMain_Activity.this);
            }
        });

        findViewById(R.id.gamezopbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadGamezop.GameZop(GuideMain_Activity.this);
            }
        });

    }

    public void onBackPressed() {
        finish();
    }
}
