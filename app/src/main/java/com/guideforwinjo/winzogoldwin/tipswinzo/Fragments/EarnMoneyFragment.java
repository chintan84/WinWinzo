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
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.GameZopActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Model.Games;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.QurekaLoad;
import com.guideforwinjo.winzogoldwin.R;
import com.squareup.picasso.Picasso;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class EarnMoneyFragment extends Fragment {

    CardView costom;
    private int counter = 0;
    private int counter2 = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_earn_money, container, false);

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
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sharedPreferences.getString("costompk", ""))));
                }
            });
        }

        BannerAds.showBannerAds(getActivity(), (LinearLayout) view.findViewById(R.id.banner_ad_container));

        NativeAds blueNativeAds = new NativeAds(getActivity());
        blueNativeAds.loadFBNativeAd((RelativeLayout) view.findViewById(R.id.native_ADmobAds_Layout));

        QurekaLoad.loadQurekaPagerAdapter(getActivity(), (CardView) view.findViewById(R.id.qurekacard), (UltraViewPager) view.findViewById(R.id.viewpager));

        RecyclerView arcadeGame = view.findViewById(R.id.arcadeGame);
        RecyclerView arcadeGame1 = view.findViewById(R.id.arcadeGame1);

        ArrayList<Games> Gamelist = new ArrayList<>();
        String quezop_url = sharedPreferences.getString("quezop_url", "");
        String gamezop_url = sharedPreferences.getString("gamezop_url", "");

        Gamelist.add(new Games(" Bottle Shoot", gamezop_url, R.drawable.zo1));
        Gamelist.add(new Games("Ludo With Friends ", quezop_url, R.drawable.t8));
        Gamelist.add(new Games(" Bouncing Beasts", gamezop_url, R.drawable.r23));
        Gamelist.add(new Games("Bubble Wipeout ", quezop_url, R.drawable.t9));
        Gamelist.add(new Games(" Flexi Snake", gamezop_url, R.drawable.r15));
        Gamelist.add(new Games("Pumpkin Smasher ", quezop_url, R.drawable.t66));
        Gamelist.add(new Games("Pirate Hunt ", gamezop_url, R.drawable.a19az));
        Gamelist.add(new Games("Rollout ", quezop_url, R.drawable.v9));

        ArrayList<Games> Gamelist1 = new ArrayList<>();
        Gamelist1.add(new Games("Cubes Got Moves ", quezop_url, R.drawable.p33));
        Gamelist1.add(new Games("Cuby Dash ", gamezop_url, R.drawable.r10));
        Gamelist1.add(new Games(" Cyberfusion", quezop_url, R.drawable.p7));
        Gamelist1.add(new Games("Juicy Dash", gamezop_url, R.drawable.p39));
        Gamelist1.add(new Games(" Jumpy Ape Joe", quezop_url, R.drawable.v35));
        Gamelist1.add(new Games("Jelly Bears ", gamezop_url, R.drawable.t23));
        Gamelist1.add(new Games("Jelly Slice ", quezop_url, R.drawable.p38));
        Gamelist1.add(new Games("Knight Ride ", gamezop_url, R.drawable.v30));

        String mygameurl = sharedPreferences.getString("earn_fragment_url", "");

        ShortAdapter blueShortAdapter = new ShortAdapter(getActivity(), mygameurl, Gamelist);
        arcadeGame.setAdapter(blueShortAdapter);

        ShortAdapter blueShortAdapter1 = new ShortAdapter(getActivity(), mygameurl, Gamelist1);
        arcadeGame1.setAdapter(blueShortAdapter1);

        view.findViewById(R.id.openGamezop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmore();
            }
        });
        view.findViewById(R.id.openGamezop1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmore();
            }
        });

        return view;
    }

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

    public void openmore() {
        Intent intent = new Intent(getActivity(), GameZopActivity.class);
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

}