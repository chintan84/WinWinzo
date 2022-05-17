package com.guideforwinjo.winzogoldwin.tipswinzo.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.Ads;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.BannerAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.FBPreLoadAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.NativeAds;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.AdventureGamesActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.AirFightGamesActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.GirlsDressActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.imulatorGamesActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.portsGamesActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.ombieGamesActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadAtme;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadGamezop;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadQureka;
import com.squareup.picasso.Picasso;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class PopularFragment extends Fragment {

    CardView costom;
    private int counter = 5;
    private int counter2 = 6;

    private void gotoAppStore(final String packagename) {
        try {
            startActivity(new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(packagename)));
        } catch (ActivityNotFoundException anfe) {
            startActivity(new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(packagename)));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_popular, container, false);

        ImageView appicon = (ImageView) view.findViewById(R.id.appicon);
        TextView appname = (TextView) view.findViewById(R.id.appname);

        try {
            Picasso.with(getActivity()).load(Ads.imagegallary.get(counter))
                    .into(appicon);
            appname.setText(Ads.name.get(counter));
            appname.setSelected(true);
        } catch (Exception e) {
        }

        costom = view.findViewById(R.id.costom);
        String costomad = sharedPreferences.getString("costomad", "");
        if (costomad.equalsIgnoreCase("on")) {
            costom.setVisibility(View.VISIBLE);
            costom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Picasso.with(getActivity()).load(Ads.imagegallary.get(counter2))
                                .into(appicon);
                        appname.setText(Ads.name.get(counter2));
                        appname.setSelected(true);
                    } catch (Exception e) {
                    }
                    gotoAppStore(Ads.link.get(counter));
                    counter++;
                    counter2++;
                    if (counter == Ads.imagegallary.size()) {
                        counter = 0;
                    }
                    if (counter2 == Ads.imagegallary.size()) {
                        counter2 = 0;
                    }
                    /*startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sharedPreferences.getString("costompk",""))));*/
                }
            });
        }

        BannerAds.showBannerAds(getActivity(), (LinearLayout) view.findViewById(R.id.banner_ad_container));

        NativeAds blueNativeAds = new NativeAds(getActivity());
        blueNativeAds.loadFBNativeAd((RelativeLayout) view.findViewById(R.id.native_ADmobAds_Layout));

        view.findViewById(R.id.qurekabtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadQureka.Qreka(getActivity());
            }
        });

        view.findViewById(R.id.atmebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadAtme.Atme(getActivity());
            }
        });

        view.findViewById(R.id.gamezopbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadGamezop.GameZop(getActivity());
            }
        });

        view.findViewById(R.id.openAdventure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AdventureGamesActivity.class);
                new FBPreLoadAds().ShowParaMeterIntertistialAds(getActivity(), intent, sharedPreferences.getString("check_inter_more", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
        });

        view.findViewById(R.id.openSport).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), portsGamesActivity.class);
                new FBPreLoadAds().ShowParaMeterIntertistialAds(getActivity(), intent, sharedPreferences.getString("check_inter_more", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
        });

        view.findViewById(R.id.openSimpulator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), imulatorGamesActivity.class);
                new FBPreLoadAds().ShowParaMeterIntertistialAds(getActivity(), intent, sharedPreferences.getString("check_inter_more", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
        });

        view.findViewById(R.id.openAirfight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AirFightGamesActivity.class);
                new FBPreLoadAds().ShowParaMeterIntertistialAds(getActivity(), intent, sharedPreferences.getString("check_inter_more", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
        });

        view.findViewById(R.id.openGirlDressup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GirlsDressActivity.class);
                new FBPreLoadAds().ShowParaMeterIntertistialAds(getActivity(), intent, sharedPreferences.getString("check_inter_more", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
        });

        view.findViewById(R.id.openZombie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ombieGamesActivity.class);
                new FBPreLoadAds().ShowParaMeterIntertistialAds(getActivity(), intent, sharedPreferences.getString("check_inter_more", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
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
        });

        return view;
    }
}