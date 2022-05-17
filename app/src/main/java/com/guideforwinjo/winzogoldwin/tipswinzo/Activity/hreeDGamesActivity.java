package com.guideforwinjo.winzogoldwin.tipswinzo.Activity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.Blue_NativeBannerAds;
import com.guideforwinjo.winzogoldwin.tipswinzo.Model.Games;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.Adapter.GamesAdapter;

import java.util.ArrayList;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class hreeDGamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atme_games);

        Blue_NativeBannerAds bannerAds = new Blue_NativeBannerAds(this);
        bannerAds.Load250NativeBanner((RelativeLayout) findViewById(R.id.banner), (RelativeLayout) findViewById(R.id.banner_250));

        ArrayList<Games> Gamelist = new ArrayList();

        String quezop_url = sharedPreferences.getString("quezop_url", "");
        String gamezop_url = sharedPreferences.getString("gamezop_url", "");

        Gamelist.add(new Games("Rocket Road    ", gamezop_url, R.drawable.th1));
        Gamelist.add(new Games("Helix-jump    ", quezop_url, R.drawable.th2));
        Gamelist.add(new Games("Flip-It    ", gamezop_url, R.drawable.th3));
        Gamelist.add(new Games("3d-bottle-shooter   ", quezop_url, R.drawable.th4));
        Gamelist.add(new Games("Rush-3d2   ", gamezop_url, R.drawable.th5));
        Gamelist.add(new Games("3D-Rubiks-cube ", quezop_url, R.drawable.th6));
        Gamelist.add(new Games("Ball jump   ", gamezop_url, R.drawable.th7));
        Gamelist.add(new Games("Break-the-cup    ", quezop_url, R.drawable.th8));
        Gamelist.add(new Games("Blaze Dragon island Race  ", gamezop_url, R.drawable.th9));
        Gamelist.add(new Games("Taable tennis      ", quezop_url, R.drawable.th10));
        Gamelist.add(new Games("Knife Up    ", gamezop_url, R.drawable.th11));
        Gamelist.add(new Games("DuckPark Io   ", quezop_url, R.drawable.th12));
        Gamelist.add(new Games(" Rollout  ", gamezop_url, R.drawable.th13));
        Gamelist.add(new Games("Colour Tower 2   ", quezop_url, R.drawable.th14));
        Gamelist.add(new Games("Run Rase 3d 2   ", gamezop_url, R.drawable.th15));
        Gamelist.add(new Games("Run Rase   ", quezop_url, R.drawable.th16));
        Gamelist.add(new Games("Hyper Jump 3D   ", gamezop_url, R.drawable.th17));
        Gamelist.add(new Games("Limit Carve  ", quezop_url, R.drawable.th18));
        Gamelist.add(new Games("Stack-bump-3d  ", quezop_url, R.drawable.th19));
        Gamelist.add(new Games("crazy_jump ", quezop_url, R.drawable.u1));
        Gamelist.add(new Games("fruit-break ", gamezop_url, R.drawable.u2));
        Gamelist.add(new Games("piano-tiles-classic ", quezop_url, R.drawable.u3));
        Gamelist.add(new Games("uzzle_ball ", gamezop_url, R.drawable.u19));
        Gamelist.add(new Games(" 100-balls", gamezop_url, R.drawable.u23));
        Gamelist.add(new Games("3d-rubiks-cube ", quezop_url, R.drawable.u24));
        Gamelist.add(new Games("zig-music-line ", quezop_url, R.drawable.u61));
        Gamelist.add(new Games(" shoot-balls-3d", gamezop_url, R.drawable.u69));
        Gamelist.add(new Games(" Hit the glow ", gamezop_url, R.drawable.u92));
        Gamelist.add(new Games(" light-rays", gamezop_url, R.drawable.u106));


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        String mygameurl = sharedPreferences.getString("gamezop_url", "");
        GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
        recyclerView.setAdapter(blueGamesAdapter);
    }
}