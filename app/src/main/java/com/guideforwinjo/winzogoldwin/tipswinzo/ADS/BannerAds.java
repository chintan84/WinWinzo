package com.guideforwinjo.winzogoldwin.tipswinzo.ADS;

import android.app.Activity;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class BannerAds {

    public static void showBannerAds(Activity activity, LinearLayout linearLayout) {

        String CHECK_MODE = sharedPreferences.getString("check_ad_banner", "");

        if (CHECK_MODE.equalsIgnoreCase("admob")) {
            AdView adView = new AdView(activity);
            adView.setAdSize(AdSize.FULL_BANNER);
            adView.setAdUnitId(sharedPreferences.getString("admob_bannerid", ""));
            linearLayout.removeAllViews();
            linearLayout.addView(adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);

            adView.setAdListener(new com.google.android.gms.ads.AdListener() {
                @Override
                public void onAdLoaded() {
                }

                @Override
                public void onAdFailedToLoad(LoadAdError adError) {
                }

                @Override
                public void onAdOpened() {
                }

                @Override
                public void onAdClicked() {
                }

                @Override
                public void onAdClosed() {
                }
            });
        }
    }
}
