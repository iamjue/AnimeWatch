package net.devcamp.animewatch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.devcamp.animewatch.API.AnimeWatchAPI;
import net.devcamp.animewatch.Adapter.JadwalAdapter;
import net.devcamp.animewatch.Model.AnimewatchItem;
import net.devcamp.animewatch.Presenter.AnimewatchPresenter;
import net.devcamp.animewatch.View.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JadwalFragment extends Fragment implements MainView {
    RecyclerView rvJadwalHari;
    Context context;
    AnimewatchPresenter animewatchPresenter;
    JadwalAdapter jadwalAdapter;
    AnimeWatchAPI animeWatchAPI;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_jadwal, container, false);

        rvJadwalHari = view.findViewById(R.id.rv_jadwal_hari);
        showGridJadwal();

        return view;
    }

    public void showGridJadwal() {
//        jadwalAdapter = new JadwalAdapter(this);
//        animeWatchAPI = new AnimeWatchAPI();
//        rvJadwalHari.setLayoutManager(new GridLayoutManager(context, 3));
//        JadwalAdapter jadwalAdapter = new JadwalAdapter(JadwalFragment.this);
//        rvJadwalHari.setAdapter(jadwalAdapter);
//        animewatchPresenter = new AnimewatchPresenter(this, animeWatchAPI, this);
//        animewatchPresenter.AnimewatchLoad();
    }

    @Override
    public void showAnimewatch(ArrayList<AnimewatchItem> animewatchItem) {
        jadwalAdapter.setAnimewatchItems(animewatchItem);
        rvJadwalHari.setAdapter(jadwalAdapter);
        jadwalAdapter.notifyDataSetChanged();

    }
}
