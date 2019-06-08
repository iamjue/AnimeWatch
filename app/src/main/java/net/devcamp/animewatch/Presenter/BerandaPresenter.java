package net.devcamp.animewatch.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.devcamp.animewatch.API.AnimeWatchAPI;
import net.devcamp.animewatch.BerandaFragment;
import net.devcamp.animewatch.Model.AnimewatchBerandaItem;
import net.devcamp.animewatch.View.MainView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BerandaPresenter {
    MainView view;
    StringRequest stringRequest;
    AnimeWatchAPI animeWatchAPI;
    BerandaFragment berandaFragment;
    Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public MainView getView() {
        return view;
    }

    public void setView(MainView view) {
        this.view = view;
    }

    public StringRequest getStringRequest() {
        return stringRequest;
    }

    public void setStringRequest(StringRequest stringRequest) {
        this.stringRequest = stringRequest;
    }

    public AnimeWatchAPI getAnimeWatchAPI() {
        return animeWatchAPI;
    }

    public void setAnimeWatchAPI(AnimeWatchAPI animeWatchAPI) {
        this.animeWatchAPI = animeWatchAPI;
    }

    public BerandaFragment getBerandaFragment() {
        return berandaFragment;
    }

    public void setBerandaFragment(BerandaFragment berandaFragment) {
        this.berandaFragment = berandaFragment;
    }

    public BerandaPresenter(MainView view, AnimeWatchAPI animeWatchAPI, BerandaFragment berandaFragment) {
        this.view = view;
        this.animeWatchAPI = animeWatchAPI;
        this.berandaFragment = berandaFragment;
    }

    public void Load(String string){
        String URL = animeWatchAPI.getHome(string);
        final ArrayList<AnimewatchBerandaItem> animewatchBerandaItems = new ArrayList<>();
        stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray berandaArray = object.getJSONArray("animewatch");
                    for (int i = 0; i < berandaArray.length(); i++) {
                        JSONObject berandaObject = berandaArray.getJSONObject(i);
                        AnimewatchBerandaItem animewatchBerandaItem = new AnimewatchBerandaItem(
                                berandaObject.getString("id"),
                                berandaObject.getString("judul"),
                                berandaObject.getString("genre"),
                                berandaObject.getString("hari_rilis"),
                                berandaObject.getString("gambar"),
                                berandaObject.getString("video"),
                                berandaObject.getString("deskripsi"),
                                berandaObject.getString("jumlah_download"),
                                berandaObject.getString("jumlah_tayang"));
                        animewatchBerandaItems.add(animewatchBerandaItem);

                    }
                    view.showBeranda(animewatchBerandaItems);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText( getBerandaFragment().getContext(), "Error", Toast.LENGTH_SHORT ).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue( getBerandaFragment().getContext() );
        requestQueue.add( stringRequest );
    }
}
