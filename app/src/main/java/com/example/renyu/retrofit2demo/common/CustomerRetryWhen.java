package com.example.renyu.retrofit2demo.common;

import android.util.Log;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by Clevo on 2016/7/22.
 */
public class CustomerRetryWhen implements Func1<Observable<? extends Throwable>, Observable<?>> {

    int retryTimes=3;
    int timeExtra=5;

    public CustomerRetryWhen(int retryTimes, int timeExtra) {
        this.retryTimes=retryTimes;
        this.timeExtra=timeExtra;
    }

    @Override
    public Observable<?> call(Observable<? extends Throwable> observable) {
        return observable.zipWith(Observable.range(1, retryTimes + 1), new Func2<Throwable, Integer, Object>() {
            @Override
            public Object call(Throwable throwable, Integer integer) {
                return new CombineClass(throwable, integer);
            }
        }).flatMap(new Func1<Object, Observable<?>>() {
            @Override
            public Observable<?> call(Object o) {
                CombineClass combineClass=(CombineClass) o;
                if (combineClass.throwable instanceof ConnectException
                        || combineClass.throwable instanceof SocketTimeoutException
                        || combineClass.throwable instanceof TimeoutException
                        || combineClass.integer.intValue()<retryTimes + 1) {
                    Log.d("CustomerRetryWhen", "重试");
                    return Observable.timer(timeExtra, TimeUnit.SECONDS);
                }
                return Observable.error(combineClass.throwable);
            }
        });
    }

    public class CombineClass {

        Throwable throwable;
        Integer integer;

        public CombineClass(Throwable throwable, Integer integer) {
            this.throwable=throwable;
            this.integer=integer;
        }
    }
}
