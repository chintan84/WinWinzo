package com.guideforwinjo.winzogoldwin.tipswinzo.First;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.AppOpenPre;


public class MyApp extends Application {
    private static AppOpenPre appOpenManager;

    public void onCreate() {
        super.onCreate();
        appOpenManager = new AppOpenPre(this, this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
