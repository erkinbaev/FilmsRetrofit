package com.natlusrun.filmsretrofit.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.natlusrun.filmsretrofit.App;
import com.natlusrun.filmsretrofit.R;
import com.natlusrun.filmsretrofit.data.models.FilmModel;
import com.natlusrun.filmsretrofit.data.network.GhibliService;

public class FilmsInfoActivity extends AppCompatActivity {

    private TextView filmTitle, filmDesc, filmDir;
    private Button addFav;
    private final String TAG = "FilmsInfoActivity";
    private String position;
    private FilmModel filmModel2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films_info);

        init();
        getIncomIntent();

        addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.db.userDao().insertAll(filmModel2);
            }
        });
    }

    private void init(){
        filmTitle = findViewById(R.id.film_info_title);
        filmDesc = findViewById(R.id.film_info_desc);
        filmDir = findViewById(R.id.film_info_dir);
        addFav = findViewById(R.id.add_fav_btn);
    }

    private  void getIncomIntent(){
        if(getIntent() !=null){
            position = getIntent().getStringExtra("key");
        }
        App.ghibliService.getFilmById(position, new GhibliService.GhibliFilmCallback() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccess(FilmModel filmModel) {
                filmModel2 = filmModel;
                filmTitle.setText("Title: "+filmModel.getTitle());
                filmDesc.setText("Description: "+filmModel.getDescription());
                filmDir.setText("Director: " +filmModel.getDirector());
            }

            @Override
            public void onFailure(Throwable ex) {

            }
        });
    }
}
