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
import net.devcamp.animewatch.JadwalFragment;
import net.devcamp.animewatch.Model.AnimewatchItem;
import net.devcamp.animewatch.View.MainView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AnimewatchPresenter {
    MainView view;
    StringRequest stringRequest;
    AnimeWatchAPI animeWatchAPI;
    BerandaFragment context;


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

    public BerandaFragment getContext() {
        return context;
    }

    public void setContext(BerandaFragment context) {
        this.context = context;
    }

    public AnimewatchPresenter(MainView view, AnimeWatchAPI animeWatchAPI, BerandaFragment context) {
        this.view = view;
        this.animeWatchAPI = animeWatchAPI;
        this.context = context;
    }

    public void AnimewatchLoad(){
        String Url = animeWatchAPI.getHome();
        final ArrayList<AnimewatchItem>animewatchItems = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray animewatchArray = object.getJSONArray("animewatch");
                    for (int i = 0; i < animewatchArray.length(); i++) {
                        JSONObject animewatchObject = animewatchArray.getJSONObject(i);
                        AnimewatchItem animewatchItem = new AnimewatchItem(
                                animewatchObject.getString("id"),
                                animewatchObject.getString("judul"),
                                animewatchObject.getString("genre"),
                                animewatchObject.getString("hari_rilis"),
                                animewatchObject.getString("gambar"),
                                animewatchObject.getString("video"),
                                animewatchObject.getString("deskripsi"),
                                animewatchObject.getString("jumlah_download"),
                                animewatchObject.getString("jumlah_tayang")
                        );
                        animewatchItems.add(animewatchItem);
                    }
                    view.showAnimewatch(animewatchItems);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText( getContext().getActivity(), "Error", Toast.LENGTH_SHORT ).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue( getContext().getActivity() );
        requestQueue.add( stringRequest );
    }
}
