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

public class ActionGamesActivity extends AppCompatActivity {

    CardView costom;
    private int counter = 2;
    private int counter2 = 3;

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
            Picasso.with(ActionGamesActivity.this).load(Ads.imagegallary.get(counter))
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
                        Picasso.with(ActionGamesActivity.this).load(Ads.imagegallary.get(counter2))
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

        ArrayList<Games> Gamelist = new ArrayList<>();

        Blue_NativeBannerAds bannerAds = new Blue_NativeBannerAds(this);
        bannerAds.Load250NativeBanner((RelativeLayout) findViewById(R.id.banner), (RelativeLayout) findViewById(R.id.banner_250));

        String quezop_url = sharedPreferences.getString("quezop_url", "");
        String gamezop_url = sharedPreferences.getString("gamezop_url", "");

        Gamelist.add(new Games("Air Hockeyir ", quezop_url, R.drawable.a1a));
        Gamelist.add(new Games("Air Warfare ", gamezop_url, R.drawable.a2a));
        Gamelist.add(new Games("Assassin Knight ", quezop_url, R.drawable.a6a));
        Gamelist.add(new Games("Mad Shark ", gamezop_url, R.drawable.a53a));
        Gamelist.add(new Games("Cyber Slashman ", quezop_url, R.drawable.a21a));
        Gamelist.add(new Games("Cyber Soldier ", gamezop_url, R.drawable.a22a));
        Gamelist.add(new Games("Defence Champion ", quezop_url, R.drawable.a26));
        Gamelist.add(new Games("Shoot Robbers ", gamezop_url, R.drawable.a70a));
        Gamelist.add(new Games("Fishing Frenzy ", quezop_url, R.drawable.a31a));
        Gamelist.add(new Games(" Great-Air Battles", gamezop_url, R.drawable.a42a));
        Gamelist.add(new Games("Tank Defender ", quezop_url, R.drawable.a82a));
        Gamelist.add(new Games("Tank Wars ", gamezop_url, R.drawable.a83a));
        Gamelist.add(new Games("Duck Shooter ", quezop_url, R.drawable.a28a));
        Gamelist.add(new Games("Duosometric Jump ", gamezop_url, R.drawable.a29a));
        Gamelist.add(new Games("Duck Hunter ", quezop_url, R.drawable.a27a));
        Gamelist.add(new Games("Alien-Hunter 2 ", gamezop_url, R.drawable.a3a));
        Gamelist.add(new Games(" Strike Expert", quezop_url, R.drawable.a78a));
        Gamelist.add(new Games("Gold Miner ", gamezop_url, R.drawable.a40a));
        Gamelist.add(new Games("Fire Soldier ", quezop_url, R.drawable.a30a));
        Gamelist.add(new Games("Yeti Sensation", gamezop_url, R.drawable.a1));
        Gamelist.add(new Games("Chop Chop slice-rush", quezop_url, R.drawable.a30));
        Gamelist.add(new Games("Cut-The-Rope     ", gamezop_url, R.drawable.a31));
        Gamelist.add(new Games("Ludu King", quezop_url, R.drawable.a2));
        Gamelist.add(new Games("Temple Run     ", gamezop_url, R.drawable.a3));
        Gamelist.add(new Games(" The Shootout : Saloon", quezop_url, R.drawable.a4));
        Gamelist.add(new Games("Subway Runer      ", gamezop_url, R.drawable.a5));
        Gamelist.add(new Games(" Fruits Ninja", quezop_url, R.drawable.a6));
        Gamelist.add(new Games("Santa City Run", gamezop_url, R.drawable.a7));
        Gamelist.add(new Games("The Private Ship", quezop_url, R.drawable.a8));
        Gamelist.add(new Games("Slinguin", gamezop_url, R.drawable.a9));
        Gamelist.add(new Games("Snakes & Ladders", quezop_url, R.drawable.a10));
        Gamelist.add(new Games("Viking Escape ", gamezop_url, R.drawable.a89a));
        Gamelist.add(new Games("Soldiers-Combat", quezop_url, R.drawable.a12));
        Gamelist.add(new Games("Fruit-Master", gamezop_url, R.drawable.a13));
        Gamelist.add(new Games("Fishing-frenzy", quezop_url, R.drawable.a14));
        Gamelist.add(new Games("Duck-hunter", gamezop_url, R.drawable.a15));
        Gamelist.add(new Games("Mad-shark", quezop_url, R.drawable.a16));
        Gamelist.add(new Games("Snake-attack ", gamezop_url, R.drawable.a17));
        Gamelist.add(new Games("mummy-candies", quezop_url, R.drawable.a18));
        Gamelist.add(new Games("Santa-run", gamezop_url, R.drawable.a19));
        Gamelist.add(new Games("Shoot-robbers ", quezop_url, R.drawable.a20));
        Gamelist.add(new Games(" KnifeBreak  ", gamezop_url, R.drawable.a21));
        Gamelist.add(new Games("TropicPirateTreasure", quezop_url, R.drawable.a22));
        Gamelist.add(new Games(" KnifeFlip", gamezop_url, R.drawable.a23));
        Gamelist.add(new Games(" KungFuMaster", quezop_url, R.drawable.a24));
        Gamelist.add(new Games("Archery", gamezop_url, R.drawable.a25));
        Gamelist.add(new Games("DontCutYourself", quezop_url, R.drawable.a26));
        Gamelist.add(new Games("ApachiriRun", gamezop_url, R.drawable.a27));
        Gamelist.add(new Games("Fruit-slasher ", quezop_url, R.drawable.a29));
        Gamelist.add(new Games("E.T", gamezop_url, R.drawable.a28));
        Gamelist.add(new Games("  knife-ninja", quezop_url, R.drawable.u43));
        Gamelist.add(new Games("  slither.io", gamezop_url, R.drawable.u44));
        Gamelist.add(new Games("archery_training  ", quezop_url, R.drawable.u46));
        Gamelist.add(new Games("angry-birds", gamezop_url, R.drawable.u53));
        Gamelist.add(new Games(" guitar-hero ", quezop_url, R.drawable.u54));
        Gamelist.add(new Games("neon-hockey ", gamezop_url, R.drawable.u56));
        Gamelist.add(new Games(" guns and bottles", quezop_url, R.drawable.u88));
        Gamelist.add(new Games(" ninja-action", gamezop_url, R.drawable.u100));
        Gamelist.add(new Games("soldiers-combat ", quezop_url, R.drawable.u101));
        Gamelist.add(new Games(" village-story", gamezop_url, R.drawable.u102));
        Gamelist.add(new Games("the-office-guy ", quezop_url, R.drawable.u104));
        Gamelist.add(new Games("jungle-war ", gamezop_url, R.drawable.u122));
        Gamelist.add(new Games("School boy Warrior ", quezop_url, R.drawable.u138));
        Gamelist.add(new Games("Captain war Z.K ", gamezop_url, R.drawable.u140));
        Gamelist.add(new Games("Bazooka gun boy ", quezop_url, R.drawable.u143));
        Gamelist.add(new Games("Angry Dragons ", gamezop_url, R.drawable.u147));
        Gamelist.add(new Games(" Defenders Mission", quezop_url, R.drawable.u148));
        Gamelist.add(new Games("Captain war Z.K ", gamezop_url, R.drawable.u140));
        Gamelist.add(new Games("Bazooka gun boy ", quezop_url, R.drawable.u143));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        String mygameurl = sharedPreferences.getString("gamezop_url", "");
        GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
        recyclerView.setAdapter(blueGamesAdapter);
    }
}