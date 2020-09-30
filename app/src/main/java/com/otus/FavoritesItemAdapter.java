package com.otus;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoritesItemAdapter extends RecyclerView.Adapter<FavoritesItemViewHolder> {

    private LayoutInflater inflater;
    private List<ItemFilm> items;


    public FavoritesItemAdapter(LayoutInflater inflater, List<ItemFilm> items) {
        this.items = items;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public FavoritesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoritesItemViewHolder(inflater.inflate(R.layout.favorites_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesItemViewHolder holder, int position) {
        holder.bind(items.get(position));
        Log.d("ddd", "get " + position);

    }

    @Override
    public int getItemCount() {
        int size = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isFavorite) {
                size++;
            }
        }
        Log.d("ddd", " " + size);

        return items.size();
    }
}
