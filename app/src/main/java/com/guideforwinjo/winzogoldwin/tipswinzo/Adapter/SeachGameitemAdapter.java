package com.guideforwinjo.winzogoldwin.tipswinzo.Adapter;

import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.VideoChat_Qureka;
import com.guideforwinjo.winzogoldwin.tipswinzo.Model.Games;
import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity;
import com.guideforwinjo.winzogoldwin.tipswinzo.Tab.LoadCustom;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.guideforwinjo.winzogoldwin.tipswinzo.First.FirstActivity.sharedPreferences;

public class SeachGameitemAdapter extends RecyclerView.Adapter<SeachGameitemAdapter.ViewHolder> {
    private Activity activity;
    private ArrayList<Games> mData;
    private List<Games> originalItems;

    public SeachGameitemAdapter(ArrayList<Games> arrayList, Activity activity) {
        this.mData = arrayList;
        this.activity = activity;
        ArrayList arrayList2 = new ArrayList();
        this.originalItems = arrayList2;
        arrayList2.addAll(arrayList);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_list_row, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.tv_book_title.setText(this.mData.get(i).getTitle());
        viewHolder.img_book_thumbnail.setImageResource(this.mData.get(i).getThumbnail());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String mygameurl = sharedPreferences.getString("gamezop_url", "");
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

    public void filter(String str) {
        if (str.length() == 0) {
            this.mData.clear();
            this.mData.addAll(this.originalItems);
        } else if (Build.VERSION.SDK_INT >= 24) {
            this.mData.clear();
            this.mData.addAll((List) this.originalItems.stream().filter(new Predicate() {
                public final boolean test(Object obj) {
                    return ((Games) obj).getTitle().toLowerCase().contains(str.toLowerCase());
                }
            }).collect(Collectors.toList()));
        } else {
            this.mData.clear();
            for (Games blueGames : this.originalItems) {
                if (blueGames.getTitle().toLowerCase().contains(str.toLowerCase())) {
                    this.mData.add(blueGames);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView img_book_thumbnail;
        TextView tv_book_title;

        public ViewHolder(View view) {
            super(view);
            this.tv_book_title = (TextView) view.findViewById(R.id.book_title_id);
            this.img_book_thumbnail = (ImageView) view.findViewById(R.id.book_img_id);
        }
    }
}
