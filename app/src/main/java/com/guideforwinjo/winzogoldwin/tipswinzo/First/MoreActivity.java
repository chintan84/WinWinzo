package com.guideforwinjo.winzogoldwin.tipswinzo.First;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.LocalAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.Blue_NativeBannerAds;
import com.guideforwinjo.winzogoldwin.R;

public class MoreActivity extends AppCompatActivity {

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_more);
        getWindow().setFlags(1024, 1024);

        Blue_NativeBannerAds blueNativeBannerAds = new Blue_NativeBannerAds(this);
        blueNativeBannerAds.Load250NativeBanner((RelativeLayout) findViewById(R.id.banner), (RelativeLayout) findViewById(R.id.banner_250));

        LocalAds blueLocalAds = new LocalAds(this);
        blueLocalAds.call_localads_api((RecyclerView) findViewById(R.id.moreappslist));

    }

}
