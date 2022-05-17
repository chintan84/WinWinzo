package com.guideforwinjo.winzogoldwin.tipswinzo.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.Blue_NativeBannerAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.Model.Games;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.Adapter.GamesAdapter;

import java.util.ArrayList;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class ombieGamesActivity extends AppCompatActivity {

    CardView costom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atme_games);

        costom = findViewById(R.id.costom);
        String costomad = sharedPreferences.getString("costomad", "");
        if (costomad.equalsIgnoreCase("on")) {
            costom.setVisibility(View.VISIBLE);
            costom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sharedPreferences.getString("costompk",""))));
                }
            });
        }

        Blue_NativeBannerAds bannerAds = new Blue_NativeBannerAds(this);
        bannerAds.Load250NativeBanner((RelativeLayout) findViewById(R.id.banner), (RelativeLayout) findViewById(R.id.banner_250));

        ArrayList<Games> Gamelist = new ArrayList();

        String quezop_url = sharedPreferences.getString("quezop_url", "");
        String gamezop_url = sharedPreferences.getString("gamezop_url", "");

        Gamelist.add(new Games(" Viking Attack", gamezop_url, R.drawable.a88a));
        Gamelist.add(new Games("Viking Escape ", gamezop_url, R.drawable.a89a));
        Gamelist.add(new Games(" Vikings-Vs Skeletons", gamezop_url, R.drawable.a90a));
        Gamelist.add(new Games("Wothan Escape ", quezop_url, R.drawable.a91a));
        Gamelist.add(new Games(" Zombie Buster", gamezop_url, R.drawable.a92a));
        Gamelist.add(new Games("Zombie Shooter ", quezop_url, R.drawable.a93a));
        Gamelist.add(new Games("Super-Cowboy Run ", gamezop_url, R.drawable.a80a));
        Gamelist.add(new Games("Ranger-Vs Zombies ", quezop_url, R.drawable.a65a));
        Gamelist.add(new Games("Knife-Vs Zombies\t ", gamezop_url, R.drawable.a51a));
        Gamelist.add(new Games("Mad Scientist ", quezop_url, R.drawable.a52a));
        Gamelist.add(new Games("Swat-Vs Zombies ", gamezop_url, R.drawable.a81a));
        Gamelist.add(new Games("The-Bandit Hunter ", quezop_url, R.drawable.a84a));
        Gamelist.add(new Games("Lone-pistol-zombies-in-the-streets", quezop_url, R.drawable.z1));
        Gamelist.add(new Games("ZOMBIES CAN’T JUMP", gamezop_url, R.drawable.z2));
        Gamelist.add(new Games("  Zombie-buster", quezop_url, R.drawable.z3));
        Gamelist.add(new Games("Ranger-vs-zombies ", quezop_url, R.drawable.z4));
        Gamelist.add(new Games("SWAT Vs Zombie", gamezop_url, R.drawable.z5));
        Gamelist.add(new Games("Zombie Shooter ", quezop_url, R.drawable.a93a));
        Gamelist.add(new Games("Mad-Scientist", gamezop_url, R.drawable.z7));
        Gamelist.add(new Games("Viking-Escape", quezop_url, R.drawable.z9));
        Gamelist.add(new Games("Bones-slasher", gamezop_url, R.drawable.z10));
        Gamelist.add(new Games("Zombie Can't Jump 2", quezop_url, R.drawable.z11));
        Gamelist.add(new Games("Invader-zim-doom-game", gamezop_url, R.drawable.z12));
        Gamelist.add(new Games("Defend the den", quezop_url, R.drawable.z14));
        Gamelist.add(new Games("Run-Into-Death", gamezop_url, R.drawable.z15));
        Gamelist.add(new Games("Super-cowboy-run", quezop_url, R.drawable.z21));
        Gamelist.add(new Games("ZombieSmash", gamezop_url, R.drawable.z16));
        Gamelist.add(new Games("Cowboy-shoot-zombies", quezop_url, R.drawable.z17));
        Gamelist.add(new Games("Zombie-uprising", gamezop_url, R.drawable.z18));
        Gamelist.add(new Games("skulls-vs-zombies", quezop_url, R.drawable.z19));
        Gamelist.add(new Games("  SAVE THE MONSTERS ", gamezop_url, R.drawable.z20));
        Gamelist.add(new Games("spinner-vs-zombies ", quezop_url, R.drawable.u28));
        Gamelist.add(new Games("Cowboy-shoot-zombies", gamezop_url, R.drawable.z17));
        Gamelist.add(new Games("Zombie-uprising", quezop_url, R.drawable.z18));
        Gamelist.add(new Games("skulls-vs-zombies", quezop_url, R.drawable.z19));
        Gamelist.add(new Games("  SAVE THE MONSTERS ", quezop_url, R.drawable.z20));
        Gamelist.add(new Games(" goblins-vs-skeleton", gamezop_url, R.drawable.u121));
        Gamelist.add(new Games("Captain war ", gamezop_url, R.drawable.u128));
        Gamelist.add(new Games(" Shoot Angry Zombie", gamezop_url, R.drawable.u137));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        String mygameurl = sharedPreferences.getString("gamezop_url", "");
        GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
        recyclerView.setAdapter(blueGamesAdapter);
    }
}