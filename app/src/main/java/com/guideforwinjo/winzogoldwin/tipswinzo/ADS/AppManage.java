package com.guideforwinjo.winzogoldwin.tipswinzo.ADS;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import com.guideforwinjo.winzogoldwin.R;

import java.util.Random;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;


public class AppManage {

    public static CustomTabsIntent.Builder customIntent;

    public static int qurekaInterstitialSelected = 0;
    public static int[] qurekaInterstitialImage = new int[]{R.drawable.qureka_interstitial1, R.drawable.qureka_interstitial2, R.drawable.qureka_interstitial3, R.drawable.qureka_interstitial4, R.drawable.qureka_interstitial5};
    public static SharedPreferences mysharedpreferences;
    static Activity activity;
    static MyCallback myCallback;
    private static AppManage mInstance;

    public AppManage(Activity activity) {
        mysharedpreferences = activity.getSharedPreferences(activity.getPackageName(), Context.MODE_PRIVATE);
    }

    public static AppManage getInstance(Activity activity) {
        AppManage.activity = activity;
        if (mInstance == null) {
            mInstance = new AppManage(activity);
        }
        qurekaInterstitialSelected = new Random().nextInt(5);
        Log.e("AppManage", "qurekaInterstitialSelected : " + qurekaInterstitialSelected);
        return mInstance;
    }

    public static void openCustomTab(Activity activity) {
        customIntent = new CustomTabsIntent.Builder();
        customIntent.setToolbarColor(ContextCompat.getColor(activity, R.color.colorPrimary));
        String packageName = "com.android.chrome";
        customIntent.build().intent.setPackage(packageName);
        String qurekaUrl = sharedPreferences.getString("quezop_url", "");
        if (!qurekaUrl.equals("")) {
            try {
                customIntent.build().launchUrl(activity, Uri.parse(sharedPreferences.getString("quezop_url", "")));
            } catch (Exception e) {
                e.printStackTrace();
                activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(qurekaUrl)));
            }
        }
    }

    public interface MyCallback {
        void callbackCall();
    }

    public static void show_INTERSTIAL(MyCallback myCallback) {
        showQurekaInterstitial(myCallback);
    }

    private static void showQurekaInterstitial(MyCallback myCallback2) {
        myCallback = myCallback2;
        Dialog dialog = new Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar);
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_qureka_inter, null);
        dialog.setContentView(view);
        dialog.setCancelable(true);
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));

        ImageView imageQurekaInterstitial = (ImageView) dialog.findViewById(R.id.imageQurekaInterstitial);
        ImageView textView = (ImageView) dialog.findViewById(R.id.txt_exit);
        textView.setEnabled(false);
        final ImageView textView2 = textView;
        new CountDownTimer(5000, 1000) {
            public void onTick(long j) {
                ImageView textView = textView2;
                textView.setImageResource(R.drawable.close);
            }

            public void onFinish() {
                textView2.setImageResource(R.drawable.close);
                textView2.setEnabled(true);
            }
        }.start();

        imageQurekaInterstitial.setImageResource(qurekaInterstitialImage[qurekaInterstitialSelected]);

        imageQurekaInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomTab(activity);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (myCallback != null) {
                    myCallback.callbackCall();
                    myCallback = null;
                }
            }
        });
        dialog.show();
    }

}
