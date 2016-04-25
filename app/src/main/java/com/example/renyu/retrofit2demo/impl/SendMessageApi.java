package com.example.renyu.retrofit2demo.impl;

import com.example.renyu.retrofit2demo.model.SendMessageModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by RG on 2016/4/25.
 */
public interface SendMessageApi {

    @GET("index.php")
    public Observable<SendMessageModel> getSendMessage(@Query("s") String s, @Query("participants") String participants, @Query("taskId") String taskId, @Query("content") String content);
}
