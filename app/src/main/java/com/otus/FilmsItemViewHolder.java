package com.otus;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class FilmsItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    static final String CodeDesc = "description";
    static final String CodePhoto = "photo";
    static final String CodeTitle = "title";
    private ImageView imageFilm;
    private TextView title;
    private ImageView imageView;

    public FilmsItemViewHolder (@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.save);
        title = itemView.findViewById(R.id.title);
       imageFilm = itemView.findViewById(R.id.imageFilm);
       itemView.setOnClickListener(this);
    }
    public void bind (final ItemFilm itemFilm) {
        final int resNoFav = imageView.getContext().getResources().getIdentifier("heart", "drawable", imageView.getContext().getPackageName());
        final int resFav = imageView.getContext().getResources().getIdentifier("heart_fill", "drawable", imageView.getContext().getPackageName());
        if(itemFilm.isFavorite){
            imageView.setImageResource(resFav);
        } else{
            imageView.setImageResource(resNoFav);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemFilm.isFavorite){
                    itemFilm.isFavorite = false;
                    imageView.setImageResource(resNoFav);

                        Log.d("ddd", "NotTOFa" + itemFilm.title);
                        FilmsFavoriteLab.Delete(itemFilm.title);


                } else {
                    itemFilm.isFavorite = true;
                    imageView.setImageResource(resFav);
                    Log.d("ddd", "GoTOFav" + itemFilm.title);
                    FilmsFavoriteLab.Adding(itemFilm.title, itemFilm.description, itemFilm.photoName);
                }
            }
        });
        title.setText(itemFilm.title);
       int resId = imageFilm.getContext().getResources().getIdentifier(itemFilm.photoName,"drawable", imageFilm.getContext().getPackageName());
       imageFilm.setImageResource(resId);
    }

    @Override
    public void onClick(View view) {
        int position = getBindingAdapterPosition();
        Context context = view.getContext();

        Bundle bundle = new Bundle();
        bundle.putString(CodeDesc, MainFragment.getItems().get(position).description);
        bundle.putString(CodePhoto, MainFragment.getItems().get(position).photoName);
        bundle.putString(CodeTitle, MainFragment.getItems().get(position).title);
        ItemFilmFragment iff = new ItemFilmFragment();
        iff.setArguments(bundle);

        FragmentActivity activity = (FragmentActivity) context;
        FragmentManager manager = activity.getSupportFragmentManager();
        manager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container_, iff)
                .commit();

    }
}
