package net.devcamp.animewatch.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.devcamp.animewatch.BerandaFragment;
import net.devcamp.animewatch.GenreFragment;
import net.devcamp.animewatch.IsiListGenreFragment;
import net.devcamp.animewatch.Model.AnimewatchItem;
import net.devcamp.animewatch.Model.GenreItem;
import net.devcamp.animewatch.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {
    private GenreFragment genreFragment;
    private ArrayList<GenreItem> genreItems = new ArrayList<>();

    public GenreAdapter(GenreFragment genreFragment, ArrayList<GenreItem> genreItems) {
        this.genreFragment = genreFragment;
        this.genreItems = genreItems;
    }

    public GenreAdapter(GenreFragment genreFragment) {
        this.genreFragment = genreFragment;
    }

    public GenreFragment getGenreFragment() {
        return genreFragment;
    }

    public void setGenreFragment(GenreFragment genreFragment) {
        this.genreFragment = genreFragment;
    }

    public ArrayList<GenreItem> getGenreItems() {
        return genreItems;
    }

    public void setGenreItems(ArrayList<GenreItem> genreItems) {
        this.genreItems = genreItems;
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gird_genre, viewGroup, false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder genreViewHolder, int i) {
        genreViewHolder.btnGenre.setText(getGenreItems().get(i).getGenre());

    }

    @Override
    public int getItemCount() {
        return getGenreItems().size();
    }

    public class GenreViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_genre)
        Button btnGenre;
        public GenreViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
