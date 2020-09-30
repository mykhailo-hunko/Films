package com.otus;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    public final static String code = "intent";
    public final static String title = "title";
    public final static String desc = "desc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_item_film_fragment);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_, new MainFragment())
                .commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fr = null;
                    switch (item.getItemId()){
                        case R.id.action_map:
                            getSupportFragmentManager().popBackStack();
                            fr = new MainFragment();
                            break;
                        case  R.id.action_add:
                            fr = new AddingFragment();
                            break;
                    }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_, fr)
                        .commit();
                return true;
            }
        });


    }



}
