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
import com.guideforwinjo.winzogoldwin.tipswinzo.Adapter.GamesAdapter;
import com.guideforwinjo.winzogoldwin.tipswinzo.Model.Games;
import com.guideforwinjo.winzogoldwin.R;

import java.util.ArrayList;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class GameZopActivity extends AppCompatActivity {

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
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sharedPreferences.getString("costompk", ""))));
                }
            });
        }

        Blue_NativeBannerAds bannerAds = new Blue_NativeBannerAds(this);
        bannerAds.Load250NativeBanner((RelativeLayout) findViewById(R.id.banner), (RelativeLayout) findViewById(R.id.banner_250));

        ArrayList<Games> Gamelist = new ArrayList();

        String quezop_url = sharedPreferences.getString("quezop_url", "");
        String gamezop_url = sharedPreferences.getString("gamezop_url", "");

        Gamelist.add(new Games(" Bottle Shoot", quezop_url, R.drawable.zo1));
        Gamelist.add(new Games("Slap Fest ", gamezop_url, R.drawable.a14z));
        Gamelist.add(new Games("Ludo With Friends ", quezop_url, R.drawable.t8));
        Gamelist.add(new Games("Pumpkin Smasher ", gamezop_url, R.drawable.t66));
        Gamelist.add(new Games("Zombies Can't Jump 2", quezop_url, R.drawable.z10));
        Gamelist.add(new Games(" Savage Revenge", gamezop_url, R.drawable.t65));
        Gamelist.add(new Games("Evil Wyrm ", quezop_url, R.drawable.a1z));
        Gamelist.add(new Games("Defense of Karmax 3 ", gamezop_url, R.drawable.a2z));
        Gamelist.add(new Games("Pixel Zombies ", quezop_url, R.drawable.a3z));
        Gamelist.add(new Games("Cuby Zap ", gamezop_url, R.drawable.a4az));
        Gamelist.add(new Games(" Rabbit Punch", quezop_url, R.drawable.a5az));
        Gamelist.add(new Games("Monsteroid", gamezop_url, R.drawable.a6az));
        Gamelist.add(new Games(" Shadow Run", quezop_url, R.drawable.a7az));
        Gamelist.add(new Games("Troll Boxing ", gamezop_url, R.drawable.a8az));
        Gamelist.add(new Games("Ooltaa ", quezop_url, R.drawable.a9az));
        Gamelist.add(new Games(" Sheriff's Wrath", gamezop_url, R.drawable.t10));
        Gamelist.add(new Games(" Rapunzel Tower ", quezop_url, R.drawable.a12az));
        Gamelist.add(new Games(" Pie Attack", gamezop_url, R.drawable.a13az));
        Gamelist.add(new Games(" Crunching Ninjas", quezop_url, R.drawable.a15az));
        Gamelist.add(new Games(" Dead End", gamezop_url, R.drawable.a16az));
        Gamelist.add(new Games("Rocket Man ", quezop_url, R.drawable.a18az));
        Gamelist.add(new Games("Pirate Hunt ", gamezop_url, R.drawable.a19az));
        Gamelist.add(new Games(" Valley of Terror", quezop_url, R.drawable.t20));
        Gamelist.add(new Games("Aliens Attack ", gamezop_url, R.drawable.a21az));
        Gamelist.add(new Games(" Gerbil Jump", quezop_url, R.drawable.a22az));
        Gamelist.add(new Games(" Animals Air Fight", gamezop_url, R.drawable.a23az));
        Gamelist.add(new Games("Rollout ", quezop_url, R.drawable.v9));
        Gamelist.add(new Games("Rope Ninja ", gamezop_url, R.drawable.v28));
        Gamelist.add(new Games("Escape Run", quezop_url, R.drawable.v29));
        Gamelist.add(new Games(" Sway Bay", gamezop_url, R.drawable.v27));
        Gamelist.add(new Games("Jimbo Jump ", quezop_url, R.drawable.v20));
        Gamelist.add(new Games("Sticky Goo ", gamezop_url, R.drawable.v6));
        Gamelist.add(new Games("Knife Flip ", quezop_url, R.drawable.v21));
        Gamelist.add(new Games("Knight Ride ", gamezop_url, R.drawable.v30));
        Gamelist.add(new Games("Pigeon Bomber ", quezop_url, R.drawable.v2));
        Gamelist.add(new Games("Battle Fish ", gamezop_url, R.drawable.v3));
        Gamelist.add(new Games(" Marshmallow Dash", quezop_url, R.drawable.v4));
        Gamelist.add(new Games("Holiday Cheer", gamezop_url, R.drawable.v5));
        Gamelist.add(new Games("Saucer Dodge ", quezop_url, R.drawable.v1));
        Gamelist.add(new Games("Submarine Dash", gamezop_url, R.drawable.v7));
        Gamelist.add(new Games("Mouse Jump  ", quezop_url, R.drawable.v8));
        Gamelist.add(new Games(" Colour Chase", gamezop_url, R.drawable.v10));
        Gamelist.add(new Games("Cosmo Spin ", quezop_url, R.drawable.v11));
        Gamelist.add(new Games(" Space Cowboy", gamezop_url, R.drawable.v12));
        Gamelist.add(new Games(" Sir Bottomtight", quezop_url, R.drawable.v13));
        Gamelist.add(new Games(" Monster Wants Candy", gamezop_url, R.drawable.v14));
        Gamelist.add(new Games("Snappy Spy ", quezop_url, R.drawable.v15));
        Gamelist.add(new Games(" Pirate Kid", gamezop_url, R.drawable.v16));
        Gamelist.add(new Games("Aqua Thief ", quezop_url, R.drawable.v17));
        Gamelist.add(new Games(" Catch-a-pult", gamezop_url, R.drawable.v18));
        Gamelist.add(new Games("One More Flight ", quezop_url, R.drawable.v19));
        Gamelist.add(new Games("Twin Hop ", gamezop_url, R.drawable.v40));
        Gamelist.add(new Games(" Alfy", quezop_url, R.drawable.v41));
        Gamelist.add(new Games("Nosedive ", gamezop_url, R.drawable.v22));
        Gamelist.add(new Games("Jumpy: The First Jumper ", quezop_url, R.drawable.v23));
        Gamelist.add(new Games("Dodge Bot ", gamezop_url, R.drawable.v24));
        Gamelist.add(new Games(" Penguin Skip", quezop_url, R.drawable.v25));
        Gamelist.add(new Games("Sneaky Snack ", gamezop_url, R.drawable.v26));
        Gamelist.add(new Games(" Odd One Out", quezop_url, R.drawable.v31));
        Gamelist.add(new Games("The Sea Lion Act ", gamezop_url, R.drawable.v32));
        Gamelist.add(new Games("Go Chicken Go ", quezop_url, R.drawable.v33));
        Gamelist.add(new Games(" Snakes & Ladders", quezop_url, R.drawable.v34));
        Gamelist.add(new Games(" Jumpy Ape Joe", quezop_url, R.drawable.v35));
        Gamelist.add(new Games("Panda Love ", gamezop_url, R.drawable.v36));
        Gamelist.add(new Games(" Terra Infirma", quezop_url, R.drawable.v37));
        Gamelist.add(new Games(" Flying School", gamezop_url, R.drawable.v38));
        Gamelist.add(new Games(" Astro Knot", quezop_url, R.drawable.v39));
        Gamelist.add(new Games("Red Rush ", gamezop_url, R.drawable.r17));
        Gamelist.add(new Games("Tower Twist ", quezop_url, R.drawable.r18));
        Gamelist.add(new Games(" Falling Through", quezop_url, R.drawable.r12));
        Gamelist.add(new Games(" Flexi Snake", quezop_url, R.drawable.r15));
        Gamelist.add(new Games("Bouncy ", quezop_url, R.drawable.r25));
        Gamelist.add(new Games(" Vegetables vs. Chef", quezop_url, R.drawable.r2));
        Gamelist.add(new Games("Watch The Walls ", gamezop_url, R.drawable.r3));
        Gamelist.add(new Games(" Stay On The Road", quezop_url, R.drawable.r4));
        Gamelist.add(new Games(" Whirly Chick", gamezop_url, R.drawable.r5));
        Gamelist.add(new Games("Spikes Don't ", quezop_url, R.drawable.r6));
        Gamelist.add(new Games(" Sheepop", gamezop_url, R.drawable.r7));
        Gamelist.add(new Games("Fly Safe ", quezop_url, R.drawable.r8));
        Gamelist.add(new Games(" Car Flip", gamezop_url, R.drawable.r9));
        Gamelist.add(new Games("Cuby Dash ", quezop_url, R.drawable.r10));
        Gamelist.add(new Games(" Don't Eat Trash", gamezop_url, R.drawable.r11));
        Gamelist.add(new Games(" Falling Through", quezop_url, R.drawable.r12));
        Gamelist.add(new Games("Super Sprint ", gamezop_url, R.drawable.r13));
        Gamelist.add(new Games("Where's Tom? ", quezop_url, R.drawable.r14));
        Gamelist.add(new Games(" Flexi Snake", quezop_url, R.drawable.r15));
        Gamelist.add(new Games("Zoo Pinball ", gamezop_url, R.drawable.r16));
        Gamelist.add(new Games("Drift Control ", quezop_url, R.drawable.r19));
        Gamelist.add(new Games("Hoop Loop ", gamezop_url, R.drawable.r20));
        Gamelist.add(new Games("Skill Shot ", quezop_url, R.drawable.r21));
        Gamelist.add(new Games(" Exoplanet Express", gamezop_url, R.drawable.r22));
        Gamelist.add(new Games(" Bouncing Beasts", quezop_url, R.drawable.r23));
        Gamelist.add(new Games("Dodgy ", gamezop_url, R.drawable.r24));
        Gamelist.add(new Games("Bouncy ", quezop_url, R.drawable.r25));
        Gamelist.add(new Games("Spinning Shooter ", gamezop_url, R.drawable.r26));
        Gamelist.add(new Games("5 Jumps ", quezop_url, R.drawable.r27));
        Gamelist.add(new Games("Rock the Dock ", gamezop_url, R.drawable.r28));
        Gamelist.add(new Games("Light Tower ", quezop_url, R.drawable.r29));
        Gamelist.add(new Games(" Sheep Stacking", gamezop_url, R.drawable.r30));
        Gamelist.add(new Games("Tricky Trip ", quezop_url, R.drawable.r31));
        Gamelist.add(new Games("Shade Shuffle ", gamezop_url, R.drawable.r32));
        Gamelist.add(new Games(" Melon Pinch", quezop_url, R.drawable.r33));
        Gamelist.add(new Games("Grumpy Gorilla", gamezop_url, R.drawable.r34));
        Gamelist.add(new Games("Quick Slip ", quezop_url, R.drawable.r35));
        Gamelist.add(new Games(" Fidgety Frog", gamezop_url, R.drawable.r36));
        Gamelist.add(new Games(" Focus Locus", quezop_url, R.drawable.r37));
        Gamelist.add(new Games("Jom Jom Jump ", gamezop_url, R.drawable.r38));
        Gamelist.add(new Games(" Fizz Fuss", quezop_url, R.drawable.r39));
        Gamelist.add(new Games("Rains of Fire ", gamezop_url, R.drawable.r40));
        Gamelist.add(new Games("2048 ", quezop_url, R.drawable.p37));
        Gamelist.add(new Games("Jelly Slice ", quezop_url, R.drawable.p38));
        Gamelist.add(new Games(" Cyberfusion", quezop_url, R.drawable.p7));
        Gamelist.add(new Games("Slit Sight ", gamezop_url, R.drawable.p29));
        Gamelist.add(new Games("Cowboy vs. Martians ", quezop_url, R.drawable.p1));
        Gamelist.add(new Games("Memory Match Up ", gamezop_url, R.drawable.p2));
        Gamelist.add(new Games("Happy Kittens Puzzle ", quezop_url, R.drawable.p4));
        Gamelist.add(new Games("Oh Yes", gamezop_url, R.drawable.p5));
        Gamelist.add(new Games("Mirror Me ", quezop_url, R.drawable.p6));
        Gamelist.add(new Games("Robotion ", gamezop_url, R.drawable.p8));
        Gamelist.add(new Games(" Loco Motive", quezop_url, R.drawable.p9));
        Gamelist.add(new Games("Salazar ", gamezop_url, R.drawable.p10));
        Gamelist.add(new Games(" Fancy Diver", quezop_url, R.drawable.p11));
        Gamelist.add(new Games("Blackbeard's Island", gamezop_url, R.drawable.p12));
        Gamelist.add(new Games(" Veggi Rabbit", quezop_url, R.drawable.p13));
        Gamelist.add(new Games("Tower Loot ", gamezop_url, R.drawable.p14));
        Gamelist.add(new Games("Swipe Art Puzzle", quezop_url, R.drawable.p15));
        Gamelist.add(new Games("Laser Locked ", gamezop_url, R.drawable.p16));
        Gamelist.add(new Games("Pixel Slime ", quezop_url, R.drawable.p17));
        Gamelist.add(new Games(" Attention Span", gamezop_url, R.drawable.p18));
        Gamelist.add(new Games("Alien Kindergarten ", quezop_url, R.drawable.p19));
        Gamelist.add(new Games("Box Crush ", gamezop_url, R.drawable.p20));
        Gamelist.add(new Games("Pop Soap ", quezop_url, R.drawable.p21));
        Gamelist.add(new Games("Jello Go Round ", gamezop_url, R.drawable.p22));
        Gamelist.add(new Games(" Rescue Juliet", quezop_url, R.drawable.p23));
        Gamelist.add(new Games("1212 ", gamezop_url, R.drawable.p24));
        Gamelist.add(new Games(" Quiz Champions", quezop_url, R.drawable.p25));
        Gamelist.add(new Games("Jelly Doods ", gamezop_url, R.drawable.p26));
        Gamelist.add(new Games(" Teleporting Kittens", quezop_url, R.drawable.p27));
        Gamelist.add(new Games(" Countdown Calculator", gamezop_url, R.drawable.p28));
        Gamelist.add(new Games("Oh No", quezop_url, R.drawable.p30));
        Gamelist.add(new Games("Drop Me ", gamezop_url, R.drawable.p31));
        Gamelist.add(new Games("High or Low ", quezop_url, R.drawable.p32));
        Gamelist.add(new Games("Cubes Got Moves ", gamezop_url, R.drawable.p33));
        Gamelist.add(new Games("Sudoku Classic ", quezop_url, R.drawable.p34));
        Gamelist.add(new Games(" Nut Physics", gamezop_url, R.drawable.p35));
        Gamelist.add(new Games(" Aquatic Rescue", quezop_url, R.drawable.p36));
        Gamelist.add(new Games("Juicy Dash", gamezop_url, R.drawable.p39));
        Gamelist.add(new Games("Rodeo Rider ", quezop_url, R.drawable.s22));
        Gamelist.add(new Games("Rafting Adventure ", gamezop_url, R.drawable.s23));
        Gamelist.add(new Games(" Basket Champs", quezop_url, R.drawable.s1));
        Gamelist.add(new Games(" Flappy Foot Chinko", gamezop_url, R.drawable.s2));
        Gamelist.add(new Games("Let's Go Fishing ", quezop_url, R.drawable.s3));
        Gamelist.add(new Games(" Groovy Ski", gamezop_url, R.drawable.s7));
        Gamelist.add(new Games(" Dribble Kings", quezop_url, R.drawable.s5));
        Gamelist.add(new Games(" Homerun Hit", gamezop_url, R.drawable.s6));
        Gamelist.add(new Games("Quack Hunt ", quezop_url, R.drawable.s4));
        Gamelist.add(new Games("Super Goalie Auditions ", gamezop_url, R.drawable.s8));
        Gamelist.add(new Games(" Furious Speed", quezop_url, R.drawable.s9));
        Gamelist.add(new Games(" Skater Dude", gamezop_url, R.drawable.s10));
        Gamelist.add(new Games("Basketball Master ", quezop_url, R.drawable.s11));
        Gamelist.add(new Games("Foot Chinko ", gamezop_url, R.drawable.s12));
        Gamelist.add(new Games("Lane Battles ", quezop_url, R.drawable.s13));
        Gamelist.add(new Games(" Table Tennis Shots", gamezop_url, R.drawable.s14));
        Gamelist.add(new Games("Kickin It ", quezop_url, R.drawable.s15));
        Gamelist.add(new Games("Hats Off ", gamezop_url, R.drawable.s16));
        Gamelist.add(new Games("Bowling Stars ", quezop_url, R.drawable.s17));
        Gamelist.add(new Games(" City Cricket Battles", gamezop_url, R.drawable.s18));
        Gamelist.add(new Games(" Minigolf Kingdom", quezop_url, R.drawable.s19));
        Gamelist.add(new Games(" Soccer Jerks", gamezop_url, R.drawable.s20));
        Gamelist.add(new Games("Cricket Gunda ", quezop_url, R.drawable.s21));
        Gamelist.add(new Games(" Mafia Billiard Tricks", gamezop_url, R.drawable.s24));
        Gamelist.add(new Games("Clay Pigeon: Tap and Shoot ", quezop_url, R.drawable.s25));
        Gamelist.add(new Games("Bubble Wipeout ", gamezop_url, R.drawable.t9));
        Gamelist.add(new Games("Yummy Taco ", quezop_url, R.drawable.t18));
        Gamelist.add(new Games("Hex Burst ", gamezop_url, R.drawable.t39));
        Gamelist.add(new Games(" Save Your Pinky", quezop_url, R.drawable.t17));
        Gamelist.add(new Games("Ship It Up! ", gamezop_url, R.drawable.t12));
        Gamelist.add(new Games("Kingdom Fight ", quezop_url, R.drawable.t1));
        Gamelist.add(new Games("Tic Tac Toe ", gamezop_url, R.drawable.t3));
        Gamelist.add(new Games("Snack Time ", quezop_url, R.drawable.t2));
        Gamelist.add(new Games("Craigen Stones ", gamezop_url, R.drawable.t4));
        Gamelist.add(new Games(" Cute Towers 2", quezop_url, R.drawable.t5));
        Gamelist.add(new Games(" Monsterjong", gamezop_url, R.drawable.t6));
        Gamelist.add(new Games("Chess Grandmaster ", quezop_url, R.drawable.t7));
        Gamelist.add(new Games("Spider Solitaire ", gamezop_url, R.drawable.t10));
        Gamelist.add(new Games("Omit Orange 2", quezop_url, R.drawable.t11));
        Gamelist.add(new Games("Brick Plunge ", gamezop_url, R.drawable.t13));
        Gamelist.add(new Games("Crazy Pizza ", quezop_url, R.drawable.t14));
        Gamelist.add(new Games("Illuminate ", gamezop_url, R.drawable.t16));
        Gamelist.add(new Games(" Save Your Pinky", quezop_url, R.drawable.t17));
        Gamelist.add(new Games(" Zigzag Clash", gamezop_url, R.drawable.t19));
        Gamelist.add(new Games(" Where's the Ace?", quezop_url, R.drawable.t20));
        Gamelist.add(new Games("Time Warp ", quezop_url, R.drawable.t21));
        Gamelist.add(new Games(" Battleships Armada", gamezop_url, R.drawable.t22));
        Gamelist.add(new Games("Jelly Bears ", quezop_url, R.drawable.t23));
        Gamelist.add(new Games("Hansel & Gretel ", gamezop_url, R.drawable.t24));
        Gamelist.add(new Games("Little Bouncing Guys ", quezop_url, R.drawable.t25));
        Gamelist.add(new Games(" Tiny Tripper", gamezop_url, R.drawable.t26));
        Gamelist.add(new Games("Pirate's Pillage! Aye! Aye! ", quezop_url, R.drawable.t27));
        Gamelist.add(new Games("Pixel Brothers ", gamezop_url, R.drawable.t29));
        Gamelist.add(new Games(" Let Me Grow", quezop_url, R.drawable.t30));
        Gamelist.add(new Games("Junior Chess ", gamezop_url, R.drawable.t31));
        Gamelist.add(new Games("Traffic Command", quezop_url, R.drawable.t32));
        Gamelist.add(new Games(" Road Safety", gamezop_url, R.drawable.t34));
        Gamelist.add(new Games("Greedy Gnomes ", quezop_url, R.drawable.t35));
        Gamelist.add(new Games("Coin Grab ", gamezop_url, R.drawable.t36));
        Gamelist.add(new Games("Pebble Boy ", quezop_url, R.drawable.t37));
        Gamelist.add(new Games("Cheat Spidy ", gamezop_url, R.drawable.t38));
        Gamelist.add(new Games(" Feed The Figures 2", quezop_url, R.drawable.t40));
        Gamelist.add(new Games(" Hex Burst", gamezop_url, R.drawable.t41));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        String mygameurl = sharedPreferences.getString("gamezop_url", "");
        GamesAdapter blueGamesAdapter = new GamesAdapter(this, mygameurl, Gamelist);
        recyclerView.setAdapter(blueGamesAdapter);
    }
}