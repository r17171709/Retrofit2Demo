package com.example.renyu.retrofit2demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.renyu.retrofit2demo.model.ActivityLifeCycle;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by Clevo on 2016/7/24.
 */
public class BaseActivity extends AppCompatActivity {

    List<LifeCircleClass> lifeCircleClasses;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifeCircleClasses=new ArrayList<>();
    }

    public class LifeCircleClass {
        Subscription subscription;
        ActivityLifeCycle lifeCycle;

        public LifeCircleClass(Subscription subscription, ActivityLifeCycle lifeCycle) {
            this.subscription = subscription;
            this.lifeCycle = lifeCycle;
        }
    }

    public void addSubscription(Subscription subscription, ActivityLifeCycle lifeCycle) {
        LifeCircleClass circleClass=new LifeCircleClass(subscription, lifeCycle);
        lifeCircleClasses.add(circleClass);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        for (LifeCircleClass lifeCircleClass : lifeCircleClasses) {
            if (lifeCircleClass.lifeCycle==ActivityLifeCycle.OnDestroy) {
                lifeCircleClass.subscription.unsubscribe();
            }
        }
    }
}
