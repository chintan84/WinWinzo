package com.guideforwinjo.winzogoldwin.tipswinzo.First;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.BannerAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.FBPreLoadAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.LocalAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.DashBoardActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Guide.Language_Activity;
import com.guideforwinjo.winzogoldwin.tipswinzo.npv.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class TaptoStartActivity extends AppCompatActivity {

    Context context;
    public static InterstitialAd ADMOBInterstitialAd = null;
    Random random = new Random();

    @SuppressLint("MissingPermission")
    public void LoadADMOBIntertistialAds() {
        InterstitialAd interstitialAd = new InterstitialAd(TaptoStartActivity.this);
        ADMOBInterstitialAd = interstitialAd;
        interstitialAd.setAdUnitId(sharedPreferences.getString("admob_interid", ""));
        ADMOBInterstitialAd.loadAd(new AdRequest.Builder().build());
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_tap);
        this.context = this;

        LoadADMOBIntertistialAds();
        String OtherAppStatus = sharedPreferences.getString("OtherAppStatus", "");
        if (OtherAppStatus.equalsIgnoreCase("on")) {
            showRedirectDialog();
        } else {
            BannerAds.showBannerAds(this, (LinearLayout) findViewById(R.id.banner_ad_container));

            LocalAds blueLocalAds = new LocalAds(this);
            blueLocalAds.call_localads_api((RecyclerView) findViewById(R.id.moreappslist));

            findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (sharedPreferences.getString("check_qureka_mode", "").equalsIgnoreCase("on")) {
                        Intent intent = new Intent(TaptoStartActivity.this, DashBoardActivity.class);
                        new FBPreLoadAds().ShowParaMeterIntertistialAds(TaptoStartActivity.this, intent, sharedPreferences.getString("check_inter_home", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
                    } else {
                        Intent intent = new Intent(TaptoStartActivity.this, Language_Activity.class);
                        new FBPreLoadAds().ShowParaMeterIntertistialAds(TaptoStartActivity.this, intent, sharedPreferences.getString("check_inter_home", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
                }
            });

            findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.SUBJECT", R.string.app_name);
                    intent.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=" + getPackageName());
                    startActivity(Intent.createChooser(intent, "Share via"));
                }
            });
            findViewById(R.id.rate).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
                }
            });
            findViewById(R.id.moreapps).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TaptoStartActivity.this.startActivity(new Intent(TaptoStartActivity.this, MoreActivity.class));
                }
            });
            findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener() {
                @SuppressLint("WrongConstant")
                public void onClick(View view) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(sharedPreferences.getString("privacy_url", "")));
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(TaptoStartActivity.this.context, ThankYouActivity.class));
    }

    // TODO: 10/22/2021  New APP Open Dialog
    @SuppressLint("NewApi")
    private void showRedirectDialog() {
        Dialog dialog = new Dialog(this, R.style.FullWidth_Dialog);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.getWindow().setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_update);

        ImageView img = dialog.findViewById(R.id.img);
        ImageView img1 = dialog.findViewById(R.id.img1);

        img.setVisibility(View.GONE);
        img1.setVisibility(View.VISIBLE);

        img1.setImageResource(R.drawable.ic_new_app_install);

        TextView txtUpdate = dialog.findViewById(R.id.txtUpdate);
        TextView cancell = dialog.findViewById(R.id.cancell);
        TextView txtMsg = dialog.findViewById(R.id.txtMsg);
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);

        txtTitle.setText("Install our new app now and enjoy");
        txtMsg.setText("We have transferred our server, so install our new app by clicking the button below to enjoy the new features of app.");
        txtUpdate.setText("Install Now");

        cancell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        txtUpdate.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sharedPreferences.getString("newPackageName", ""))));
            dialog.dismiss();
            finish();
        });
        dialog.show();
    }

}
