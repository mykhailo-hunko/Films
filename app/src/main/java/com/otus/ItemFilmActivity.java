package com.otus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;


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
        imageFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View.OnClickListener listener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                };

                Snackbar.make(view,getString(R.string.click), Snackbar.LENGTH_INDEFINITE ).setAction(getString(R.string.click_me), listener).show();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Share();
            }
        });

    }


    private void Share() {
        String textMessage = "Приглашаю тебя на фильм " + "\"" + FilmTitle + "\"";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void ShowFilm() {
        String Photo = getIntent().getStringExtra(FilmsItemViewHolder.CodePhoto);
        FilmTitle = getIntent().getStringExtra(FilmsItemViewHolder.CodeTitle);
        String descr = getIntent().getStringExtra(FilmsItemViewHolder.CodeDesc);

        int resId = imageFilm.getContext().getResources().getIdentifier(Photo, "drawable", imageFilm.getContext().getPackageName());
        imageFilm.setImageResource(resId);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_text);
        imageFilm.startAnimation(animation);
        description.setText(descr);
        title.setText(FilmTitle);
        description.startAnimation(anim);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.invite) {
            Share();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
