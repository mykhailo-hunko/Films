package com.otus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;


public class ItemFilmActivity extends AppCompatActivity {

    private ImageView imageFilm;
    private TextView description;
    private TextView title;
    private String FilmTitle;
    private MaterialButton share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_film);

        imageFilm = findViewById(R.id.filmImage);
        description = findViewById(R.id.description);
        share = findViewById(R.id.share);
        title = findViewById(R.id.title);

        ShowFilm();

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textMessage = "Приглашаю тебя на фильм " + "\"" +  FilmTitle + "\"" ;
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);


            }
        });

    }

    private void ShowFilm () {
        String Photo = getIntent().getStringExtra(FilmsItemViewHolder.CodePhoto);
        FilmTitle = getIntent().getStringExtra(FilmsItemViewHolder.CodeTitle);
        String descr = getIntent().getStringExtra(FilmsItemViewHolder.CodeDesc);

        int resId = imageFilm.getContext().getResources().getIdentifier(Photo,"drawable", imageFilm.getContext().getPackageName());
        imageFilm.setImageResource(resId);
        description.setText(descr);
        title.setText(FilmTitle);



    }


}
