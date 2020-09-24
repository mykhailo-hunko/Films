package com.otus;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmsItemAdapter extends RecyclerView.Adapter<FilmsItemViewHolder> {
    private LayoutInflater inflater;
    private List<ItemFilm> items;


    public FilmsItemAdapter(LayoutInflater inflater, List<ItemFilm> items) {
        this.items = items;
        this.inflater = inflater;
    }


    @NonNull
    @Override
    public FilmsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FilmsItemViewHolder(inflater.inflate(R.layout.item_films, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsItemViewHolder holder, int position) {
        holder.bind(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
