package net.devcamp.animewatch.API;

import net.devcamp.animewatch.BuildConfig;

public class AnimeWatchAPI {
    public String getHariRilis(String string) {
        String urlHariRilis = "hari_rilis/";
        String hariRilis = BuildConfig.SERVER + urlHariRilis + string;

        return hariRilis;
    }
    public String getHome(){
//        String urlHome = "home";
        String home = "https://cucusadewa0294.000webhostapp.com/animewatch/animewatch/api/home/listanime.php";
        return home;
    }
}
