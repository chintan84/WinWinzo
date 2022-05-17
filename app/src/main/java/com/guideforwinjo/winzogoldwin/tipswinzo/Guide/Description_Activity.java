package com.guideforwinjo.winzogoldwin.tipswinzo.Guide;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.BannerAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.NativeAds;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadQureka;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

@SuppressLint("WrongConstant")

public class Description_Activity extends AppCompatActivity {

    AppCompatTextView f186a;
    AppCompatTextView f187b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.thop_description);

        NativeAds blueNativeAds = new NativeAds(this);
        blueNativeAds.loadFBNativeAd((RelativeLayout) findViewById(R.id.native_ADmobAds_Layout));

        BannerAds.showBannerAds(this, (LinearLayout) findViewById(R.id.banner_ad_container));


        if (sharedPreferences.getString("check_qureka_mode", "").equalsIgnoreCase("on")) {
            ImageView imageView = (ImageView) findViewById(R.id.ad0);
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    LoadQureka.Qreka(Description_Activity.this);
                }
            });
        }
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Description_Activity.this.onBackPressed();
            }
        });
        this.f186a = (AppCompatTextView) findViewById(R.id.title_desc);
        this.f187b = (AppCompatTextView) findViewById(R.id.desc_tv);
        AppCompatTextView appCompatTextView = this.f186a;
        appCompatTextView.setText("" + getIntent().getStringExtra("title"));
        AppCompatTextView appCompatTextView2 = this.f187b;
        appCompatTextView2.setText("" + getIntent().getStringExtra("description"));
    }


    public void onBackPressed() {
        super.onBackPressed();
    }
}
