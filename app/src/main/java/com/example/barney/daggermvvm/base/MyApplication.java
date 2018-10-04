package com.example.barney.daggermvvm.base;

import android.app.Application;

import com.example.barney.daggermvvm.di.ActivityInjector;

import javax.inject.Inject;

public class MyApplication extends Application {

    @Inject
    ActivityInjector mActivityInjector;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Build component Object. and turn it to a dagger component
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        mApplicationComponent.inject(this);
    }

    public ActivityInjector getActivityInjector() {
        return mActivityInjector;
    }
}
