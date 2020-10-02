package com.otus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;


import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class MainFragment extends Fragment {
    private static List<ItemFilm> items;
    RecyclerView recyclerView;
    public final static String code = "intent";
    public final static String title = "title";
    public final static String desc = "desc";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        return inflater.inflate(R.layout.activity_main, container,false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener(code, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                String titleNew = bundle.getString(title);
                String descNew = bundle.getString(desc);
                FilmsItemLab.Adding(titleNew, descNew);
                items = FilmsItemLab.getInstance(getContext()).getItems();


                goJson();
            }
        });
        setRetainInstance(true);

    }

    private void goJson() {
        Gson gson = new Gson();

    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        items = FilmsItemLab.getInstance(getContext()).getItems();

        recyclerView = v.findViewById(R.id.recyclerView);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new FilmsItemAdapter(LayoutInflater.from(v.getContext()), items));

        app.getInstance().moviesServices.getMovies().enqueue(new Callback<List<MovieTemp>>() {
            @Override
            public void onResponse(Call<List<MovieTemp>> call, retrofit2.Response<List<MovieTemp>> response) {
                if (response.isSuccessful()){
                    List<MovieTemp> movieTemps = response.body();
                    movieTemps.clear();
                    for( MovieTemp movieTemp: movieTemps){
                       // логика перезаписи в нашу структуру
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<MovieTemp>> call, Throwable t) {

            }
        });
    }
    public static List<ItemFilm> getItems() {
        return items;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add) {
            createFilm();
            return true;
        }
        if (id == R.id.about) {
            dialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void dialog() {
        AlertDialog.Builder bld = new AlertDialog.Builder(getContext());
        DialogInterface.OnClickListener lst = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        };
        bld.setMessage(getString(R.string.about_2020));
        bld.setTitle(getString(R.string.about));
        bld.setNeutralButton("OK",  lst);
        bld.show();
    }


    private void createFilm(){
        FragmentActivity activity = (FragmentActivity) getContext();
        FragmentManager manager = activity.getSupportFragmentManager();
        manager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container_, new AddingFragment())
                .commit();

    }


}
