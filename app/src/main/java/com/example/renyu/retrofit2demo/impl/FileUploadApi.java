package com.example.renyu.retrofit2demo.impl;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * Created by RG on 2016/4/3.
 */
public interface FileUploadApi {

    @Multipart
    @POST("http://upload.qiniu.com/")
    Call<ResponseBody> uploadImage(@PartMap Map<String, RequestBody> params);
}
