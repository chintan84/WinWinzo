package com.guideforwinjo.winzogoldwin.tipswinzo.Tab;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;

import androidx.browser.customtabs.CustomTabsIntent;

import com.guideforwinjo.winzogoldwin.R;


public class LoadCustom {
    public static void myCustom(Activity activity, String mygameurl) {
        if (mygameurl.isEmpty()) {
            mygameurl = "";
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            Bundle bundle = new Bundle();
            int i = Build.VERSION.SDK_INT;
            bundle.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
            intent.putExtras(bundle);
            intent.putExtra(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, C1948u6.m10706a(activity, R.color.purple_500));
            intent.putExtra(CustomTabsIntent.EXTRA_ENABLE_INSTANT_APPS, true);
            C1598o5 c1598o5 = new C1598o5(intent, (Bundle) null);
            c1598o5.f9008a.setPackage("com.android.chrome");
            c1598o5.f9008a.setData(Uri.parse(mygameurl));
            C1948u6.m10707a(activity, c1598o5.f9008a, c1598o5.f9009b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}