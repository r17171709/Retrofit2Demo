package com.example.renyu.retrofit2demo;

import android.os.Environment;
import android.os.Bundle;
import android.util.Log;

import com.example.renyu.retrofit2demo.common.CustomerRetryWhen;
import com.example.renyu.retrofit2demo.common.LifeCircleOperator;
import com.example.renyu.retrofit2demo.common.ProgressRequestBody;
import com.example.renyu.retrofit2demo.common.RequestInterceptor;
import com.example.renyu.retrofit2demo.common.Retrofit2Utils;
import com.example.renyu.retrofit2demo.impl.FileDownloadApi;
import com.example.renyu.retrofit2demo.impl.FileUploadApi;
import com.example.renyu.retrofit2demo.impl.GameApi;
import com.example.renyu.retrofit2demo.impl.GankioApi;
import com.example.renyu.retrofit2demo.impl.HomePageByBranchIdApi;
import com.example.renyu.retrofit2demo.impl.MovieApi;
import com.example.renyu.retrofit2demo.impl.SendMessageApi;
import com.example.renyu.retrofit2demo.impl.UpdateApi;
import com.example.renyu.retrofit2demo.impl.WeatherApi;
import com.example.renyu.retrofit2demo.model.ActivityLifeCycle;
import com.example.renyu.retrofit2demo.model.BranchInfoModel;
import com.example.renyu.retrofit2demo.model.GameModel;
import com.example.renyu.retrofit2demo.model.GankioModel;
import com.example.renyu.retrofit2demo.model.MovieModel;
import com.example.renyu.retrofit2demo.model.MoviePostModel;
import com.example.renyu.retrofit2demo.model.SendMessageModel;
import com.example.renyu.retrofit2demo.model.UpdateModel;
import com.example.renyu.retrofit2demo.model.WeatherModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/retrofit2demo");
        if (!file.exists()) {
            file.mkdirs();
        }

        //Get请求范例
        getDemo();
        //Post请求范例
//        postDemo();
        //Get请求范例
//        getWithPathDemo();
        //上传文件范例
//        uploadFile();
        //自定义解析范例
//        getGames();
        //文件下载范例
//        downloadDemo();
        //通用参数设置范例
//        commonRequest();
//        getHomePageByBranchIdApi();
        //通过拦截器添加数据
