package com.guideforwinjo.winzogoldwin.tipswinzo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.FBPreLoadAds;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Fragments.EarnMoneyFragment;
import com.guideforwinjo.winzogoldwin.tipswinzo.Fragments.HomeFragment;
import com.guideforwinjo.winzogoldwin.tipswinzo.Fragments.PopularFragment;
import com.guideforwinjo.winzogoldwin.tipswinzo.Fragments.ThreeDFragment;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.navigation_game_zop){
                    Intent intent = new Intent(DashBoardActivity.this, earchGameActivity.class);
                    new FBPreLoadAds().ShowParaMeterIntertistialAds(DashBoardActivity.this, intent, FirstActivity.sharedPreferences.getString("check_inter_bottomnav", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
                        public void onAdClicked() {
                        }

                        public void onAdsDismissed() {
                        }

                        public void onAdsFailedToLoad(int i) {
                        }

                        public void onAdsLoaded() {
                        }

                        public void onAllEmpty() {
                        }

                        public void onLoggingImpression() {
                        }
                    });
                }else if (item.getItemId()==R.id.navigation_qureka_lite){
                    new FBPreLoadAds().ShowIntertistialWithFragmentAds(DashBoardActivity.this, getSupportFragmentManager(),new EarnMoneyFragment() , FirstActivity.sharedPreferences.getString("check_inter_bottomnav", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
                        public void onAdClicked() {
                        }

                        public void onAdsDismissed() {
                        }

                        public void onAdsFailedToLoad(int i) {
                        }

                        public void onAdsLoaded() {
                        }

                        public void onAllEmpty() {
                        }

                        public void onLoggingImpression() {
                        }
                    });
                }else if (item.getItemId()==R.id.navigation_home){
                    new FBPreLoadAds().ShowIntertistialWithFragmentAds(DashBoardActivity.this, getSupportFragmentManager(),new HomeFragment() , FirstActivity.sharedPreferences.getString("check_inter_bottomnav", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
                        public void onAdClicked() {
                        }

                        public void onAdsDismissed() {
                        }

                        public void onAdsFailedToLoad(int i) {
                        }

                        public void onAdsLoaded() {
                        }

                        public void onAllEmpty() {
                        }

                        public void onLoggingImpression() {
                        }
                    });
                }else if (item.getItemId()==R.id.navigation_earn_money){
                    new FBPreLoadAds().ShowIntertistialWithFragmentAds(DashBoardActivity.this, getSupportFragmentManager(),new PopularFragment() , FirstActivity.sharedPreferences.getString("check_inter_bottomnav", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
                        public void onAdClicked() {
                        }

                        public void onAdsDismissed() {
                        }

                        public void onAdsFailedToLoad(int i) {
                        }

                        public void onAdsLoaded() {
                        }

                        public void onAllEmpty() {
                        }

                        public void onLoggingImpression() {
                        }
                    });
                }else if (item.getItemId()==R.id.navigation_famobi_games){
                    new FBPreLoadAds().ShowIntertistialWithFragmentAds(DashBoardActivity.this, getSupportFragmentManager(),new ThreeDFragment() , FirstActivity.sharedPreferences.getString("check_inter_bottomnav", ""), new FBPreLoadAds.OnIntertistialAdsListner() {
                        public void onAdClicked() {
                        }

                        public void onAdsDismissed() {
                        }

                        public void onAdsFailedToLoad(int i) {
                        }

                        public void onAdsLoaded() {
                        }

                        public void onAllEmpty() {
                        }

                        public void onLoggingImpression() {
                        }
                    });
                }
                return true;
            }
        });


    }
}