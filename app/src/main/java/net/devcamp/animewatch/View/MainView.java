package net.devcamp.animewatch.View;

import net.devcamp.animewatch.Model.AnimewatchItem;
import net.devcamp.animewatch.Model.GenreItem;

import java.util.ArrayList;

public interface MainView {
    void showAnimewatch(ArrayList<AnimewatchItem>animewatchItem);
    void showGenre (ArrayList<GenreItem>genreItem);
//    void showGenre(ArrayList<HariGenre>hariGenre);
}
