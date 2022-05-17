package com.guideforwinjo.winzogoldwin.tipswinzo.ADS;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.guideforwinjo.winzogoldwin.tipswinzo.First.MyApp;

import java.util.Date;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class AppOpenPre implements LifecycleObserver, Application.ActivityLifecycleCallbacks {
    private static final String LOG_TAG = "AppOpenPre";

    public static boolean isShowingAd = false;

    public AppOpenAd appOpenAd = null;
    Context context;
    private Activity currentActivity;
    private AppOpenAd.AppOpenAdLoadCallback loadCallback;

    public long loadTime = 0;
    private final MyApp blueMyApplication;


    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public AppOpenPre(MyApp mapp, Context context2) {
        this.context = context2;
        this.blueMyApplication = mapp;
        mapp.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    public void fetchAd() {
        if (!isAdAvailable()) {
            this.loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
                }

                public void onAppOpenAdLoaded(AppOpenAd appOpenAd) {
                    AppOpenAd unused = AppOpenPre.this.appOpenAd = appOpenAd;
                    long unused2 = AppOpenPre.this.loadTime = new Date().getTime();
                }
            };
            AppOpenAd.load((Context) this.blueMyApplication, sharedPreferences.getString("admob_appopenid", "no data"), getAdRequest(), 1, this.loadCallback);
        }
    }

    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }

    public boolean isAdAvailable() {
        return this.appOpenAd != null;
    }

    public void onActivityStarted(Activity activity) {
        this.currentActivity = activity;
    }

    public void onActivityResumed(Activity activity) {
        this.currentActivity = activity;
    }

    public void onActivityDestroyed(Activity activity) {
        this.currentActivity = null;
    }

    public void showAdIfAvailable() {
        if (isShowingAd || !isAdAvailable()) {
            Log.d(LOG_TAG, "Can not show ad.");
            fetchAd();
            return;
        }
        Log.d(LOG_TAG, "Will show ad.");
        this.appOpenAd.show(this.currentActivity, new FullScreenContentCallback() {
            public void onAdFailedToShowFullScreenContent(AdError adError) {
            }

            public void onAdDismissedFullScreenContent() {
                AppOpenAd unused = AppOpenPre.this.appOpenAd = null;
                boolean unused2 = AppOpenPre.isShowingAd = false;
                AppOpenPre.this.fetchAd();
            }

            public void onAdShowedFullScreenContent() {
                boolean unused = AppOpenPre.isShowingAd = true;
            }
        });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        showAdIfAvailable();
        Log.d(LOG_TAG, "onStart");
    }
}
