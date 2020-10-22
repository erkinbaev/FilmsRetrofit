package com.natlusrun.filmsretrofit.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.natlusrun.filmsretrofit.App;
import com.natlusrun.filmsretrofit.R;
import com.natlusrun.filmsretrofit.data.models.FilmModel;
import com.natlusrun.filmsretrofit.data.network.GhibliService;
import com.natlusrun.filmsretrofit.ui.adapters.FavFilmsAdapter;
import com.natlusrun.filmsretrofit.ui.adapters.FilmsAdapter;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private final String TAG = "FavouritesActivity";
    private FavFilmsAdapter favFilmsAdapter;
    private ArrayList<FilmModel> list;
    private String position;
    private FilmModel filmModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        init();
        listAdd();
        getIncomingIntent();
    }

    private void listAdd() {
        //list.clear();
        //list.addAll(App.db.userDao().getAll());
    }

    private void init() {
        recyclerView = findViewById(R.id.fav_rv);
        list = new ArrayList<>();
        favFilmsAdapter = new FavFilmsAdapter();
        recyclerView.setAdapter(favFilmsAdapter);
        //favFilmsAdapter.setFilmList(list);
    }

    private void getIncomingIntent() {

        favFilmsAdapter.setFilmList(App.db.userDao().getAll());
        list.clear();
        list.addAll(App.db.userDao().getAll());

    }
//        App.ghibliService.getFilmById(position, new GhibliService.GhibliFilmCallback() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onSuccess(FilmModel filmModel) {
//                filmTitle.setText("Title: "+filmModel.getTitle());
//                filmDesc.setText("Description: "+filmModel.getDescription());
//                filmDir.setText("Director: " +filmModel.getDirector());
//            }
//
//            @Override
//            public void onFailure(Throwable ex) {
//
//            }
//        });
}

