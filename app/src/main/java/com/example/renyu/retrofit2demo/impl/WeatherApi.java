package com.example.renyu.retrofit2demo.impl;

import com.example.renyu.retrofit2demo.model.WeatherModel;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by renyu on 2016/3/21.
 */
public interface WeatherApi {

    /**
     * 参考文档 http://apistore.baidu.com/apiworks/servicedetail/112.html
     * @param apikey
     * @param cityname
     * @return
     */
    @GET("weatherservice/cityname")
    Observable<WeatherModel> getWeatherModels(@Header("apikey") String apikey, @Query("cityname") String cityname);
}
