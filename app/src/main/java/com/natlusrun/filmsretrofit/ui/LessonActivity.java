package com.natlusrun.filmsretrofit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.natlusrun.filmsretrofit.App;
import com.natlusrun.filmsretrofit.R;
import com.natlusrun.filmsretrofit.data.models.FilmModel;
import com.natlusrun.filmsretrofit.data.network.GhibliService;

public class LessonActivity extends AppCompatActivity {
TextView filmTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        filmTitle = findViewById(R.id.film_title);
        App.ghibliService.getFilmById("58611129-2dbc-4a81-a72f-77ddfc1b1b49", new GhibliService.GhibliFilmCallback() {
            @Override
            public void onSuccess(FilmModel filmModel) {
                filmTitle.setText(filmModel.getTitle());
            }

            @Override
            public void onFailure(Throwable ex) {

            }
        });
    }
}