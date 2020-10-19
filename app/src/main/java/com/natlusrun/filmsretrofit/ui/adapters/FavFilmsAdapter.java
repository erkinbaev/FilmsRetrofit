package com.natlusrun.filmsretrofit.ui.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.natlusrun.filmsretrofit.data.models.FilmModel;

import java.util.ArrayList;
import java.util.List;

public class FavFilmsAdapter extends RecyclerView.Adapter<FavFilmsAdapter.FavFilmViewHolder> {

    public List<FilmModel> filmList = new ArrayList<>();

    public void setFilmList(List<FilmModel> filmList) {
        this.filmList = filmList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FavFilmViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FavFilmViewHolder extends RecyclerView.ViewHolder {
        public FavFilmViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
