package com.example.renyu.retrofit2demo.impl;

import com.example.renyu.retrofit2demo.model.GankioModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by RG on 2016/3/27.
 */
public interface GankioApi {

    @GET("{type}/{pagenum}/{page}")
    public Observable<GankioModel> getGankioModels(@Path("type") String type, @Path("pagenum") int pagenum, @Path("page") int page);
}
