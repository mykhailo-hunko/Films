package com.otus;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ItemFilmFragment extends Fragment {

    private ImageView imageFilm;
    private FloatingActionButton fab;
    private TextView description;
    private String FilmTitle;
    private Toolbar toolbar;
    private AppCompatActivity appCompatActivity;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_item_film, container,false);
        setHasOptionsMenu(true);
        toolbar = v.findViewById(R.id.toolbar);
        return v;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ddd", "onDestroyitem");

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ddd", "onCreateItemFilm");
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        imageFilm = v.findViewById(R.id.filmImage);
        description = v.findViewById(R.id.description);
        fab = v.findViewById(R.id.fab_);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Share();
            }
        });



        ShowFilm();
        imageFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View.OnClickListener listener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                };

                Snackbar.make(view, getString(R.string.click), Snackbar.LENGTH_INDEFINITE).setAction(getString(R.string.click_me), listener).show();
            }
        });

        appCompatActivity = (AppCompatActivity) getActivity();
        ActionBar actionBar = appCompatActivity.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }






    private void Share() {
        String textMessage = getString(R.string.invite) + "\"" + FilmTitle + "\"";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void ShowFilm() {
        String Photo;
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Photo = getArguments().getString(FilmsItemViewHolder.CodePhoto) + '_';
        } else {
            Photo = getArguments().getString(FilmsItemViewHolder.CodePhoto);
        }
        FilmTitle = getArguments().getString(FilmsItemViewHolder.CodeTitle);
        String descr = getArguments().getString(FilmsItemViewHolder.CodeDesc);


        int resId = imageFilm.getContext().getResources().getIdentifier(Photo, "drawable", imageFilm.getContext().getPackageName());
        imageFilm.setImageResource(resId);
        description.setText(descr);
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setTitle(FilmTitle);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_first, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.invite) {
            Share();
            return true;
        }
        if (id == android.R.id.home) {
            appCompatActivity.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
