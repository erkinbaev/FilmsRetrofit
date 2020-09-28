package com.natlusrun.filmsretrofit.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.natlusrun.filmsretrofit.R;
import com.natlusrun.filmsretrofit.data.models.FilmModel;


import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {

    public List<FilmModel> filmList = new ArrayList<>();
    public OnItemClick onItemClick;

    public void setFilmList(List<FilmModel> filmList) {
        this.filmList = filmList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.films_item, parent, false);
        return new FilmsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.onBind(filmList.get(position));
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public class FilmsViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView filmTitle, filmDesc, filmDir;

        public FilmsViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.films_cv);
            filmTitle = itemView.findViewById(R.id.films_title_tv);
            filmDesc = itemView.findViewById(R.id.films_desc_tv);
            filmDir = itemView.findViewById(R.id.films_dir_tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick.onItemViewClick(getAdapterPosition());
                }
            });
        }

        public void onBind(FilmModel filmModel) {
            filmTitle.setText(filmModel.getTitle());
            filmDesc.setText(filmModel.getDescription());
            filmDir.setText(filmModel.getDirector());
        }
    }
}
