package net.devcamp.animewatch.Presenter;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.devcamp.animewatch.API.AnimeWatchAPI;
import net.devcamp.animewatch.GenreFragment;
import net.devcamp.animewatch.Model.AnimewatchItem;
import net.devcamp.animewatch.Model.GenreItem;
import net.devcamp.animewatch.View.MainView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GenrePresenter {
    MainView mainView;
    StringRequest stringRequest;
    AnimeWatchAPI animeWatchAPI;
    GenreFragment context;

    public MainView getMainView() {
        return mainView;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
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

    public GenreFragment getContext() {
        return context;
    }

    public void setContext(GenreFragment context) {
        this.context = context;
    }

    public GenrePresenter(MainView mainView, AnimeWatchAPI animeWatchAPI, GenreFragment context) {
        this.mainView = mainView;
        this.animeWatchAPI = animeWatchAPI;
        this.context = context;
    }
    public void GenreLoad(){
        String Url = animeWatchAPI.getGenre();
        final ArrayList<GenreItem> genreItems = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray genreArray = object.getJSONArray("animewatch_genre");
                    for (int i = 0; i < genreArray.length(); i++) {
                        JSONObject genreObject = genreArray.getJSONObject(i);
                        GenreItem genreItem = new GenreItem(
                                genreObject.getString("id"),
                                genreObject.getString("genre")
                        );
                        genreItems.add(genreItem);
                    }
                    mainView.showGenre(genreItems);
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
