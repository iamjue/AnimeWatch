package net.devcamp.animewatch.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.devcamp.animewatch.GenreFragment;
import net.devcamp.animewatch.IsiListGenreFragment;
import net.devcamp.animewatch.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {
    private GenreFragment context;

    public GenreAdapter(GenreFragment context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gird_genre, viewGroup, false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder genreViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
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
