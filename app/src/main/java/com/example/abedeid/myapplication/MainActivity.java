package com.example.abedeid.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    private final static String API_KEY = "78bf6a2ef253cfbbb8e3067ab8956a4b";
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        txt = (TextView) findViewById(R.id.textView);
        Interface api = Api.getClient().create(Interface.class);
        Call<Result> topRatedMovies = api.getTopRatedMovies(API_KEY);
        topRatedMovies.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                List<Movie> results = response.body().getResults();
//                for(int i=0 ;i<results.size();i++){
//
//                    Log.d("Shawy",results.get(i).getPosterPath()+"\n");
//                }
                recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
                RecyclerView_Adapter adapter=new RecyclerView_Adapter(results,getBaseContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });


    }
}
