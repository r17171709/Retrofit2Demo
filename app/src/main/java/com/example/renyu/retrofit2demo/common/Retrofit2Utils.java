package com.example.renyu.retrofit2demo.common;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by renyu on 2016/3/21.
 */
public class Retrofit2Utils {

    public static Context context;

    private static Retrofit2Utils instance;

    private static OkHttpClient client;

    Retrofit.Builder builder;

    private Retrofit2Utils() {
        builder=new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(client);
    }

    public synchronized static Retrofit2Utils getInstance(Context context_) {
        if (instance==null) {
            synchronized (Retrofit2Utils.class) {
                if (instance==null) {
                    context=context_;
                    OkHttpClient.Builder builder=new OkHttpClient.Builder()
                            //缓存拦截器
                            .addInterceptor(new CacheInterceptor())
                            .addNetworkInterceptor(new CacheInterceptor())
                            //设置缓存路径以及大小
                            .cache(new Cache(new File(Environment.getExternalStorageDirectory().getPath() + "/retrofit2demo"), 1024 * 1024 * 100))
                            .readTimeout(10, TimeUnit.SECONDS)
                            .writeTimeout(10, TimeUnit.SECONDS)
                            .connectTimeout(10, TimeUnit.SECONDS);
                    builder.interceptors().add(new CacheInterceptor());
                    client=builder.build();
                    instance=new Retrofit2Utils();
                }
            }
        }
        return instance;
    }

    public Retrofit getRetrofit(String baseUrl) {
        return builder.baseUrl(baseUrl).build();
    }
}
