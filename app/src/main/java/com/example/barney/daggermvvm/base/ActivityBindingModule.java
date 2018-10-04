package com.example.barney.daggermvvm.base;

import android.app.Activity;

import com.example.barney.daggermvvm.home.MainActivity;
import com.example.barney.daggermvvm.home.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        MainActivityComponent.class,
})
public abstract class ActivityBindingModule {

    // method that provides an injector for this activity (MainActivity)
    // Bind takes argument of a method and returns it as a return type
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> providesMainActivityInjector(MainActivityComponent.Builder builder);
}
