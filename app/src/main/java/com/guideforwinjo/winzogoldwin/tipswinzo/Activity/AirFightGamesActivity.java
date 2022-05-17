package com.guideforwinjo.winzogoldwin.tipswinzo.Activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.Ads;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.Blue_NativeBannerAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.Model.Games;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.Adapter.GamesAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class AirFightGamesActivity extends AppCompatActivity {

    CardView costom;
    private int counter = 0;
    private int counter2 = 1;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_games);

        ImageView appicon = (ImageView) findViewById(R.id.appicon);
        TextView appname = (TextView) findViewById(R.id.appname);

        try {
            Picasso.with(AirFightGamesActivity.this).load(Ads.imagegallary.get(counter))
                    .into(appicon);
            appname.setText(Ads.name.get(counter));
            appname.setSelected(true);
        } catch (Exception e) {
        }

        costom = findViewById(R.id.costom);
        String costomad = sharedPreferences.getString("costomad", "");
        if (costomad.equalsIgnoreCase("on")) {
            costom.setVisibility(View.VISIBLE);
            costom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Picasso.with(AirFightGamesActivity.this).load(Ads.imagegallary.get(counter2))
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
                }
            });
        }

        Blue_NativeBannerAds bannerAds = new Blue_NativeBannerAds(this);
        bannerAds.Load250NativeBanner((RelativeLayout) findViewById(R.id.banner), (RelativeLayout) findViewById(R.id.banner_250));

        ArrayList<Games> Gamelist = new ArrayList<>();
        String quezop_url = sharedPreferences.getString("quezop_url", "");
        String gamezop_url = sharedPreferences.getString("gamezop_url", "");

        Gamelist.add(new Games("Space Attack", quezop_url, R.drawable.ar1));
        Gamelist.add(new Games("Air-fight", gamezop_url, R.drawable.ar2));
        Gamelist.add(new Games("air_force_2020", quezop_url, R.drawable.ar3));
        Gamelist.add(new Games("Air War", gamezop_url, R.drawable.ar4));
        Gamelist.add(new Games("Air Force Flight", quezop_url, R.drawable.ar6));
        Gamelist.add(new Games("Air Comrat", gamezop_url, R.drawable.ar7));
        Gamelist.add(new Games("Fly or Die", quezop_url, R.drawable.ar8));
        Gamelist.add(new Games("Air  Speck", gamezop_url, R.drawable.ar9));
        Gamelist.add(new Games("Waste invader", quezop_url, R.drawable.ar10));
        Gamelist.add(new Games("Space blaze DX", gamezop_url, R.drawable.ar11));
        Gamelist.add(new Games("Air Batteship force", quezop_url, R.drawable.ar12));
        Gamelist.add(new Games("Air animal Force ff", gamezop_url, R.drawable.ar13));
        Gamelist.add(new Games("Duck shooter", quezop_url, R.drawable.ar14));
        Gamelist.add(new Games("WesternSheriff", gamezop_url, R.drawable.ar15));
        Gamelist.add(new Games("AttackOnHumans", quezop_url, R.drawable.ar16));
        Gamelist.add(new Games(" airplane-battle", gamezop_url, R.drawable.u103));
        Gamelist.add(new Games(" Fighting aircraft battle", quezop_url, R.drawable.u149));
        Gamelist.add(new Games("Alien Galaxy War ", gamezop_url, R.drawable.u150));
        Gamelist.add(new Games(" Defenders Mission", quezop_url, R.drawable.u148));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        String mygameurl = sharedPreferences.getString("gamezop_url", "");

        GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
        recyclerView.setAdapter(blueGamesAdapter);
    }
}