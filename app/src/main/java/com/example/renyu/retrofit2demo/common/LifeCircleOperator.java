package com.example.renyu.retrofit2demo.common;

import com.example.renyu.retrofit2demo.BaseActivity;
import com.example.renyu.retrofit2demo.model.ActivityLifeCycle;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Clevo on 2016/7/24.
 */
public class LifeCircleOperator<T> implements Observable.Operator<T, T> {

    BaseActivity activity;
    ActivityLifeCycle lifeCycle;

    public LifeCircleOperator(BaseActivity activity, ActivityLifeCycle lifeCycle) {
        this.activity=activity;
        this.lifeCycle=lifeCycle;
    }

    @Override
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        activity.addSubscription(subscriber, lifeCycle);
        return subscriber;
    }
}
