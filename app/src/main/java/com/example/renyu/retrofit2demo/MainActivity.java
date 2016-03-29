package com.example.renyu.retrofit2demo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.renyu.retrofit2demo.common.Retrofit2Utils;
import com.example.renyu.retrofit2demo.impl.GankioApi;
import com.example.renyu.retrofit2demo.impl.MovieApi;
import com.example.renyu.retrofit2demo.impl.WeatherApi;
import com.example.renyu.retrofit2demo.model.GankioModel;
import com.example.renyu.retrofit2demo.model.MovieModel;
import com.example.renyu.retrofit2demo.model.MoviePostModel;
import com.example.renyu.retrofit2demo.model.WeatherModel;

import java.io.File;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file=new File(Environment.getExternalStorageDirectory().getPath() + "/retrofit2demo");
        if (!file.exists()) {
            file.mkdirs();
        }

//        getDemo();
//        postDemo();
        getWithPathDemo();
    }

    private void getDemo() {
        WeatherApi api=Retrofit2Utils.getInstance(getApplicationContext()).getRetrofit("http://apis.baidu.com/apistore/").create(WeatherApi.class);
        subscription=api.getWeatherModels("a7802d983b3d58ed6e70ed71bb0c7f14", "南京")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(WeatherModel weatherModel) {
                        if (!subscription.isUnsubscribed()) {
                            Log.d("MainActivity", (weatherModel.getRetData().getCity() + " " + weatherModel.getRetData().getDate() + "-" + weatherModel.getRetData().getTime() + " " + weatherModel.getRetData().getWeather()));
                        }
                    }
        });
    }

    private void postDemo() {
        MovieApi api=Retrofit2Utils.getInstance(getApplicationContext()).getRetrofit("http://apis.baidu.com/baidu_openkg/").create(MovieApi.class);
        MoviePostModel postModel=new MoviePostModel();
        postModel.setQuery("虎妈猫爸的最新剧集");
        postModel.setResource("video_haiou");
        api.getMovieLists("a7802d983b3d58ed6e70ed71bb0c7f14", postModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MovieModel movieModel) {
                        Log.d("MainActivity", "movieModel.getData().size():" + movieModel.getData().size());
                    }
                });
    }

    private void getWithPathDemo() {
        GankioApi api=Retrofit2Utils.getInstance(getApplicationContext()).getRetrofit("http://gank.io/api/data/").create(GankioApi.class);
        api.getGankioModels("Android", 10, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GankioModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GankioModel gankioModel) {
                        Log.d("MainActivity", "gankioModel.getResults().size():" + gankioModel.getResults().size());
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription!=null)
        subscription.unsubscribe();
    }
}
