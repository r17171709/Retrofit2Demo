package com.example.renyu.retrofit2demo.impl;

import com.example.renyu.retrofit2demo.model.GameModel;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by RG on 2016/4/5.
 */
public interface GameApi {

    @GET("api/v1.0/gamesdate/{data}")
    Observable<List<GameModel>> getGames(@Path("data") String data);
}
