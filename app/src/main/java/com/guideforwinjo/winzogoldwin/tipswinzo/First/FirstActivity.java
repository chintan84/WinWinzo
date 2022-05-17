package com.guideforwinjo.winzogoldwin.tipswinzo.First;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.AppManage;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.sarnava.textwriter.TextWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import cz.msebera.android.httpclient.Header;

public class FirstActivity extends AppCompatActivity {

    public static final int RequestPermissionCode = 7;
    public static String TAG = "msg";
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    AsyncHttpClient client_snaptube = new AsyncHttpClient();
    int success = 0;

    private Context mContext;
    private Activity activity;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_splash);
        mContext = this;
        activity = this;
        sharedPreferences = getSharedPreferences("memory", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        MobileAds.initialize(this);
        getdata();
        TextWriter textWriter;
        textWriter = findViewById(R.id.textWriter);
        textWriter
                .setWidth(3)
                .setDelay(5)
                .setColor(getResources().getColor(R.color.Blue_300))
                .setConfig(TextWriter.Configuration.INTERMEDIATE)
                .setSizeFactor(10f)
                .setLetterSpacing(10f)
                .setText("ENJOY WATCHING HD VIDEOS")
                .setListener(new TextWriter.Listener() {
                    @Override
                    public void WritingFinished() {
                    }
                })
                .startAnimation();
    }

    private void getdata() {
        RequestParams params = new RequestParams();
        params.put("packagename", getApplicationContext().getPackageName());
        String getdata_url = "https://techbullinfotech.in/ad_service/get_Blue_Swami.php";

        client_snaptube.post(getdata_url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.e("Response_add", response.toString());
                try {
                    JSONObject jsonObject = new JSONObject(String.valueOf(response));

                    success = jsonObject.getInt("success");
                    JSONArray jsonArray = null;
                    if (success == 1) {
                        jsonArray = jsonObject.getJSONArray("data");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject2 = jsonArray.getJSONObject(i);

                            Log.i("ARRAY : ", "" + jsonObject2);

                            String check_localad = jsonObject2.getString("check_localad");
                            String localad_url = jsonObject2.getString("localad_url");

                            String privacy_url = jsonObject2.getString("privacy_url");

                            String check_qureka_mode = jsonObject2.getString("check_qureka_mode");
                            String check_earningmode = jsonObject2.getString("check_earningmode");

                            String quezop_url = jsonObject2.getString("quezop_url");
                            String gamezop_url = jsonObject2.getString("gamezop_url");

                            String earn_fragment_url = jsonObject2.getString("earn_fragment_url");
                            String threed_fragment_url = jsonObject2.getString("threed_fragment_url");

                            String admob_appid = jsonObject2.getString("admob_appid");
                            String admob_interid = jsonObject2.getString("admob_interid");
                            String admob_bannerid = jsonObject2.getString("admob_bannerid");
                            String admob_nativebannerid = jsonObject2.getString("admob_nativebannerid");
                            String admob_appopenid = jsonObject2.getString("admob_appopenid");

                            String check_inter_splash = jsonObject2.getString("check_inter_splash");

                            String check_inter_home = jsonObject2.getString("check_inter_home");
                            String check_inter_guidepage1 = jsonObject2.getString("check_inter_guidepage1");
                            String check_inter_guidepage2 = jsonObject2.getString("check_inter_guidepage2");

                            String check_inter_bottomnav = jsonObject2.getString("check_inter_bottomnav");
                            String check_inter_more = jsonObject2.getString("check_inter_more");

                            String check_ad_banner = jsonObject2.getString("check_ad_banner");
                            String check_ad_nativebanner = jsonObject2.getString("check_ad_nativebanner");
                            String check_ad_native = jsonObject2.getString("check_ad_native");

                            String OtherAppStatus = jsonObject2.getString("OtherAppStatus");
                            String costomad = jsonObject2.getString("costomad");
                            String costompk = jsonObject2.getString("costompk");
                            String newPackageName = jsonObject2.getString("newPackageName");

                            editor.putString("check_localad", check_localad);
                            editor.putString("localad_url", localad_url);

                            editor.putString("privacy_url", privacy_url);

                            editor.putString("check_qureka_mode", check_qureka_mode);
                            editor.putString("check_earningmode", check_earningmode);

                            editor.putString("quezop_url", quezop_url);
                            editor.putString("gamezop_url", gamezop_url);

                            editor.putString("earn_fragment_url", earn_fragment_url);
                            editor.putString("threed_fragment_url", threed_fragment_url);

                            editor.putString("admob_appid", admob_appid);
                            editor.putString("admob_interid", admob_interid);
                            editor.putString("admob_bannerid", admob_bannerid);
                            editor.putString("admob_nativebannerid", admob_nativebannerid);
                            editor.putString("admob_appopenid", admob_appopenid);

                            editor.putString("check_inter_splash", check_inter_splash);

                            editor.putString("check_inter_home", check_inter_home);
                            editor.putString("check_inter_guidepage1", check_inter_guidepage1);
                            editor.putString("check_inter_guidepage2", check_inter_guidepage2);

                            editor.putString("check_inter_bottomnav", check_inter_bottomnav);
                            editor.putString("check_inter_more", check_inter_more);

                            editor.putString("check_ad_banner", check_ad_banner);
                            editor.putString("check_ad_nativebanner", check_ad_nativebanner);
                            editor.putString("check_ad_native", check_ad_native);

                            editor.putString("OtherAppStatus", OtherAppStatus);
                            editor.putString("costomad", costomad);
                            editor.putString("costompk", costompk);
                            editor.putString("newPackageName", newPackageName);

                            editor.commit();
                        }

                        goHome();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                super.onFailure(statusCode, headers, throwable, errorResponse);
                Intent i = new Intent(FirstActivity.this, TaptoStartActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
                finish();
            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });
    }

    private void goHome() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                String check_inter_splash = sharedPreferences.getString("check_inter_splash", "");
                if (check_inter_splash.equalsIgnoreCase("admob")) {
                    Admob_callSplashAd();
                } else if (check_inter_splash.equalsIgnoreCase("appopen")) {
                    fetchAd();
                } else if (check_inter_splash.equalsIgnoreCase("quizop")) {
                    AppManage.getInstance(FirstActivity.this).show_INTERSTIAL(() -> {
                        startActivity(new Intent(FirstActivity.this, TaptoStartActivity.class));
                    });
                } else if (check_inter_splash.equalsIgnoreCase("off")) {
                    Intent i = new Intent(FirstActivity.this, TaptoStartActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(FirstActivity.this, TaptoStartActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                    finish();
                }
            }
        }, 3000);
    }

    private InterstitialAd mInterstitialAd;

    @SuppressLint("MissingPermission")
    private void Admob_callSplashAd() {
        try {
            MobileAds.initialize(FirstActivity.this, sharedPreferences.getString("admob_appid", ""));
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId(sharedPreferences.getString("admob_interid", ""));
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    mInterstitialAd.show();
                }

                @Override
                public void onAdFailedToLoad(LoadAdError adError) {
                    Intent i = new Intent(FirstActivity.this, TaptoStartActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                    finish();
                }

                @Override
                public void onAdOpened() {

                }

                @Override
                public void onAdClicked() {

                }

                @Override
                public void onAdLeftApplication() {

                }


                @Override
                public void onAdClosed() {
                    Intent i = new Intent(FirstActivity.this, TaptoStartActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                    finish();
                }
            });
        } catch (Exception e) {
        }
    }

    public long loadTime = 0;
    public AppOpenAd appOpenAd = null;

    public boolean isAdAvailable() {
        return this.appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4);
    }

    private boolean wasLoadTimeLessThanNHoursAgo(long j) {
        return new Date().getTime() - this.loadTime < j * 3600000;
    }

    FullScreenContentCallback fullScreenContentCallback;
    private AppOpenAd.AppOpenAdLoadCallback loadCallback;

    public void fetchAd() {
        if (!isAdAvailable()) {
            this.fullScreenContentCallback = new FullScreenContentCallback() {
                public void onAdDismissedFullScreenContent() {
                    Intent i = new Intent(FirstActivity.this, TaptoStartActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                    finish();
                }

                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    Log.e("LOG_TAG", adError.getMessage());
                    Intent i = new Intent(FirstActivity.this, TaptoStartActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                    finish();
                }

                public void onAdShowedFullScreenContent() {
                    Log.e("TAG", "onAdDismissedFullScreenContent:====> show ");
                }
            };
            getAdsLoad();
        }
    }

    private void getAdsLoad() {
        this.loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
            public void onAdLoaded(AppOpenAd appOpenAd) {
                super.onAdLoaded(appOpenAd);
                appOpenAd.show(FirstActivity.this);
                appOpenAd.setFullScreenContentCallback(FirstActivity.this.fullScreenContentCallback);
                AppOpenAd unused = FirstActivity.this.appOpenAd = appOpenAd;
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Intent i = new Intent(FirstActivity.this, TaptoStartActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
                finish();
                Log.e("TAG", "onAdFailedToLoad: ===>" + loadAdError.getMessage());
            }
        };
        AppOpenAd.load((Context) this, sharedPreferences.getString("admob_appopenid", ""), getAdRequest(), 1, this.loadCallback);
    }

    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }

}