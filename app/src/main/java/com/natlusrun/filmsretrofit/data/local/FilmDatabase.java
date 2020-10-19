package com.natlusrun.filmsretrofit.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.natlusrun.filmsretrofit.data.models.FilmModel;


@Database(entities = {FilmModel.class}, version = 1)
public abstract class FilmDatabase extends RoomDatabase {
    public abstract FilmDao userDao();
}

