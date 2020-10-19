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
import com.natlusrun.filmsretrofit.ui.adapters.OnItemClick;

import java.util.List;

public class FilmsActivity extends AppCompatActivity {

    private Button openLesson, openFromLocal;
    private List<FilmModel> films;
    private RecyclerView recyclerView;
    private Context context;
    FilmsAdapter filmsAdapter;

    private final String TAG = "FilmsActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

        openLesson = findViewById(R.id.open_lesson_btn);
        openFromLocal = findViewById(R.id.local_films_btn);

        recyclerView = findViewById(R.id.films_rv);
        filmsAdapter = new FilmsAdapter();
        recyclerView.setAdapter(filmsAdapter);


       App.ghibliService.getFilmsList(new GhibliService.GhibliFilmsCallback() {
           @Override
           public void onSuccess(List<FilmModel> list) {
//               filmsAdapter.setFilmList(list);
               Log.d("ff", String.valueOf(list.size()));
               filmsAdapter.setFilmList(list);
               filmsAdapter.setOnItemClick(new OnItemClick() {
                   @Override
                   public void onItemViewClick(int position) {
                       Intent intent = new Intent(FilmsActivity.this, FilmsInfoActivity.class);
                       intent.putExtra("key", list.get(position).getId());
                       startActivity(intent);
                   }
               });
                  App.db.userDao().insertAll(list);
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

        openFromLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FilmsActivity.this, FavouritesActivity.class);
                startActivity(intent);
            }
        });
    }
}
