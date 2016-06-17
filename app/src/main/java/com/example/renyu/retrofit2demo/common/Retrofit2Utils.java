package com.example.renyu.retrofit2demo.common;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by renyu on 2016/3/21.
 */
public class Retrofit2Utils {

    //okhttp build对象
    private OkHttpClient.Builder okhttpBuilder;
    //Retrofit build对象
    private Retrofit.Builder retrofitBuilder;
    //日志拦截器
    private HttpLoggingInterceptor interceptor;

    public Retrofit2Utils() {
        retrofitBuilder=new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        okhttpBuilder=new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
        okhttpBuilder.addInterceptor(interceptor);
    }

    /**
     * 设置缓存
     * @param flag
     */
    public void enableCache(boolean flag, Context context) {
        if (flag) {
            //缓存拦截器
            okhttpBuilder.addInterceptor(new CacheInterceptor(context))
                    .addNetworkInterceptor(new CacheInterceptor(context))
                    //设置缓存路径以及大小
                    .cache(new Cache(new File(Environment.getExternalStorageDirectory().getPath() + "/retrofit2demo"), 1024 * 1024 * 100));
            okhttpBuilder.interceptors().add(new CacheInterceptor(context));
        }
    }

    /**
     * 添加额外的拦截器
     * @param interceptor
     * @return
     */
    public void addExtraInterceptor(Interceptor interceptor) {
        okhttpBuilder.interceptors().add(interceptor);
    }

    public <T> Retrofit getListRetrofit(String baseUrl, Class<T> class_) {
        return retrofitBuilder.addConverterFactory(ListGsonConverterFactory.create(class_)).client(okhttpBuilder.build()).baseUrl(baseUrl).build();
    }

    public Retrofit getRetrofit(String baseUrl) {
        return retrofitBuilder.addConverterFactory(GsonConverterFactory.create()).client(okhttpBuilder.build()).baseUrl(baseUrl).build();
    }
}
