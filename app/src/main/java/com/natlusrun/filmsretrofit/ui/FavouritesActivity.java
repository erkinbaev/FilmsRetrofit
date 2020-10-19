package com.natlusrun.filmsretrofit.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.natlusrun.filmsretrofit.App;
import com.natlusrun.filmsretrofit.R;
import com.natlusrun.filmsretrofit.data.models.FilmModel;
import com.natlusrun.filmsretrofit.ui.adapters.FavFilmsAdapter;
import com.natlusrun.filmsretrofit.ui.adapters.FilmsAdapter;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private final String TAG = "FavouritesActivity";
    private FilmsAdapter favFilmsAdapter;
    private ArrayList<FilmModel> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        init();
        listAdd();
    }

    private void listAdd() {
        list.clear();
        list.addAll(App.db.userDao().getAll());
    }

    private void init() {
        recyclerView = findViewById(R.id.fav_rv);
        list = new ArrayList<>();
        favFilmsAdapter = new FilmsAdapter();
        recyclerView.setAdapter(favFilmsAdapter);
        favFilmsAdapter.setFilmList(list);
    }
}
