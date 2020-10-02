package com.otus;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesServices {
    @GET
    Call<List<MovieTemp>> getMovies();
}
