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

public class imulatorGamesActivity extends AppCompatActivity {

    CardView costom;
    private int counter = 3;
    private int counter2 = 4;

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
            Picasso.with(imulatorGamesActivity.this).load(Ads.imagegallary.get(counter))
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
                        Picasso.with(imulatorGamesActivity.this).load(Ads.imagegallary.get(counter2))
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

        Gamelist.add(new Games("Indian Truck Simulator 3D", gamezop_url, R.drawable.si1));
        Gamelist.add(new Games("Aircraft Flying Simulator", quezop_url, R.drawable.si3));
        Gamelist.add(new Games("Watercraft_rus", gamezop_url, R.drawable.si5));
        Gamelist.add(new Games("Hill Climber", quezop_url, R.drawable.si6));
        Gamelist.add(new Games("Asro Knot", gamezop_url, R.drawable.si7));
        Gamelist.add(new Games("Drive Boad", quezop_url, R.drawable.si8));
        Gamelist.add(new Games("Train Snake", gamezop_url, R.drawable.si9));
        Gamelist.add(new Games("SantasLastMinutePresents", quezop_url, R.drawable.si10));
        Gamelist.add(new Games("TajisClimb", gamezop_url, R.drawable.si11));
        Gamelist.add(new Games("Cars", quezop_url, R.drawable.si12));
        Gamelist.add(new Games("Finger-drift", gamezop_url, R.drawable.si13));
        Gamelist.add(new Games("Crazy-car", quezop_url, R.drawable.si14));
        Gamelist.add(new Games("Math-game-for-kids", gamezop_url, R.drawable.si15));
        Gamelist.add(new Games("Mini-racer", quezop_url, R.drawable.si16));
        Gamelist.add(new Games("Road-racer", gamezop_url, R.drawable.si17));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        String mygameurl = sharedPreferences.getString("gamezop_url", "");
        GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
        recyclerView.setAdapter(blueGamesAdapter);
    }
}