package com.otus;

import android.content.Context;
import android.content.Intent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        Context context = view.getContext();
        Intent intent = new Intent(context, ItemFilmActivity.class);
        int position = getBindingAdapterPosition();
       intent.putExtra(CodeDesc, MainActivity.getItems().get(position).description);
        intent.putExtra(CodePhoto, MainActivity.getItems().get(position).photoName);
        intent.putExtra(CodeTitle, MainActivity.getItems().get(position).title);
        context.startActivity(intent);

    }
}
