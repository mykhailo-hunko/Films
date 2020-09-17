package com.otus;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class FilmsItemLab
{
    private static List<ItemFilm> items = new ArrayList<>();

    private static FilmsItemLab instance;

    private FilmsItemLab (Context context) {
        items.add(new ItemFilm("Супер крэйзи", context.getString(R.string.desc_super), "super1"));
        items.add(new ItemFilm("Довод", context.getString(R.string.desc_tenet), "tenet"));
        items.add(new ItemFilm("Список Шиндлера", context.getString(R.string.desc_shindle), "shindler"));
        items.add(new ItemFilm("Милен Фармер", context.getString(R.string.desc_milem), "milen"));
        items.add(new ItemFilm("Побег из Шоушенка", context.getString(R.string.desc_leave), "leave"));
        items.add(new ItemFilm("Зеленая миля", context.getString(R.string.desc_green), "green"));
        items.add(new ItemFilm("Форест Гамп", context.getString(R.string.desc_forest), "forest"));
        items.add(new ItemFilm("Концерт Армина ван Бюрена в Утрехте", context.getString(R.string.desc_armine), "armine"));
        items.add(new ItemFilm("После ссоры", context.getString(R.string.desc_after), "after"));
        items.add(new ItemFilm("Шестой концертный тур Милен Фармер", context.getString(R.string.desc_stmilen), "stmiilen"));

    }

    public static FilmsItemLab getInstance(Context context){
        if(instance == null) {
            instance = new FilmsItemLab(context);
        }

        return instance;
    }

    public static List<ItemFilm> getItems() {
        return items;
    }
}
