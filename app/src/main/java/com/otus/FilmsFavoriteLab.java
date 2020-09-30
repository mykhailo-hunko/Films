package com.otus;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class FilmsFavoriteLab {

    private static List<ItemFilm> items = new ArrayList<>();

    private static FilmsFavoriteLab instance;

    private FilmsFavoriteLab(Context context) {


    }

    public static FilmsFavoriteLab getInstance(Context context) {
        if (instance == null) {
            instance = new FilmsFavoriteLab(context);
        }

        return instance;
    }

    public static List<ItemFilm> getItems() {
        return items;
    }

    public static void Adding(String title, String desc, String photoName) {
        items.add(new ItemFilm(title,desc,photoName,true));
    }
    public static void Delete(String title) {
        if(items.size() != 0) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).title == title) {
                    items.remove(i);
                }

            }
        }
    }


}
