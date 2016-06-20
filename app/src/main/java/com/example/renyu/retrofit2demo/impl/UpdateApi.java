package com.example.renyu.retrofit2demo.impl;

import com.example.renyu.retrofit2demo.model.UpdateModel;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Clevo on 2016/6/20.
 */
public interface UpdateApi {

    @FormUrlEncoded
    @POST("common/version")
    Observable<UpdateModel> getUpdateModel(@FieldMap Map<String, String> maps);
}
