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

import com.guideforwinjo.winzogoldwin.tipswinzo.GameData;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.Ads;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.Blue_NativeBannerAds;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.Adapter.GamesAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class llGamesActivity extends AppCompatActivity {

    ArrayList Gamelist;
    String mygameurl;
    CardView costom;
    private int counter = 1;
    private int counter2 = 2;

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
            Picasso.with(llGamesActivity.this).load(Ads.imagegallary.get(counter))
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
                        Picasso.with(llGamesActivity.this).load(Ads.imagegallary.get(counter2))
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

        int pos = getIntent().getIntExtra("pos", 1);

        Blue_NativeBannerAds bannerAds = new Blue_NativeBannerAds(this);
        bannerAds.Load250NativeBanner((RelativeLayout) findViewById(R.id.banner), (RelativeLayout) findViewById(R.id.banner_250));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        if (pos == 1) {
            Gamelist = GameData.AtmeGames();
            mygameurl = sharedPreferences.getString("quezop_url", "");
        } else if (pos == 2) {
            mygameurl = sharedPreferences.getString("gamezop_url", "");
            Gamelist = GameData.GamezopGames();
        } else if (pos == 4) {
            mygameurl = sharedPreferences.getString("quezop_url", "");
            Gamelist = GameData.AllGames();
        } else if (pos == 5) {
            mygameurl = sharedPreferences.getString("gamezop_url", "");
            Gamelist = GameData.ActionGames();
        } else if (pos == 6) {
            mygameurl = sharedPreferences.getString("quezop_url", "");
            Gamelist = GameData.PopularGames();
        } else if (pos == 7) {
            mygameurl = sharedPreferences.getString("gamezop_url", "");
            Gamelist = GameData.MultiplayerGames();
        } else if (pos == 8) {
            mygameurl = sharedPreferences.getString("quezop_url", "");
            Gamelist = GameData.PuzzleGames();
        } else if (pos == 9) {
            mygameurl = sharedPreferences.getString("gamezop_url", "");
            Gamelist = GameData.AdventureGames();
        } else if (pos == 10) {
            mygameurl = sharedPreferences.getString("quezop_url", "");
            Gamelist = GameData.SimulatorGames();
        } else if (pos == 11) {
            mygameurl = sharedPreferences.getString("gamezop_url", "");
            Gamelist = GameData.AirFightGames();
        } else if (pos == 12) {
            mygameurl = sharedPreferences.getString("quezop_url", "");
            Gamelist = GameData.ThreeDGames();
        } else if (pos == 13) {
            mygameurl = sharedPreferences.getString("gamezop_url", "");
            Gamelist = GameData.GirslDressGames();
        } else if (pos == 14) {
            mygameurl = sharedPreferences.getString("quezop_url", "");
            Gamelist = GameData.ZombieGames();
        } else if (pos == 15) {
            mygameurl = sharedPreferences.getString("gamezop_url", "");
            Gamelist = GameData.RacingGames();
        } else if (pos == 16) {
            mygameurl = sharedPreferences.getString("quezop_url", "");
            Gamelist = GameData.SportsGames();
        } else if (pos == 17) {
            mygameurl = sharedPreferences.getString("gamezop_url", "");
            Gamelist = GameData.AnimalsGames();
        }

        if (Gamelist != null && Gamelist.size() > 0) {
            try {
                GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
                recyclerView.setAdapter(blueGamesAdapter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}