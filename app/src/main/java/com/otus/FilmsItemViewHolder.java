package com.otus;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;



public class FilmsItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    static final String CodeDesc = "description";
    static final String CodePhoto = "photo";
    static final String CodeTitle = "title";
    private ImageView imageFilm;
    private TextView title;

    public FilmsItemViewHolder (@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
       imageFilm = itemView.findViewById(R.id.imageFilm);
       itemView.setOnClickListener(this);
    }
    public void bind (ItemFilm itemFilm) {
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
