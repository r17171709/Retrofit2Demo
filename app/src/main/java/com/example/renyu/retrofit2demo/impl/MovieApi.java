package com.example.renyu.retrofit2demo.impl;

import com.example.renyu.retrofit2demo.model.MovieModel;
import com.example.renyu.retrofit2demo.model.MoviePostModel;

import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by renyu on 2016/3/21.
 */
public interface MovieApi {

    /**
     * 参考文档 http://apistore.baidu.com/apiworks/servicedetail/1266.html
     * @param apikey
     * @param postModel
     * @return
     */
    @POST("shipin_kg/shipin_kg")
    public Observable<MovieModel> getMovieLists(@Header("apikey") String apikey, @Body MoviePostModel postModel);
}
