package net.devcamp.animewatch.API;

import net.devcamp.animewatch.BuildConfig;

public class AnimeWatchAPI {
    public String getHariRilis(String string) {
        String urlHariRilis = "hari_rilis/";
        String hariRilis = BuildConfig.SERVER + urlHariRilis + string;

        return hariRilis;
    }
    public String getHome(String string){
        String urlHome = "home/";
        String home = BuildConfig.SERVER + urlHome +string;
        return home;
    }
}
