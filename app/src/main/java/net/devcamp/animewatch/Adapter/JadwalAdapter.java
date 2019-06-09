package net.devcamp.animewatch.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bumptech.glide.Glide;

import net.devcamp.animewatch.JadwalFragment;
import net.devcamp.animewatch.Model.AnimewatchItem;
import net.devcamp.animewatch.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder> {
    private JadwalFragment jadwalFragment;
    private ArrayList<AnimewatchItem>animewatchItems= new ArrayList<>();

    public JadwalAdapter(JadwalFragment jadwalFragment) {
    }

    public JadwalFragment getJadwalFragment() {
        return jadwalFragment;
    }

    public void setJadwalFragment(JadwalFragment jadwalFragment) {
        this.jadwalFragment = jadwalFragment;
    }

    public ArrayList<AnimewatchItem> getAnimewatchItems() {
        return animewatchItems;
    }

    public void setAnimewatchItems(ArrayList<AnimewatchItem> animewatchItems) {
        this.animewatchItems = animewatchItems;
    }

    public JadwalAdapter(JadwalFragment jadwalFragment, ArrayList<AnimewatchItem> animewatchItems) {
        this.jadwalFragment = jadwalFragment;
        this.animewatchItems = animewatchItems;
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gird_hari, viewGroup, false);
        return new JadwalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder jadwalViewHolder, int i) {
        jadwalViewHolder.btnHari.setText(getAnimewatchItems().get(i).getHari_rilis());

    }

    @Override
    public int getItemCount() {
        return getAnimewatchItems().size();
    }

    public class JadwalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_hari)
        Button btnHari;
        public JadwalViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
