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
import net.devcamp.animewatch.Adapter.GenreAdapter;
import net.devcamp.animewatch.Model.AnimewatchItem;
import net.devcamp.animewatch.Model.GenreItem;
import net.devcamp.animewatch.Presenter.AnimewatchPresenter;
import net.devcamp.animewatch.Presenter.GenrePresenter;
import net.devcamp.animewatch.View.MainView;

import java.util.ArrayList;
import java.util.List;

public class GenreFragment extends Fragment implements MainView {
    RecyclerView rvGenre;;
    ArrayList<GenreItem>genreItem= new ArrayList<>();
    GenrePresenter genrePresenter;
    GenreAdapter genreAdapter;
    AnimeWatchAPI animeWatchAPI;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_genre, container, false);

        rvGenre = view.findViewById(R.id.rv_genre);


        tampilGenre();
        return view;
    }

    private void tampilGenre() {
        genreAdapter = new GenreAdapter(this);
        animeWatchAPI = new AnimeWatchAPI();
        rvGenre.setLayoutManager(new GridLayoutManager(context, 3));
        GenreAdapter genreAdapter = new GenreAdapter(GenreFragment.this);
        rvGenre.setAdapter(genreAdapter);
        genrePresenter = new GenrePresenter(this,animeWatchAPI,this);
        genrePresenter.GenreLoad();
    }

    @Override
    public void showAnimewatch(ArrayList<AnimewatchItem> animewatchItem) {

    }

    @Override
    public void showGenre(ArrayList<GenreItem> genreItem) {
        genreAdapter.setGenreItems(genreItem);
        rvGenre.setAdapter(genreAdapter);
        genreAdapter.notifyDataSetChanged();


    }
}