//        addInterceptorParams();
    }

    private void commonRequest() {
        SendMessageApi api=Retrofit2Utils.getInstance().getRetrofit("http://zk.house365.com:8008/").create(SendMessageApi.class);
        subscription = api.getSendMessage("Api/SVTask/sendMessage", "84", "195", "SB")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SendMessageModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(SendMessageModel sendMessageModel) {
                        Log.d("MainActivity", sendMessageModel.getData().getMsg());
                    }
                });
    }

    private void getDemo() {
        Retrofit2Utils retrofit2Utils=Retrofit2Utils.getInstance();
        retrofit2Utils.enableCache(false, this);
        WeatherApi api = retrofit2Utils.getRetrofit("http://apis.baidu.com/apistore/").create(WeatherApi.class);
        api.getWeatherModels("a7802d983b3d58ed6e70ed71bb0c7f14", "南京")
                .retryWhen(new CustomerRetryWhen(3, 5)) //重连功能
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .lift(new LifeCircleOperator(this, ActivityLifeCycle.OnDestroy))
                .subscribe(new Subscriber<WeatherModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
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
        MovieApi api = Retrofit2Utils.getInstance().getRetrofit("http://apis.baidu.com/baidu_openkg/").create(MovieApi.class);
        MoviePostModel postModel = new MoviePostModel();
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
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(MovieModel movieModel) {
                        Log.d("MainActivity", "movieModel.getData().size():" + movieModel.getData().size());
                    }
                });
    }

    private void getWithPathDemo() {
        GankioApi api = Retrofit2Utils.getInstance().getRetrofit("http://gank.io/api/data/").create(GankioApi.class);
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

    private void uploadFile() {
        String token = "09oMsbnJYREss4vRGdGeurO-C7WhTPHnlLyy-6e5:J8V1qHXvDR51PDN5YaAqHIh9eHc=:eyJzY29wZSI6ImFwcGltYWdlIiwiY2FsbGJhY2tVcmwiOiJodHRwOi8vYXBwYXBpLmlpdGUuY2M6ODA4MC9pdGVldGgvY29tbW9uL3Fpbml1Y2FsbGJhY2siLCJkZWFkbGluZSI6MTc3NDA5OTQ2NCwiY2FsbGJhY2tCb2R5Ijoia2V5XHUwMDNkJChrZXkpXHUwMDI2aGFzaFx1MDAzZCQoZXRhZylcdTAwMjZqc29uQm9keVx1MDAzZCQoeDpqc29uQm9keSkifQ==";
        Map<String, RequestBody> params = new HashMap<>();
        RequestBody body = RequestBody.create(MediaType.parse("image/jpeg"), new File(Environment.getExternalStorageDirectory().getPath() + "/PictureTest/saveTemp.jpg"));
        params.put("file", new ProgressRequestBody(body, new ProgressRequestBody.OkHttpProgressListener() {
            @Override
            public void onProgress(long currentBytesCount, long totalBytesCount) {
                Log.d("MainActivity", currentBytesCount + " " + totalBytesCount);
            }
        }));
        params.put("token", RequestBody.create(MediaType.parse("text/plain"), token));
        params.put("x:jsonbody", RequestBody.create(MediaType.parse("text/plain"), "{}"));
        FileUploadApi api = Retrofit2Utils.getInstance().getRetrofit("http://upload.qiniu.com/").create(FileUploadApi.class);
        api.uploadImage(params).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("MainActivity", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getGames() {
        Retrofit2Utils retrofit2Utils=Retrofit2Utils.getInstance();
        retrofit2Utils.addExtraInterceptor(new RequestInterceptor());
        GameApi api = retrofit2Utils.getListRetrofit("http://nbaplus.sinaapp.com", GameModel.class).create(GameApi.class);
        api.getGames("2016-04-04")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<GameModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<GameModel> gameModels) {
                        Log.d("MainActivity", "gameModels.size():" + gameModels.size());
                    }
                });
    }

    InputStream is;
    FileOutputStream fos;

    public void downloadDemo() {
        Retrofit2Utils retrofit2Utils=Retrofit2Utils.getInstance();
        final FileDownloadApi api = retrofit2Utils.getRetrofit("http://7b1g8u.com1.z0.glb.clouddn.com").create(FileDownloadApi.class);
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Response<ResponseBody> response=api.downloadFileWithFixedUrl("http://7b1g8u.com1.z0.glb.clouddn.com/app_newkey_release_8_4.apk").execute();
                    try {
                        if (response != null && response.isSuccessful()) {
                            //文件总长度
                            long fileSize = response.body().contentLength();
                            long fileSizeDownloaded = 0;
                            is = response.body().byteStream();
                            File file = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "app_newkey_release_8_4.apk");
                            if (file.exists()) {
                                file.delete();
                            } else {
                                file.createNewFile();
                            }
                            fos = new FileOutputStream(file);
                            int count = 0;
                            byte[] buffer = new byte[1024];
                            while ((count = is.read(buffer)) != -1) {
                                fos.write(buffer, 0, count);
                                fileSizeDownloaded += count;
                                subscriber.onNext("file download: " + fileSizeDownloaded + " of " + fileSize);
                            }
                            fos.flush();
                            subscriber.onCompleted();
                        } else {
                            subscriber.onError(new Exception("接口请求异常"));
                        }
                    } catch (Exception e) {
                        subscriber.onError(e);
                    } finally {
                        if (is != null) {
                            try {
                                is.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .sample(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d("MainActivity", "文件下载完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("MainActivity", s);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription != null)
            subscription.unsubscribe();
    }

    public void getHomePageByBranchIdApi() {
        HomePageByBranchIdApi api = Retrofit2Utils.getInstance().getListRetrofit("https://api.life.youlanw.com/", BranchInfoModel.class).create(HomePageByBranchIdApi.class);
        api.getHomePageByBranchId().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<BranchInfoModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(List<BranchInfoModel> branchInfoModels) {
                Log.d("MainActivity", "branchInfoModels.size():" + branchInfoModels.size());
            }
        });
    }

    public void addInterceptorParams() {
        Retrofit2Utils retrofit2Utils=Retrofit2Utils.getInstance();
        retrofit2Utils.addExtraInterceptor(new RequestInterceptor());
        Map<String, String> maps=new HashMap<>();
        UpdateApi api=retrofit2Utils.getRetrofit("http://appapi.iite.cc:8080/iteeth/").create(UpdateApi.class);
        api.getUpdateModel(maps).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<UpdateModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(UpdateModel updateModel) {
                Log.d("MainActivity", updateModel.getData().getTitle() + " " + updateModel.getData().getContent());
            }
        });
    }
}
