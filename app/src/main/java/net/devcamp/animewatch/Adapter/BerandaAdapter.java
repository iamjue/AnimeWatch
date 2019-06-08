package net.devcamp.animewatch.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.devcamp.animewatch.BerandaFragment;
import net.devcamp.animewatch.Model.AnimewatchBerandaItem;
import net.devcamp.animewatch.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BerandaAdapter extends RecyclerView.Adapter<BerandaAdapter.BerandaViewHolder> {
    private Fragment fragment;
    private BerandaFragment context;
    private ArrayList<AnimewatchBerandaItem>animewatchBerandaItems;

    public ArrayList<AnimewatchBerandaItem> getAnimewatchBerandaItems() {
        return animewatchBerandaItems;
    }

    public void setAnimewatchBerandaItems(ArrayList<AnimewatchBerandaItem> animewatchBerandaItems) {
        this.animewatchBerandaItems = animewatchBerandaItems;
    }

    public BerandaAdapter(BerandaFragment context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BerandaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_beranda, viewGroup, false);
        return new BerandaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BerandaViewHolder berandaViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class BerandaViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_id)
        TextView tvId;
        @BindView(R.id.img_cardview_list_hariIni)
        ImageView imgCardviewListHariIni;
        @BindView(R.id.tv_judul_list_hariIni)
        TextView tvJudulListHariIni;
        @BindView(R.id.tv_genre_list_hariIni)
        TextView tvGenreListHariIni;
        @BindView(R.id.tv_jumlah_views_list)
        TextView tvJumlahViewsList;

        public BerandaViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
