package com.example.barney.daggermvvm.home;

import com.example.barney.daggermvvm.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope  // This is the scope of this component
@Subcomponent   // Ensure that it Will be built on top of application component
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    // MainActivity is the injected class
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
