package com.otus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemFilmActivity extends AppCompatActivity {

    ImageView imageFilm;
    TextView description;
    Button share;
    String Film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_film);

        imageFilm = findViewById(R.id.filmImage);
        description = findViewById(R.id.description);
        share = findViewById(R.id.share);

        ChooseFilm();

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textMessage = "Приглашаю тебя на фильм " + Film;
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);


            }
        });

    }

    private void ChooseFilm () {
        int filmNumber = getIntent().getIntExtra(MainActivity.Code, -1);
        String FilmName = "";
        String descr = "";
        switch(filmNumber) {// -1 - После ссоры, 1 - Супер крейзи.
            case -1:
                FilmName = "after";
                Film = "\"После ссоры\"";
                descr = getResources().getString(R.string.desc_after);
                break;
            case 1:
               FilmName = "super1";
                Film = "\"Супер крэйзи\"";
                descr = getResources().getString(R.string.desc_super);
                break;
        }
        int resId = imageFilm.getContext().getResources().getIdentifier(FilmName,"drawable", imageFilm.getContext().getPackageName());
        imageFilm.setImageResource(resId);
        description.setText(descr);

    }


}
