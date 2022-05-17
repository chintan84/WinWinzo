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

public class AdventureGamesActivity extends AppCompatActivity {

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
            Picasso.with(AdventureGamesActivity.this).load(Ads.imagegallary.get(counter))
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
                        Picasso.with(AdventureGamesActivity.this).load(Ads.imagegallary.get(counter2))
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

        Gamelist.add(new Games(" Gold-Miner Jack", quezop_url, R.drawable.a41a));
        Gamelist.add(new Games("Fruitslasher", gamezop_url, R.drawable.a36a));
        Gamelist.add(new Games("Fruit Snake ", quezop_url, R.drawable.a35a));
        Gamelist.add(new Games("Dead-Land-Adventure 2 ", gamezop_url, R.drawable.a25a));
        Gamelist.add(new Games("Defence Champion ", quezop_url, R.drawable.a26a));
        Gamelist.add(new Games("Joee Adventure ", gamezop_url, R.drawable.a47a));
        Gamelist.add(new Games("Jump Jump ", quezop_url, R.drawable.a48a));
        Gamelist.add(new Games("Playful Kitty ", gamezop_url, R.drawable.a60a));
        Gamelist.add(new Games(" Plumber", quezop_url, R.drawable.a61a));
        Gamelist.add(new Games("Piggybank Adventure ", gamezop_url, R.drawable.a59a));
        Gamelist.add(new Games("Flappy Pig", quezop_url, R.drawable.a32a));
        Gamelist.add(new Games("Ninja Run ", gamezop_url, R.drawable.a57a));
        Gamelist.add(new Games("Floor-Jumper Escape ", quezop_url, R.drawable.a33a));
        Gamelist.add(new Games("Stack Jump ", gamezop_url, R.drawable.a74a));
        Gamelist.add(new Games("Stick Monkey ", quezop_url, R.drawable.a75a));
        Gamelist.add(new Games("Dashers ", gamezop_url, R.drawable.a24a));
        Gamelist.add(new Games(" Stick Panda", quezop_url, R.drawable.a76a));
        Gamelist.add(new Games(" Zoo Run", gamezop_url, R.drawable.a94a));
        Gamelist.add(new Games("Lost Treasures", quezop_url, R.drawable.ad1));
        Gamelist.add(new Games("PEBBLE BOY", gamezop_url, R.drawable.ad2));
        Gamelist.add(new Games("Mine Clone 4 ", quezop_url, R.drawable.ad3));
        Gamelist.add(new Games("Rabbit Samurai", gamezop_url, R.drawable.ad4));
        Gamelist.add(new Games("3D Bottle Shoter ", quezop_url, R.drawable.ad5));
        Gamelist.add(new Games("Armored Blaster ", gamezop_url, R.drawable.ad6));
        Gamelist.add(new Games("Colours Magnet ", quezop_url, R.drawable.ad7));
        Gamelist.add(new Games("Froliccar Parking", gamezop_url, R.drawable.ad8));
        Gamelist.add(new Games("Build And Protected", quezop_url, R.drawable.ad10));
        Gamelist.add(new Games("Pie .ai", gamezop_url, R.drawable.ad12));
        Gamelist.add(new Games("Stack Tower", quezop_url, R.drawable.ad13));
        Gamelist.add(new Games("Gold-miner", gamezop_url, R.drawable.ad14));
        Gamelist.add(new Games("Bouncing Squirrel ", quezop_url, R.drawable.ad15));
        Gamelist.add(new Games(" Physics BTR", gamezop_url, R.drawable.ad16));
        Gamelist.add(new Games("Sand Worm ", quezop_url, R.drawable.ad17));
        Gamelist.add(new Games("Tap Dash Tap", gamezop_url, R.drawable.ad18));
        Gamelist.add(new Games("BallIn The Cup", quezop_url, R.drawable.ad19));
        Gamelist.add(new Games("Ice Cream", gamezop_url, R.drawable.ad20));
        Gamelist.add(new Games("Hungry Frog ", quezop_url, R.drawable.ad21));
        Gamelist.add(new Games("Mario-Adventure-Worlds", gamezop_url, R.drawable.ad22));
        Gamelist.add(new Games("Crazy-jump-3 ", quezop_url, R.drawable.ad23));
        Gamelist.add(new Games("mario-adventure-worlds", gamezop_url, R.drawable.u16));
        Gamelist.add(new Games(" santa-christmas-adventure", quezop_url, R.drawable.u27));
        Gamelist.add(new Games("young-santa ", gamezop_url, R.drawable.u29));
        Gamelist.add(new Games(" word-connect", quezop_url, R.drawable.u30));
        Gamelist.add(new Games(" christmas-santas-mission ", gamezop_url, R.drawable.u49));
        Gamelist.add(new Games(" shark-adventure ", quezop_url, R.drawable.u50));
        Gamelist.add(new Games("christmas-santa-dream ", gamezop_url, R.drawable.u55));
        Gamelist.add(new Games("christmas-santa-bomber ", quezop_url, R.drawable.u57));
        Gamelist.add(new Games(" santa-christmas-adventure", gamezop_url, R.drawable.u72));
        Gamelist.add(new Games(" skate hooligan", quezop_url, R.drawable.u74));
        Gamelist.add(new Games("jumpy-kangaroo ", gamezop_url, R.drawable.u93));
        Gamelist.add(new Games("caveman-adventures5 ", quezop_url, R.drawable.u94));
        Gamelist.add(new Games(" squirrel-hop", gamezop_url, R.drawable.u95));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        String mygameurl = sharedPreferences.getString("gamezop_url", "");
        GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
        recyclerView.setAdapter(blueGamesAdapter);
    }
}