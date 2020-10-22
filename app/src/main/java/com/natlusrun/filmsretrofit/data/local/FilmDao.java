package com.natlusrun.filmsretrofit.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.natlusrun.filmsretrofit.data.models.FilmModel;

import java.util.List;

import retrofit2.http.GET;

@Dao
public interface FilmDao {


    @Query("SELECT * FROM filmmodel")
    List<FilmModel> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(FilmModel filmModel);

}
