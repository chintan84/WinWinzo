package com.guideforwinjo.winzogoldwin.tipswinzo.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.VideoChat_Qureka;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Model.Games;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadCustom;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.MyViewHolder> {
    private Activity activity;
    private List<Games> mData;
    String mygameurl;

    public GamesAdapter(Activity activity, String mygameurl, List<Games> list) {
        this.activity = activity;
        this.mData = list;
        this.mygameurl = mygameurl;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(activity).inflate(R.layout.game_list_row, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        myViewHolder.tv_book_title.setText(this.mData.get(i).getTitle().trim());
        myViewHolder.img_book_thumbnail.setImageResource(this.mData.get(i).getThumbnail());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if (FirstActivity.sharedPreferences.getString("check_earningmode", "").equalsIgnoreCase("on")) {
                    int cnt = FirstActivity.sharedPreferences.getInt("cnt", 0);
                    if (cnt % 2 == 0) {
                        cnt++;
                        FirstActivity.editor.putInt("cnt", cnt);
                        FirstActivity.editor.commit();
                        LoadCustom.myCustom(activity, mygameurl);
                    } else {
                        cnt++;
                        FirstActivity.editor.putInt("cnt", cnt);
                        FirstActivity.editor.commit();
                        VideoChat_Qureka.qureka(activity);
                    }
                } else {
                    VideoChat_Qureka.qureka(activity);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_book_thumbnail;
        TextView tv_book_title;

        public MyViewHolder(View view) {
            super(view);
            this.tv_book_title = (TextView) view.findViewById(R.id.book_title_id);
            this.img_book_thumbnail = (ImageView) view.findViewById(R.id.book_img_id);
        }
    }
}
