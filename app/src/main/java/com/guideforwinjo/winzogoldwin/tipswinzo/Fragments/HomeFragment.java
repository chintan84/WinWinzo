package com.guideforwinjo.winzogoldwin.tipswinzo.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.R;
import com.guideforwinjo.winzogoldwin.tipswinzo.Adapter.DashBoardAdapter;
import com.guideforwinjo.winzogoldwin.tipswinzo.Model.Category;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<Category> arrayList = new ArrayList<>();

        arrayList.add(new Category("Play & Win\nCoins",R.drawable.q2,R.drawable.bg1));
        arrayList.add(new Category("Atme\nGame",R.drawable.atm,R.drawable.bg2));
        arrayList.add(new Category("GameZop\nGames",R.drawable.logo,R.drawable.bg3));
        arrayList.add(new Category("Tips for\nWinzo Games",R.mipmap.ic_launcher,R.drawable.bg4));
        arrayList.add(new Category("All Latest\nGames",R.drawable.all,R.drawable.bg5));
        arrayList.add(new Category("Action\nGames",R.drawable.action,R.drawable.bg6));
        arrayList.add(new Category("Popular\nGames",R.drawable.popular,R.drawable.bg7));
        arrayList.add(new Category("Multiplayer\nGames",R.drawable.multi,R.drawable.bg8));
        arrayList.add(new Category("Best Puzzle\nGames",R.drawable.puzzle,R.drawable.bg9));
        arrayList.add(new Category("Advanture\nGames",R.drawable.adventue,R.drawable.bg1));
        arrayList.add(new Category("Simulator\nGames",R.drawable.simulator,R.drawable.bg2));
        arrayList.add(new Category("Air Fight\nGames",R.drawable.air,R.drawable.bg3));
        arrayList.add(new Category("3D\nGames",R.drawable.thred,R.drawable.bg4));
        arrayList.add(new Category("Girl Dressup\nGames",R.drawable.girls,R.drawable.bg5));
        arrayList.add(new Category("Zombie\nGames",R.drawable.zombie,R.drawable.bg6));
        arrayList.add(new Category("Racing\nGames",R.drawable.racing,R.drawable.bg7));
        arrayList.add(new Category("Sports\nGames",R.drawable.sports,R.drawable.bg8));
        arrayList.add(new Category("Animals\nGames",R.drawable.animal,R.drawable.bg9));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        DashBoardAdapter blueDashBoardAdapter = new DashBoardAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(blueDashBoardAdapter);

        return view;
    }
}