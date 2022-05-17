package com.guideforwinjo.winzogoldwin.tipswinzo.ADS;

import android.app.Activity;
import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.guideforwinjo.winzogoldwin.R;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.TaptoStartActivity.ADMOBInterstitialAd;

public class FBPreLoadAds {

    public KProgressHUD hud;

    public interface OnIntertistialAdsListner {
        void onAdClicked();

        void onAdsDismissed();

        void onAdsFailedToLoad(int i);

        void onAdsLoaded();

        void onAllEmpty();

        void onLoggingImpression();
    }


    public void ShowIntertistialWithFragmentAds(Activity activity, FragmentManager fragmentManager, Fragment fragment, String CHECK_MODE, final OnIntertistialAdsListner onIntertistialAdsListner) {
        this.hud = KProgressHUD.create(activity).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel("Loading AD").setCancellable(true).setAnimationSpeed(2).setDimAmount(0.5f).show();
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
        try {
            if (CHECK_MODE.equalsIgnoreCase("admob")) {
                if (ADMOBInterstitialAd.isLoaded()) {
                    ADMOBInterstitialAd.setAdListener(new AdListener() {
                        public void onAdLeftApplication() {
                        }

                        public void onAdOpened() {
                        }

                        public void onAdLoaded() {
                            onIntertistialAdsListner.onAdsLoaded();
                        }

                        public void onAdFailedToLoad(int i) {
                            onIntertistialAdsListner.onAdsFailedToLoad(i);
                            if (FBPreLoadAds.this.hud != null) {
                                FBPreLoadAds.this.hud.dismiss();
                            }
                        }

                        public void onAdClicked() {
                            onIntertistialAdsListner.onAdClicked();
                        }

                        public void onAdClosed() {
                            if (FBPreLoadAds.this.hud != null) {
                                FBPreLoadAds.this.hud.dismiss();
                            }
                            onIntertistialAdsListner.onAdsDismissed();
                            ADMOBInterstitialAd.loadAd(new AdRequest.Builder().build());
                        }

                        public void onAdImpression() {
                            super.onAdImpression();
                            onIntertistialAdsListner.onLoggingImpression();
                        }
                    });
                    ADMOBInterstitialAd.show();
                } else {
                    onIntertistialAdsListner.onAllEmpty();
                    KProgressHUD kProgressHUD = this.hud;
                    if (kProgressHUD != null) {
                        kProgressHUD.dismiss();
                    }
                    ADMOBInterstitialAd.loadAd(new AdRequest.Builder().build());
                }
            } else {
                onIntertistialAdsListner.onAllEmpty();
                KProgressHUD kProgressHUD = this.hud;
                if (kProgressHUD != null) {
                    kProgressHUD.dismiss();
                }
            }
        } catch (Exception unused) {
            onIntertistialAdsListner.onAllEmpty();
            KProgressHUD kProgressHUD2 = this.hud;
            if (kProgressHUD2 != null) {
                kProgressHUD2.dismiss();
            }
        }
    }


    public void ShowParaMeterIntertistialAds(final Activity activity, Intent intent, String CHECK_MODE, final OnIntertistialAdsListner onIntertistialAdsListner) {
        this.hud = KProgressHUD.create(activity).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel("Loading AD").setCancellable(true).setAnimationSpeed(2).setDimAmount(0.5f).show();
        activity.startActivity(intent);
        try {
            if (CHECK_MODE.equalsIgnoreCase("admob")) {
                if (ADMOBInterstitialAd.isLoaded()) {
                    ADMOBInterstitialAd.setAdListener(new AdListener() {
                        public void onAdLeftApplication() {
                        }

                        public void onAdOpened() {
                        }

                        public void onAdLoaded() {
                            onIntertistialAdsListner.onAdsLoaded();
                        }

                        public void onAdFailedToLoad(int i) {
                            onIntertistialAdsListner.onAdsFailedToLoad(i);
                            if (FBPreLoadAds.this.hud != null) {
                                FBPreLoadAds.this.hud.dismiss();
                            }
                        }

                        public void onAdClicked() {
                            onIntertistialAdsListner.onAdClicked();
                        }

                        public void onAdClosed() {
                            if (FBPreLoadAds.this.hud != null) {
                                FBPreLoadAds.this.hud.dismiss();
                            }
                            onIntertistialAdsListner.onAdsDismissed();
                            ADMOBInterstitialAd.loadAd(new AdRequest.Builder().build());
                        }

                        public void onAdImpression() {
                            super.onAdImpression();
                            onIntertistialAdsListner.onLoggingImpression();
                        }
                    });
                    ADMOBInterstitialAd.show();
                } else {
                    onIntertistialAdsListner.onAllEmpty();
                    KProgressHUD kProgressHUD = this.hud;
                    if (kProgressHUD != null) {
                        kProgressHUD.dismiss();
                    }
                    ADMOBInterstitialAd.loadAd(new AdRequest.Builder().build());
                }
            } else {
                onIntertistialAdsListner.onAllEmpty();
                KProgressHUD kProgressHUD = this.hud;
                if (kProgressHUD != null) {
                    kProgressHUD.dismiss();
                }
            }
        } catch (Exception unused) {
            onIntertistialAdsListner.onAllEmpty();
            KProgressHUD kProgressHUD2 = this.hud;
            if (kProgressHUD2 != null) {
                kProgressHUD2.dismiss();
            }
        }
    }
}
