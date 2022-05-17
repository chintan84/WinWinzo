package com.guideforwinjo.winzogoldwin.tipswinzo.ADS;

import android.app.Activity;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LocalAds {

    Activity activity;
    static Ads ads;

    public LocalAds(Activity activity) {
        this.activity = activity;
    }

    public void call_localads_api(RecyclerView moreappslist) {

        ArrayList<AppDetail> localAdsArrayList = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = FirstActivity.sharedPreferences.getString("localad_url", "");

        Volley.newRequestQueue(activity).add(new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jSONArray = new JSONObject(response).getJSONArray("result");
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();

                    if (jSONArray.length() != 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String app_icon = jSONObject.getString("app_icon");
                            String app_name = jSONObject.getString("app_name");
                            String app_url = jSONObject.getString("app_url");
                            arrayList.add(app_icon);
                            arrayList2.add(app_name);
                            arrayList3.add(app_url);
                            AppDetail blueAppDetail = new AppDetail(app_icon, app_name, app_url);
                            localAdsArrayList.add(blueAppDetail);
                        }
                        if (FirstActivity.sharedPreferences.getString("check_localad", "").equalsIgnoreCase("on")) {
                            LocalAdsAdapter blueLocalAdsAdapter = new LocalAdsAdapter(activity, localAdsArrayList);
                            LocalAds.ads = new Ads(activity, arrayList, arrayList2, arrayList3, true);
                            moreappslist.setAdapter(blueLocalAdsAdapter);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }));
    }
}