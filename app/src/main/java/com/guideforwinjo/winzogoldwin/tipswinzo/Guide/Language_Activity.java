package com.guideforwinjo.winzogoldwin.tipswinzo.Guide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.BannerAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.FBPreLoadAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.NativeAds;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadQureka;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.QurekaLoad;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

@SuppressLint("WrongConstant")
public class Language_Activity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.thop_language);

        QurekaLoad.loadQureka(this, (RecyclerView) findViewById(R.id.recyclerView));

        BannerAds.showBannerAds(this, (LinearLayout) findViewById(R.id.banner_ad_container));

        NativeAds blueNativeAds = new NativeAds(this);
        blueNativeAds.loadFBNativeAd((RelativeLayout) findViewById(R.id.native_ADmobAds_Layout));


        if (sharedPreferences.getString("check_qureka_mode", "").equalsIgnoreCase("on")) {
            ImageView imageView = (ImageView) findViewById(R.id.ad0);
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    LoadQureka.Qreka(Language_Activity.this);
                }
            });
        }

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onBackPressed();
            }
        });
        findViewById(R.id.btn_english).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Language_Activity.this, GuideMain_Activity.class).putExtra("Langauage", true);
                new FBPreLoadAds().ShowParaMeterIntertistialAds(Language_Activity.this, intent, sharedPreferences.getString("check_inter_guidepage1", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
        findViewById(R.id.btn_hindi).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Language_Activity.this, GuideMain_Activity.class).putExtra("Langauage", false);
                new FBPreLoadAds().ShowParaMeterIntertistialAds(Language_Activity.this, intent, sharedPreferences.getString("check_inter_guidepage1", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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

    public void onBackPressed() {
        finish();
    }

}
