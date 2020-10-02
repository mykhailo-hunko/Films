package com.otus;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class app extends Application {

    MoviesServices moviesServices;
    private static app instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        initRetrofot();
    }

    public static app getInstance(){
        return instance;
    }

    private void initRetrofot() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         moviesServices  = retrofit.create(MoviesServices.class);

    }
}
