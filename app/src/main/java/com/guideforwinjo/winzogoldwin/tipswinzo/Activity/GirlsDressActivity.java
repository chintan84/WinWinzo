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

public class GirlsDressActivity extends AppCompatActivity {

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

        Gamelist.add(new Games("Amelia Dress-Up    ", quezop_url, R.drawable.gl1));
        Gamelist.add(new Games("Wonderlan fairy princess   ", gamezop_url, R.drawable.gl2));
        Gamelist.add(new Games("Mommy BFFs Preganant check Up   ", quezop_url, R.drawable.gl13));
        Gamelist.add(new Games("Winter lockBook   ", gamezop_url, R.drawable.gl4));
        Gamelist.add(new Games("Waking sleeping beauty    ", quezop_url, R.drawable.gl5));
        Gamelist.add(new Games("Princess-mermaid-accident-er   ", gamezop_url, R.drawable.gl6));
        Gamelist.add(new Games("Wow Girl    ", quezop_url, R.drawable.gl7));
        Gamelist.add(new Games("Pizza Relife Cookig   ", gamezop_url, R.drawable.gl8));
        Gamelist.add(new Games("Disney Princess makeover  ", quezop_url, R.drawable.gl9));
        Gamelist.add(new Games("DentistDoctor Teeth   ", gamezop_url, R.drawable.gl10));
        Gamelist.add(new Games("Avocado Toast instagram     ", quezop_url, R.drawable.gl11));
        Gamelist.add(new Games("Legendary fashion   ", gamezop_url, R.drawable.gl12));
        Gamelist.add(new Games("Sandwich baker   ", quezop_url, R.drawable.gl13));
        Gamelist.add(new Games("Girl-dress-up   ", gamezop_url, R.drawable.gl14));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        String mygameurl = sharedPreferences.getString("gamezop_url", "");
        GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
        recyclerView.setAdapter(blueGamesAdapter);
    }
}