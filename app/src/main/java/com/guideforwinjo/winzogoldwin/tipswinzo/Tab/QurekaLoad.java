package com.guideforwinjo.winzogoldwin.tipswinzo.Tab;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tmall.ultraviewpager.UltraViewPager;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Adapter.PagerAdapter;
import com.guideforwinjo.winzogoldwin.tipswinzo.Activity.layWinAdapter;

import java.util.ArrayList;
import java.util.Random;

public class QurekaLoad {

    public static void loadQureka(Activity activity, RecyclerView qurekalist) {
        if (FirstActivity.sharedPreferences.getString("check_qureka_mode", "").equalsIgnoreCase("on")) {
            int[] qurekaimage = {R.drawable.q1, R.drawable.q2, R.drawable.q3, R.drawable.q11, R.drawable.qq5, R.drawable.q10, R.drawable.q7, R.drawable.q8, R.drawable.q9, R.drawable.q12, R.drawable.q13, R.drawable.q14};

            String[] title = {"GK Quiz", "Win 50000 Coins", "Sport Quiz", "Bollywood Quiz", "Geography Quiz", "Tech Quiz", "Mega Quiz", "IPL Quiz", "History Quiz", "Cricket Quiz", "Tech Quiz", "Mega Skill"};
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<Integer> imageList = new ArrayList<>();
            ArrayList<String> titleList = new ArrayList<>();

            for (int i = 0; i < 12; i++) {
                while (true) {
                    int randomno = new Random().nextInt(12);
                    if (!arrayList.contains(randomno)) {
                        arrayList.add(randomno);
                        break;
                    }
                }
            }

            Log.e("akfsdjkhfjkd", "" + arrayList);

            for (int i = 0; i < 12; i++) {
                imageList.add(qurekaimage[arrayList.get(i)]);
                titleList.add(title[arrayList.get(i)]);
            }

            qurekalist.setVisibility(View.VISIBLE);
            layWinAdapter qurekaAdapter = new layWinAdapter(activity, imageList, titleList);
            qurekalist.setAdapter(qurekaAdapter);
        }
    }

    public static void loadQurekaPagerAdapter(Activity activity, CardView cardView, UltraViewPager ultraViewPager) {
        if (FirstActivity.sharedPreferences.getString("check_qureka_mode", "").equalsIgnoreCase("on")) {

            int[] qurekabanner = {R.drawable.largebannerqureka1, R.drawable.largebannerqureka2, R.drawable.largebannerqureka3, R.drawable.largebannerqureka4, R.drawable.largebannerqureka5, R.drawable.largebannerqureka6};

            cardView.setVisibility(View.VISIBLE);

            ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
            androidx.viewpager.widget.PagerAdapter adapter = new PagerAdapter(activity, qurekabanner);
            ultraViewPager.setAdapter(adapter);

            ultraViewPager.initIndicator();
            ultraViewPager.getIndicator()
                    .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                    .setFocusColor(activity.getResources().getColor(R.color.colorAccent))
                    .setNormalColor(Color.WHITE)
                    .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, activity.getResources().getDisplayMetrics()));
            ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
            ultraViewPager.getIndicator().setMargin(0, 0, 0, 15);
            ultraViewPager.getIndicator().build();

            ultraViewPager.setInfiniteLoop(true);
            ultraViewPager.setAutoScroll(2500);
        }
    }
}
