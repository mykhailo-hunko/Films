package com.otus;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritesItemViewHolder extends RecyclerView.ViewHolder  {

    private ImageView imageFilm;
    private TextView title;

    public FavoritesItemViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_);
        imageFilm = itemView.findViewById(R.id.imageFilm_);
    }

    public void bind(ItemFilm itemFilm){

        if(itemFilm.isFavorite) {
            title.setText(itemFilm.title);
            int resId = imageFilm.getContext().getResources().getIdentifier(itemFilm.photoName, "drawable", imageFilm.getContext().getPackageName());
            imageFilm.setImageResource(resId);
            Log.d("ddd", "isFavorite " + itemFilm.title);
        }
    }


}
