package com.example.renyu.retrofit2demo.impl;

import com.example.renyu.retrofit2demo.model.BranchInfoModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Clevo on 2016/6/16.
 */
public interface HomePageByBranchIdApi {

    @GET("api/v3/adv/homePageByBranchId?token=502fd7c36db5442792d2de990e877831&client_id=ANDROID.MODELLenovoA7600-mIMEI866580021130574&appkey=D21A6876-A54F-44AA-A435-D834C78AE7A7&branch_id=1&page=15&limit=1")
    public Observable<List<BranchInfoModel>> getHomePageByBranchId();
}
