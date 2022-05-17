package com.guideforwinjo.winzogoldwin.tipswinzo.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadQureka;

public class PagerAdapter extends androidx.viewpager.widget.PagerAdapter {

    Activity activity;
    int[] qurekabanner;

    public PagerAdapter(Activity activity, int[] qurekabanner) {
        this.activity = activity;
        this.qurekabanner = qurekabanner;
    }

    @Override
    public int getCount() {
        return qurekabanner.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(activity).inflate(R.layout.qureka_items_layout, container, false);

        ImageView image = view.findViewById(R.id.image);

        image.setImageResource(qurekabanner[position]);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadQureka.Qreka(activity);
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
