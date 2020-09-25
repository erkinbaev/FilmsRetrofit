package com.natlusrun.filmsretrofit;

import android.app.Application;

import com.natlusrun.filmsretrofit.data.network.GhibliService;
import com.natlusrun.filmsretrofit.data.network.GhibliServiceHW;

public class App extends Application {

    public static GhibliService ghibliService;

    @Override
    public void onCreate() {
        super.onCreate();
        ghibliService = new GhibliService();
    }
}
