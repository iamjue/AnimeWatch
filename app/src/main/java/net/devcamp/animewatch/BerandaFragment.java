package net.devcamp.animewatch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import net.devcamp.animewatch.API.AnimeWatchAPI;
import net.devcamp.animewatch.Adapter.BerandaAdapter;
import net.devcamp.animewatch.Model.AnimewatchBerandaItem;
import net.devcamp.animewatch.Presenter.BerandaPresenter;
import net.devcamp.animewatch.View.MainView;
import net.devcamp.animewatch.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class  BerandaFragment extends Fragment {
    RecyclerView rvBeranda;
    List<AnimewatchBerandaItem> animewatchBerandaItem = new ArrayList<>();
    BerandaAdapter berandaAdapter;
    Context context;
    private static final String TAG = BerandaFragment.class.getSimpleName();

    public static BerandaFragment newInstance(){
        return new  BerandaFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_beranda, container, false);

        rvBeranda = view.findViewById(R.id.rv_list_beranda);

        rvBeranda.setLayoutManager(new LinearLayoutManager(context));
        BerandaAdapter berandaAdapter  = new BerandaAdapter(BerandaFragment.this);
        rvBeranda.setAdapter(berandaAdapter);

        return view;
    }



}
