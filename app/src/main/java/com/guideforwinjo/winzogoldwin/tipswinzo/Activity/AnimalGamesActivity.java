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

public class AnimalGamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atme_games);

        Blue_NativeBannerAds bannerAds = new Blue_NativeBannerAds(this);
        bannerAds.Load250NativeBanner((RelativeLayout) findViewById(R.id.banner), (RelativeLayout) findViewById(R.id.banner_250));

        ArrayList<Games> Gamelist = new ArrayList();

        String quezop_url = sharedPreferences.getString("quezop_url", "");
        String gamezop_url = sharedPreferences.getString("gamezop_url", "");

        Gamelist.add(new Games("Jelly-slice.         ", quezop_url, R.drawable.an1));
        Gamelist.add(new Games("Knife-hit  ", gamezop_url, R.drawable.an2));
        Gamelist.add(new Games(" Scooby to Birthday      ", quezop_url, R.drawable.an3));
        Gamelist.add(new Games("Spot   The Differences       ", gamezop_url, R.drawable.an4));
        Gamelist.add(new Games("Criatures Defence  ", quezop_url, R.drawable.an5));
        Gamelist.add(new Games("Harmonica Hopper          ", gamezop_url, R.drawable.an6));
        Gamelist.add(new Games("Emoji Glass,      ", quezop_url, R.drawable.an7));
        Gamelist.add(new Games(" Baby-Taylor-Farm-Fun         ", gamezop_url, R.drawable.an8));
        Gamelist.add(new Games("Babby Anna A days        ", quezop_url, R.drawable.an9));
        Gamelist.add(new Games("Wash  pets        ", gamezop_url, R.drawable.an10));
        Gamelist.add(new Games("Meng Chong Cheng     ", quezop_url, R.drawable.an11));
        Gamelist.add(new Games("My Dolffin  Show       ", gamezop_url, R.drawable.an12));
        Gamelist.add(new Games("Meow Dress Up         ", quezop_url, R.drawable.an13));
        Gamelist.add(new Games("Victoria Adopts a Kitten        ", gamezop_url, R.drawable.an14));
        Gamelist.add(new Games("MatchAnimals ", quezop_url, R.drawable.an15));
        Gamelist.add(new Games("Fish-world-match ", gamezop_url, R.drawable.an16));
        Gamelist.add(new Games("mashroom fall ", quezop_url, R.drawable.u132));
        Gamelist.add(new Games(" jungle slump", gamezop_url, R.drawable.u133));
        Gamelist.add(new Games("Cowboy Shoot Zombie ", quezop_url, R.drawable.u134));
        Gamelist.add(new Games(" Jumpng Angry Ape", gamezop_url, R.drawable.u144));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        String mygameurl = sharedPreferences.getString("gamezop_url", "");
        GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
        recyclerView.setAdapter(blueGamesAdapter);
    }
}