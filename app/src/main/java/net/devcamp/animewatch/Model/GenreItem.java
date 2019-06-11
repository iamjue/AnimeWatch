package net.devcamp.animewatch.Model;

public class GenreItem {
    String id, genre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public GenreItem(String id, String genre) {
        this.id = id;
        this.genre = genre;
    }
}
