package com.natlusrun.filmsretrofit.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.natlusrun.filmsretrofit.R;
import com.natlusrun.filmsretrofit.data.models.FilmModel;

import java.util.ArrayList;
import java.util.List;

public class FavFilmsAdapter extends RecyclerView.Adapter<FavFilmsAdapter.FavFilmViewHolder> {

    public List<FilmModel> filmList = new ArrayList<>();
    public FilmModel filmModel;

    public void setFilmModel(FilmModel filmModel) {
        this.filmModel = filmModel;
    }

    public void setFilmList(List<FilmModel> filmList) {
        this.filmList = filmList;
        notifyDataSetChanged();
    }

//    public FavFilmsAdapter(List<FilmModel> filmList) {
//        this.filmList = filmList;
//    }

    @NonNull
    @Override
    public FavFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_film_item, parent, false);
        return new FavFilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavFilmViewHolder holder, int position) {
        holder.onBind(filmList.get(position));
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }


    public class FavFilmViewHolder extends RecyclerView.ViewHolder {
        TextView filmTitle, filmDir;

        public FavFilmViewHolder(@NonNull View itemView) {
            super(itemView);
            filmTitle = itemView.findViewById(R.id.fav_title_tv);
            filmDir = itemView.findViewById(R.id.fav_dir_tv);


        }

        public void onBind(FilmModel filmModel) {
            filmTitle.setText(filmModel.getTitle());
            filmDir.setText(filmModel.getDirector());
        }

    }
}
