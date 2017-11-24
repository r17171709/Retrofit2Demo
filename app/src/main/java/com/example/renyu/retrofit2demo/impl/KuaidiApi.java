package com.example.renyu.retrofit2demo.impl;

import com.example.renyu.retrofit2demo.model.KuaidiModel;
import com.example.renyu.retrofit2demo.model.MoviePostModel;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by renyu on 2017/11/24.
 */

public interface KuaidiApi {
    /**
     * 网页地址 http://www.kuaidi100.com/query?type=yunda&postid=3101449726243&temp=0.057969198168630776
     * @param type
     * @param postid
     * @return
     */
    @GET("query")
    Observable<KuaidiModel> getKuaidiInfo(@Query("type") String type, @Query("postid") String postid);

    @FormUrlEncoded
    @POST("http://www.kuaidi100.com/query?type=yunda&postid=3101449726243&temp=0.057969198168630776")
    Observable<KuaidiModel> getKuaidiInfo(@FieldMap Map<String, String> params);

    @POST("http://www.kuaidi100.com/query?type=yunda&postid=3101449726243&temp=0.057969198168630776")
    Observable<KuaidiModel> getKuaidiInfo(@Body MoviePostModel postModel);
}
