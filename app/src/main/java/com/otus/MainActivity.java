package com.otus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static List<ItemFilm> items;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = FilmsItemLab.getInstance(this).getItems();

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new FilmsItemAdapter(LayoutInflater.from(this), items));

    }
    public static List<ItemFilm> getItems() {
        return items;
    }

/*
        after.setTextColor(Color.BLACK);
        super1.setTextColor(Color.BLACK);

        if(savedInstanceState != null) {
            int Film = savedInstanceState.getInt("state");
            switch (Film) {
                case -1:  after.setTextColor(Color.RED);
                break;
                case 1: super1.setTextColor(Color.RED);
                break;
            }
        }



        detailAfter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                after.setTextColor(Color.RED);
                super1.setTextColor(Color.BLACK);
                GoIntent(-1);
            }
        });

        detailSuper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                super1.setTextColor(Color.RED);
                after.setTextColor(Color.BLACK);
                GoIntent(1);
            }
        });



    }

    public void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        if(after.getCurrentTextColor() == Color.RED) {
            FilmCodeRed = -1;
        } else {
            FilmCodeRed = 1;
        }
        outState.putInt("state", FilmCodeRed);
    }

    private void GoIntent (int filmNumber) {  // -1 - После ссоры, 1 - Супер крейзи.

        Intent intent = new Intent(MainActivity.this, ItemFilmActivity.class);
        intent.putExtra(Code, filmNumber);
        startActivity(intent);

    }
*/
}
