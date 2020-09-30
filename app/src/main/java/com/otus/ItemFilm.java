package com.otus;

public class ItemFilm {

    public String title;
    public String description;
    public String photoName;
    public boolean isFavorite;

    public ItemFilm(String title, String description, String photoName) {
        this.title = title;
        this.description = description;
        this.photoName = photoName;
        isFavorite = false;
    }

    public ItemFilm(String title, String description, String photoName, Boolean isFavorite) {
        this.title = title;
        this.description = description;
        this.photoName = photoName;
        this.isFavorite = isFavorite;
    }
}
