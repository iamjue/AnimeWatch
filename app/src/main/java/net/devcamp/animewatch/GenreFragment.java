package net.devcamp.animewatch;

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

import net.devcamp.animewatch.Adapter.GenreAdapter;

public class GenreFragment extends Fragment {
    RecyclerView rvGenre;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_genre, container, false);

        rvGenre = view.findViewById(R.id.rv_genre);

        rvGenre.setLayoutManager(new GridLayoutManager(context, 3));
        GenreAdapter genreAdapter = new GenreAdapter(GenreFragment.this);
        rvGenre.setAdapter(genreAdapter);
        return view;
    }
}
