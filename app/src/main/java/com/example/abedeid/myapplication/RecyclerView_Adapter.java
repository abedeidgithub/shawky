package com.example.abedeid.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Abed Eid on 15/08/2016.
 */
public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.My> {
    private List<Movie> movies;
    private Context context;

    public RecyclerView_Adapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public RecyclerView_Adapter.My onCreateViewHolder(ViewGroup parent, int viewType) {

      View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_photo_card,null);
        return new My(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView_Adapter.My holder, final int position) {
        String posterPath = "http://image.tmdb.org/t/p/w320/"+movies.get(position).getPosterPath();
        Picasso.with(context).load(posterPath).into(holder.movie_img);
        holder.movie_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, movies.get(position).getOriginalTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class My extends RecyclerView.ViewHolder {

        ImageView movie_img;

        public My(View itemView) {
            super(itemView);
            movie_img = (ImageView) itemView.findViewById(R.id.photo);
        }
    }
}