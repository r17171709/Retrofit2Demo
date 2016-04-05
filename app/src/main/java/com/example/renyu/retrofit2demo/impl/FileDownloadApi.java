package com.example.renyu.retrofit2demo.impl;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by RG on 2016/4/5.
 */
public interface FileDownloadApi {
    @Streaming
    @GET
    Call<ResponseBody> downloadFileWithFixedUrl(@Url String url);
}
