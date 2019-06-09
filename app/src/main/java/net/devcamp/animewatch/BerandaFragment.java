package net.devcamp.animewatch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.devcamp.animewatch.API.AnimeWatchAPI;
import net.devcamp.animewatch.Adapter.BerandaAdapter;
import net.devcamp.animewatch.Adapter.JadwalAdapter;
import net.devcamp.animewatch.Model.AnimewatchItem;
import net.devcamp.animewatch.Presenter.AnimewatchPresenter;
import net.devcamp.animewatch.View.MainView;

import java.util.ArrayList;
import java.util.List;

public class  BerandaFragment extends Fragment implements MainView {
    RecyclerView rvBeranda;
    List<AnimewatchItem> animewatchItem = new ArrayList<>();
    AnimewatchPresenter animewatchPresenter;
    BerandaAdapter berandaAdapter;
    AnimeWatchAPI animeWatchAPI;
    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_beranda, container, false);

        rvBeranda = view.findViewById(R.id.rv_list_beranda);

        showBeranda();

        return view;
    }
    public void showBeranda() {
        berandaAdapter = new BerandaAdapter(this);
        animeWatchAPI = new AnimeWatchAPI();
        rvBeranda.setLayoutManager(new LinearLayoutManager(context));
        BerandaAdapter berandaAdapter  = new BerandaAdapter(BerandaFragment.this);
        rvBeranda.setAdapter(berandaAdapter);
        animewatchPresenter = new AnimewatchPresenter(this, animeWatchAPI, this);
        animewatchPresenter.AnimewatchLoad();
    }

    @Override
    public void showAnimewatch(ArrayList<AnimewatchItem> animewatchItem) {
        berandaAdapter.setAnimewatchItems(animewatchItem);
        rvBeranda.setAdapter(berandaAdapter);
        berandaAdapter.notifyDataSetChanged();

    }
}
