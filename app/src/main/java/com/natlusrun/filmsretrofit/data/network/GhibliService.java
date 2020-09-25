package com.natlusrun.filmsretrofit.data.network;

import android.util.Log;

import com.natlusrun.filmsretrofit.data.models.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class GhibliService {

    private final String TAG = "GhibliService";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    GhibliApi service = retrofit.create(GhibliApi.class);

    public void getFilmById(String id, GhibliFilmCallback callback){
        Call<FilmModel> call = service.getFilmById(id);
        call.enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                if (response.isSuccessful() && response.body() !=null){
                    callback.onSuccess(response.body());
                    Log.d(TAG, "onResponse: " + response.body().getTitle());
                }
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
                callback.onFailure(t);
                Log.d(TAG, "onFailure: Failure");
            }
        });
    }

    public void getFilmsList( GhibliFilmsCallback filmsCallback){
        Call<List<FilmModel>> listCall= service.getFilms();
        listCall.enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
                if (response.isSuccessful() ){
                    filmsCallback.onSuccess(response.body());
                    Log.d(TAG, "onResponse" + response.body().get(0).getTitle());
                }
            }

            @Override
            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
                filmsCallback.onFailure(t);
                Log.d("faile", t.getMessage());
            }
        });

    }

    public interface GhibliFilmsCallback{
        void onSuccess(List<FilmModel> list);
        void onFailure(Throwable t);
    }

    public interface GhibliFilmCallback{
         void onSuccess(FilmModel filmModel);
         void onFailure(Throwable ex);
    }
    public interface GhibliApi {
        @GET("films/{filmId}")
        Call<FilmModel> getFilmById(
                @Path("filmId") String filmId
        );

        @GET("films")
        Call<List<FilmModel>> getFilms();
    }
}
