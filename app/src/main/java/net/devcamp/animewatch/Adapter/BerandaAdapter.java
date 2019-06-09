package net.devcamp.animewatch.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.devcamp.animewatch.BerandaFragment;
import net.devcamp.animewatch.Model.AnimewatchItem;
import net.devcamp.animewatch.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BerandaAdapter extends RecyclerView.Adapter<BerandaAdapter.BerandaViewHolder> {
    private BerandaFragment berandaFragment;
    private ArrayList<AnimewatchItem> animewatchItems = new ArrayList<>();
    Context context;

    public BerandaAdapter(BerandaFragment berandaFragment) {
        this.berandaFragment = berandaFragment;
    }

    public BerandaFragment getBerandaFragment() {
        return berandaFragment;
    }

    public void setBerandaFragment(BerandaFragment berandaFragment) {
        this.berandaFragment = berandaFragment;
    }

    public ArrayList<AnimewatchItem> getAnimewatchItems() {
        return animewatchItems;
    }

    public void setAnimewatchItems(ArrayList<AnimewatchItem> animewatchItems) {
        this.animewatchItems = animewatchItems;
    }

    public BerandaAdapter(BerandaFragment berandaFragment, ArrayList<AnimewatchItem> animewatchItems) {
        this.berandaFragment = berandaFragment;
        this.animewatchItems = animewatchItems;
    }

    @NonNull
    @Override
    public BerandaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_beranda, viewGroup, false);
        return new BerandaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BerandaViewHolder berandaViewHolder, int i) {
        berandaViewHolder.tvJudulListHariIni.setText(getAnimewatchItems().get(i).getJudul());
        berandaViewHolder.tvGenreListHariIni.setText(getAnimewatchItems().get(i).getGenre());
        berandaViewHolder.tvId.setText(getAnimewatchItems().get(i).getId());
        berandaViewHolder.tvJumlahViewsList.setText(getAnimewatchItems().get(i).getJumlah_tayang()+" Views");
        Glide.with(getBerandaFragment().getActivity())
                .load(getAnimewatchItems().get(i).getGambar())
                .into(berandaViewHolder.imgCardviewListHariIni);
    }

    @Override
    public int getItemCount() {
        return getAnimewatchItems().size();
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
