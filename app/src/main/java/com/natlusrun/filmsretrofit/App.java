package com.natlusrun.filmsretrofit;

import android.app.Application;

import androidx.room.Room;

import com.natlusrun.filmsretrofit.data.local.FilmDatabase;
import com.natlusrun.filmsretrofit.data.network.GhibliService;


public class App extends Application {

    public static GhibliService ghibliService;
    public static FilmDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        ghibliService = new GhibliService();
        db = Room.databaseBuilder(this,
                FilmDatabase.class, "database-name").allowMainThreadQueries().build();
    }
}
