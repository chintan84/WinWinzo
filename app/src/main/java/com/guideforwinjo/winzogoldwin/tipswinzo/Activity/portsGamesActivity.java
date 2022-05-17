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

public class portsGamesActivity extends AppCompatActivity {

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

        Gamelist.add(new Games("Basketball ", gamezop_url, R.drawable.a8a));
        Gamelist.add(new Games("Billiards ", gamezop_url, R.drawable.a9a));
        Gamelist.add(new Games("Air Hockeyir ", quezop_url, R.drawable.a1a));
        Gamelist.add(new Games("Monster-Truck Football\t ", gamezop_url, R.drawable.a55a));
        Gamelist.add(new Games("Pool-8 Ball ", quezop_url, R.drawable.a62a));
        Gamelist.add(new Games("Stickman-Table Tennis ", gamezop_url, R.drawable.a77a));
        Gamelist.add(new Games(" Pops Billiards", quezop_url, R.drawable.a63a));
        Gamelist.add(new Games("Supe-Pon Goal ", gamezop_url, R.drawable.a79a));
        Gamelist.add(new Games("Penalty Challenge ", quezop_url, R.drawable.a58a));
        Gamelist.add(new Games("Space Purge", gamezop_url, R.drawable.a71a));
        Gamelist.add(new Games(" Barn Dash", quezop_url, R.drawable.a7a));
        Gamelist.add(new Games("Jumpers Jumpers ", gamezop_url, R.drawable.a49a));
        Gamelist.add(new Games("Jungle Treasure", quezop_url, R.drawable.a50a));
        Gamelist.add(new Games("Rasing Stary   ", gamezop_url, R.drawable.sp1));
        Gamelist.add(new Games("CPL-tournament  ", quezop_url, R.drawable.sp2));
        Gamelist.add(new Games("Candy Bubble    ", gamezop_url, R.drawable.sp3));
        Gamelist.add(new Games("Weely 3   ", quezop_url, R.drawable.sp4));
        Gamelist.add(new Games("Touchdown_rush    ", gamezop_url, R.drawable.sp5));
        Gamelist.add(new Games("Cricket_batter_challenge    ", quezop_url, R.drawable.sp6));
        Gamelist.add(new Games("Funny_soccer  ", gamezop_url, R.drawable.sp8));
        Gamelist.add(new Games("Rollout  ", quezop_url, R.drawable.sp9));
        Gamelist.add(new Games("Wrestle Online   ", gamezop_url, R.drawable.sp10));
        Gamelist.add(new Games("Swipe-basketball    ", quezop_url, R.drawable.sp11));
        Gamelist.add(new Games("Flappy-ball    ", gamezop_url, R.drawable.sp12));
        Gamelist.add(new Games("Flappy-bounce    ", quezop_url, R.drawable.sp13));
        Gamelist.add(new Games("FortuneBall  ", gamezop_url, R.drawable.sp14));
        Gamelist.add(new Games("PatrolBypass    ", quezop_url, R.drawable.sp15));
        Gamelist.add(new Games(" FootballHeroes    ", gamezop_url, R.drawable.sp16));
        Gamelist.add(new Games("Touch-ball  ", quezop_url, R.drawable.sp17));
        Gamelist.add(new Games("Super-pongoal ", gamezop_url, R.drawable.sp18));
        Gamelist.add(new Games(" Pool-8-ball ", quezop_url, R.drawable.sp19));
        Gamelist.add(new Games("Neon-hockey  ", gamezop_url, R.drawable.sp20));
        Gamelist.add(new Games(" Cricket-fielder-challenge", quezop_url, R.drawable.sp21));
        Gamelist.add(new Games("Cricket-batter-challenge ", gamezop_url, R.drawable.sp22));
        Gamelist.add(new Games(" 8-ball-pool ", quezop_url, R.drawable.u42));
        Gamelist.add(new Games(" stickman-ping-pong", quezop_url, R.drawable.u22));
        Gamelist.add(new Games("  table-tennis-world-tour", gamezop_url, R.drawable.u47));
        Gamelist.add(new Games(" basketball frvr", gamezop_url, R.drawable.u58));
        Gamelist.add(new Games("street-cricket", quezop_url, R.drawable.u84));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        String mygameurl = sharedPreferences.getString("gamezop_url", "");
        GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
        recyclerView.setAdapter(blueGamesAdapter);
    }
}