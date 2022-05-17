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
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.Ads;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.BannerAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.FBPreLoadAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.NativeAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.Adapter.ShortAdapter;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.AdventureGamesActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.AtmeGamesActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.acingGamesActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Model.Games;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.AtmeLoad;
import com.guideforwinjo.winzogoldwin.R;
import com.squareup.picasso.Picasso;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class ThreeDFragment extends Fragment {

    CardView costom;
    private int counter = 4;
    private int counter2 = 5;

    CardView costom2;

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

        View view = inflater.inflate(R.layout.fragment_three_d, container, false);

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
        costom2 = view.findViewById(R.id.costom2);
        String costomad = sharedPreferences.getString("costomad", "");
        if (costomad.equalsIgnoreCase("on")) {
            costom.setVisibility(View.VISIBLE);
            costom2.setVisibility(View.VISIBLE);
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
                    /*startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sharedPreferences.getString("costompk", ""))));*/
                }
            });
            costom2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sharedPreferences.getString("costompk", ""))));
                }
            });
        }

        BannerAds.showBannerAds(getActivity(), (LinearLayout) view.findViewById(R.id.banner_ad_container));

        NativeAds blueNativeAds = new NativeAds(getActivity());
        blueNativeAds.loadFBNativeAd((RelativeLayout) view.findViewById(R.id.native_ADmobAds_Layout));

        RecyclerView arcadeGame = view.findViewById(R.id.arcadeGame);
        RecyclerView arcadeGame1 = view.findViewById(R.id.arcadeGame1);
        RecyclerView arcadeGame2 = view.findViewById(R.id.arcadeGame2);

        AtmeLoad.loadAtmePagerAdapter(getActivity(), (CardView) view.findViewById(R.id.qurekacard), (UltraViewPager) view.findViewById(R.id.viewpager));

        ArrayList<Games> Gamelist = new ArrayList<>();

        String quezop_url = sharedPreferences.getString("quezop_url", "");
        String gamezop_url = sharedPreferences.getString("gamezop_url", "");

        Gamelist.add(new Games("Air Hockeyir ", quezop_url, R.drawable.a1a));
        Gamelist.add(new Games("Assassin Knight ", quezop_url, R.drawable.a6a));
        Gamelist.add(new Games("Mad Shark ", gamezop_url, R.drawable.a53a));
        Gamelist.add(new Games("Cyber Slashman ", quezop_url, R.drawable.a21a));
        Gamelist.add(new Games("Cyber Soldier ", gamezop_url, R.drawable.a22a));
        Gamelist.add(new Games("Defence Champion ", quezop_url, R.drawable.a26a));
        Gamelist.add(new Games("Shoot Robbers ", gamezop_url, R.drawable.a70a));
        Gamelist.add(new Games("Fire Soldier ", gamezop_url, R.drawable.a30a));
        Gamelist.add(new Games(" Great-Air Battles", gamezop_url, R.drawable.a42a));
        Gamelist.add(new Games("Tank Defender ", quezop_url, R.drawable.a82a));
        Gamelist.add(new Games("Tank Wars ", gamezop_url, R.drawable.a83a));
        Gamelist.add(new Games("Air Warfare ", gamezop_url, R.drawable.a2a));

        ArrayList<Games> Gamelist1 = new ArrayList<>();

        Gamelist1.add(new Games(" Gold-Miner Jack", quezop_url, R.drawable.a41a));
        Gamelist1.add(new Games("Fruitslasher", gamezop_url, R.drawable.a36a));
        Gamelist1.add(new Games("Fruit Snake ", quezop_url, R.drawable.a35a));
        Gamelist1.add(new Games("Dead-Land-Adventure 2 ", gamezop_url, R.drawable.a25a));
        Gamelist1.add(new Games("Defence Champion ", quezop_url, R.drawable.a26a));
        Gamelist1.add(new Games("Joee Adventure ", gamezop_url, R.drawable.a47a));
        Gamelist1.add(new Games("Jump Jump ", quezop_url, R.drawable.a48a));
        Gamelist1.add(new Games("Playful Kitty ", gamezop_url, R.drawable.a60a));
        Gamelist1.add(new Games(" Plumber", quezop_url, R.drawable.a61a));
        Gamelist1.add(new Games("Piggybank Adventure ", gamezop_url, R.drawable.a59a));
        Gamelist1.add(new Games("Flappy Pig", quezop_url, R.drawable.a32a));
        Gamelist1.add(new Games("Ninja Run ", gamezop_url, R.drawable.a57a));

        ArrayList<Games> Gamelist2 = new ArrayList<>();

        Gamelist2.add(new Games(" Crazy Runner", quezop_url, R.drawable.a17a));
        Gamelist2.add(new Games("Cube Ninja ", gamezop_url, R.drawable.a20a));
        Gamelist2.add(new Games("Road Racer ", quezop_url, R.drawable.a66a));
        Gamelist2.add(new Games(" Santa Run", gamezop_url, R.drawable.a68a));
        Gamelist2.add(new Games("Scary Run ", quezop_url, R.drawable.a69a));
        Gamelist2.add(new Games("Speed Racer ", gamezop_url, R.drawable.a72a));
        Gamelist2.add(new Games(" Speedy Driving", quezop_url, R.drawable.a73a));
        Gamelist2.add(new Games("Traffic ", gamezop_url, R.drawable.a85a));

        String mygameurl = sharedPreferences.getString("threed_fragment_url", "");

        ShortAdapter blueShortAdapter = new ShortAdapter(getActivity(), mygameurl, Gamelist);
        arcadeGame.setAdapter(blueShortAdapter);

        ShortAdapter blueShortAdapter1 = new ShortAdapter(getActivity(), mygameurl, Gamelist1);
        arcadeGame1.setAdapter(blueShortAdapter1);

        ShortAdapter blueShortAdapter2 = new ShortAdapter(getActivity(), mygameurl, Gamelist2);
        arcadeGame2.setAdapter(blueShortAdapter2);

        view.findViewById(R.id.openAtme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AtmeGamesActivity.class);
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
        view.findViewById(R.id.openRacing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), acingGamesActivity.class);
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