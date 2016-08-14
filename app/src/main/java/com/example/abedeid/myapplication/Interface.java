package com.example.abedeid.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Abed Eid on 15/08/2016.
 */
public interface Interface {
    @GET("movie/top_rated")
     Call<Result>getTopRatedMovies(@Query("api_key") String apiKey);

}
