package com.otus;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class FilmsItemLab {
    private static List<ItemFilm> items = new ArrayList<>();

    private static FilmsItemLab instance;

    private FilmsItemLab(Context context) {
        items.add(new ItemFilm(context.getString(R.string.super_), context.getString(R.string.desc_super), "super1"));
        items.add(new ItemFilm(context.getString(R.string.tenet), context.getString(R.string.desc_tenet), "tenet"));
        items.add(new ItemFilm(context.getString(R.string.shindle), context.getString(R.string.desc_shindle), "shindler"));
        items.add(new ItemFilm(context.getString(R.string.milem), context.getString(R.string.desc_milem), "milen"));
        items.add(new ItemFilm(context.getString(R.string.leave), context.getString(R.string.desc_leave), "leave"));
        items.add(new ItemFilm(context.getString(R.string.green), context.getString(R.string.desc_green), "green"));
        items.add(new ItemFilm(context.getString(R.string.forest), context.getString(R.string.desc_forest), "forest"));
        items.add(new ItemFilm(context.getString(R.string.armine), context.getString(R.string.desc_armine), "armine"));
        items.add(new ItemFilm(context.getString(R.string.after), context.getString(R.string.desc_after), "after"));
        items.add(new ItemFilm(context.getString(R.string.stmilen), context.getString(R.string.desc_stmilen), "stmiilen"));

    }

    public static FilmsItemLab getInstance(Context context) {
        if (instance == null) {
            instance = new FilmsItemLab(context);
        }

        return instance;
    }

    public static List<ItemFilm> getItems() {
        return items;
    }

    public static void Adding(String title, String desc) {
        if(title != null && !title.equals("")) {
            items.add(new ItemFilm(title, desc, ""));
        }
    }
}
