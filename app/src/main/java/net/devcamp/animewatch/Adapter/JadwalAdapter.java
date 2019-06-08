package net.devcamp.animewatch.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.devcamp.animewatch.JadwalFragment;
import net.devcamp.animewatch.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder> {
    private JadwalFragment contex;

    public JadwalAdapter(JadwalFragment contex) {
        this.contex = contex;
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gird_hari, viewGroup, false);
        return new JadwalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder jadwalViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 7;
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
