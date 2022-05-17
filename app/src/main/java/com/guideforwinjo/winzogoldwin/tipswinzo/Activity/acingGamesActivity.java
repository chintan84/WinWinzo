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

public class acingGamesActivity extends AppCompatActivity {

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

        Gamelist.add(new Games(" Crazy Runner", quezop_url, R.drawable.a17a));
        Gamelist.add(new Games("Cube Ninja ", gamezop_url, R.drawable.a20a));
        Gamelist.add(new Games("Road Racer ", quezop_url, R.drawable.a66a));
        Gamelist.add(new Games(" Santa Run", gamezop_url, R.drawable.a68a));
        Gamelist.add(new Games("Scary Run ", quezop_url, R.drawable.a69a));
        Gamelist.add(new Games("Speed Racer ", gamezop_url, R.drawable.a72a));
        Gamelist.add(new Games(" Speedy Driving", quezop_url, R.drawable.a73a));
        Gamelist.add(new Games("Traffic ", gamezop_url, R.drawable.a85a));
        Gamelist.add(new Games("Traffic Command ", quezop_url, R.drawable.a86a));
        Gamelist.add(new Games("Truck-Parking Pro ", gamezop_url, R.drawable.a87a));
        Gamelist.add(new Games("Dark Ninja ", quezop_url, R.drawable.a23a));
        Gamelist.add(new Games(" Creepy Day", gamezop_url, R.drawable.a18a));
        Gamelist.add(new Games(" Cube Dash", quezop_url, R.drawable.a19a));
        Gamelist.add(new Games(" Cars", gamezop_url, R.drawable.a16a));
        Gamelist.add(new Games("Hill-climb-racing-3   ", quezop_url, R.drawable.ra1));
        Gamelist.add(new Games("Save the Egg   ", gamezop_url, R.drawable.ra2));
        Gamelist.add(new Games("Paper racers Boomerang     ", quezop_url, R.drawable.ra3));
        Gamelist.add(new Games("Up-hill-racing   ", gamezop_url, R.drawable.ra4));
        Gamelist.add(new Games("Gear_madness    ", quezop_url, R.drawable.ra5));
        Gamelist.add(new Games("Moto Cruiser Highway   ", gamezop_url, R.drawable.ra6));
        Gamelist.add(new Games("Rocking_wheels    ", quezop_url, R.drawable.ra7));
        Gamelist.add(new Games("Water Slides.io   ", gamezop_url, R.drawable.ra8));
        Gamelist.add(new Games("Moto_beach_rider   ", quezop_url, R.drawable.ra9));
        Gamelist.add(new Games("Uphill Bus Simulator   ", gamezop_url, R.drawable.ra10));
        Gamelist.add(new Games("Burnin-rubbe   ", quezop_url, R.drawable.ra11));
        Gamelist.add(new Games("Horse_racing  ", gamezop_url, R.drawable.ra12));
        Gamelist.add(new Games("Car_rush   ", quezop_url, R.drawable.ra13));
        Gamelist.add(new Games("Drive_your_car    ", gamezop_url, R.drawable.ra14));
        Gamelist.add(new Games("lightning-speed2   ", quezop_url, R.drawable.ra15));
        Gamelist.add(new Games("Tractor trial    ", gamezop_url, R.drawable.ra16));
        Gamelist.add(new Games("Barrel-jump   ", quezop_url, R.drawable.ra17));
        Gamelist.add(new Games("Speed-racer    ", gamezop_url, R.drawable.ra18));
        Gamelist.add(new Games("Tank-wars     ", quezop_url, R.drawable.ra19));
        Gamelist.add(new Games("Track-racer   ", gamezop_url, R.drawable.ra20));
        Gamelist.add(new Games("Traffic ", quezop_url, R.drawable.ra21));
        Gamelist.add(new Games("Desert Road  ", gamezop_url, R.drawable.ve1));
        Gamelist.add(new Games("Drive Taxi     ", quezop_url, R.drawable.ve2));
        Gamelist.add(new Games("Maserati GrabTurismo   ", gamezop_url, R.drawable.ve3));
        Gamelist.add(new Games("OffRoadClimber   ", quezop_url, R.drawable.ve4));
        Gamelist.add(new Games("Buggy Rally     ", gamezop_url, R.drawable.ve5));
        Gamelist.add(new Games("Car Speed Booster    ", quezop_url, R.drawable.ve6));
        Gamelist.add(new Games("Stud-rider  ", gamezop_url, R.drawable.ve7));
        Gamelist.add(new Games("Ninja-jump-force   ", quezop_url, R.drawable.ve8));
        Gamelist.add(new Games("Biggy_way   ", gamezop_url, R.drawable.ve9));
        Gamelist.add(new Games("Railrush    ", quezop_url, R.drawable.ve10));
        Gamelist.add(new Games("Super Speed  Runner    ", gamezop_url, R.drawable.ve12));
        Gamelist.add(new Games("TrainGenerationVS   ", quezop_url, R.drawable.ve13));
        Gamelist.add(new Games("OffRoadClimber    ", gamezop_url, R.drawable.ve14));
        Gamelist.add(new Games("Monster_truck   ", quezop_url, R.drawable.ve15));
        Gamelist.add(new Games("wheelie-bike", gamezop_url, R.drawable.u13));
        Gamelist.add(new Games("monster_truck ", quezop_url, R.drawable.u17));
        Gamelist.add(new Games(" moto_beach_rider", gamezop_url, R.drawable.u18));
        Gamelist.add(new Games(" finger-drift", quezop_url, R.drawable.u66));
        Gamelist.add(new Games(" tap-touch-run", gamezop_url, R.drawable.u67));
        Gamelist.add(new Games("moto-winter ", quezop_url, R.drawable.u68));
        Gamelist.add(new Games(" highway-rider-extrem", gamezop_url, R.drawable.u71));
        Gamelist.add(new Games("mini-drifts ", quezop_url, R.drawable.u73));
        Gamelist.add(new Games(" runpanda run", gamezop_url, R.drawable.u89));
        Gamelist.add(new Games(" stud-rider", quezop_url, R.drawable.u99));
        Gamelist.add(new Games("speedy-boat ", gamezop_url, R.drawable.u105));
        Gamelist.add(new Games("road-fight ", quezop_url, R.drawable.u116));
        Gamelist.add(new Games(" sea ship Rasing", gamezop_url, R.drawable.u129));
        Gamelist.add(new Games("Chase rasing cars ", quezop_url, R.drawable.u131));
        Gamelist.add(new Games(" Car Speed Booster", gamezop_url, R.drawable.u146));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        String mygameurl = sharedPreferences.getString("gamezop_url", "");
        GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
        recyclerView.setAdapter(blueGamesAdapter);
    }
}