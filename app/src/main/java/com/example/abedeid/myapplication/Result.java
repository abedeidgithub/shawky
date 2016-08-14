package com.example.abedeid.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abed Eid on 15/08/2016.
 */
public class Result {
    @SerializedName("results")
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
