package com.otus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button detailAfter;
    private Button detailSuper;
    private TextView after;
    private TextView super1;
    static String Code = "intent.com.film";
    int FilmCodeRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        after = findViewById(R.id.after_text);
        super1 = findViewById(R.id.super_text);

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

        detailAfter = findViewById(R.id.detailAfter);
        detailSuper = findViewById(R.id.detailSuper);

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

}
