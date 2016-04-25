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

    public static Context context;

    private static Retrofit2Utils instance;

    //okhttp build对象
    static OkHttpClient.Builder okhttpBuilder;
    //Retrofit build对象
    Retrofit.Builder retrofitBuilder;
    //日志拦截器
    static HttpLoggingInterceptor interceptor;

    private Retrofit2Utils() {
        retrofitBuilder=new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
    }

    public synchronized static Retrofit2Utils getInstance(Context context_) {
        if (instance==null) {
            synchronized (Retrofit2Utils.class) {
                if (instance==null) {
                    context=context_;
                    instance=new Retrofit2Utils();
                }
            }
        }
        okhttpBuilder=new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
        okhttpBuilder.addInterceptor(interceptor);
        return instance;
    }

    /**
     * 设置缓存
     * @param flag
     */
    public Retrofit2Utils enableCache(boolean flag) {
        if (flag) {
            //缓存拦截器
            okhttpBuilder.addInterceptor(new CacheInterceptor())
                    .addNetworkInterceptor(new CacheInterceptor())
                    //设置缓存路径以及大小
                    .cache(new Cache(new File(Environment.getExternalStorageDirectory().getPath() + "/retrofit2demo"), 1024 * 1024 * 100));
            okhttpBuilder.interceptors().add(new CacheInterceptor());
        }
        return instance;
    }

    /**
     * 添加额外的拦截器
     * @param interceptor
     * @return
     */
    public Retrofit2Utils addExtraInterceptor(Interceptor interceptor) {
        okhttpBuilder.interceptors().add(interceptor);
        return instance;
    }

    public <T> Retrofit getListRetrofit(String baseUrl, Class<T> class_) {
        return retrofitBuilder.addConverterFactory(ListGsonConverterFactory.create(class_)).client(okhttpBuilder.build()).baseUrl(baseUrl).build();
    }

    public Retrofit getRetrofit(String baseUrl) {
        return retrofitBuilder.addConverterFactory(GsonConverterFactory.create()).client(okhttpBuilder.build()).baseUrl(baseUrl).build();
    }
}
