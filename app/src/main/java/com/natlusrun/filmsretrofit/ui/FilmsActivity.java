package com.natlusrun.filmsretrofit.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.natlusrun.filmsretrofit.App;
import com.natlusrun.filmsretrofit.R;
import com.natlusrun.filmsretrofit.data.models.FilmModel;
import com.natlusrun.filmsretrofit.data.network.GhibliService;
import com.natlusrun.filmsretrofit.ui.adapters.FilmsAdapter;

import java.util.List;

public class FilmsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button openLesson;
    private List<FilmModel> films;
    private RecyclerView recyclerView;
    private Context context;
    FilmsAdapter filmsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

        openLesson = findViewById(R.id.open_lesson_btn);

        recyclerView = findViewById(R.id.films_rv);
        filmsAdapter = new FilmsAdapter();
        recyclerView.setAdapter(filmsAdapter);


       App.ghibliService.getFilmsList(new GhibliService.GhibliFilmsCallback() {
           @Override
           public void onSuccess(List<FilmModel> list) {
//               filmsAdapter.setFilmList(list);
               Log.d("ff", String.valueOf(list.size()));
               if (list!= null){
               filmsAdapter.setFilmList(list);}
           }

           @Override
           public void onFailure(Throwable t) {
               Log.d("ff", t.getMessage());
           }
       });



        openLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(FilmsActivity.this, LessonActivity.class);
               startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        
    }
}