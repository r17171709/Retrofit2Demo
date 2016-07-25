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

    private static Retrofit2Utils instance;

    //okhttp build对象
    private static OkHttpClient.Builder okhttpBuilder;
    //Retrofit build对象
    private static Retrofit.Builder retrofitBuilder;

    private Retrofit2Utils() {

    }

    public static Retrofit2Utils getInstance() {
        if (instance==null) {
            synchronized (Retrofit2Utils.class) {
                if (instance==null) {
                    okhttpBuilder=new OkHttpClient.Builder()
                            .readTimeout(10, TimeUnit.SECONDS)
                            .writeTimeout(10, TimeUnit.SECONDS)
                            .connectTimeout(10, TimeUnit.SECONDS);
                    instance=new Retrofit2Utils();
                }
            }
        }
        return instance;
    }

    public void enableLog(boolean flag) {
        if (flag) {
            HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            okhttpBuilder.addInterceptor(interceptor);
        }
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
        retrofitBuilder=new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return retrofitBuilder.addConverterFactory(ListGsonConverterFactory.create(class_)).client(okhttpBuilder.build()).baseUrl(baseUrl).build();
    }

    public Retrofit getRetrofit(String baseUrl) {
        retrofitBuilder=new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return retrofitBuilder.addConverterFactory(GsonConverterFactory.create()).client(okhttpBuilder.build()).baseUrl(baseUrl).build();
    }
}
