package com.example.barney.daggermvvm.home;

import com.bluelinelabs.conductor.Controller;
import com.example.barney.daggermvvm.di.ControllerKey;
import com.example.barney.daggermvvm.trending.TrendingReposComponent;
import com.example.barney.daggermvvm.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TrendingReposComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller>
        bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}
