package com.example.barney.daggermvvm.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * This is a provider of dependencies
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    /**
     * Constructor that takes in app instance
     * @param application instance of android app, so we can provide
     *                    application context
     */
    ApplicationModule(Application application) {
        this.mApplication = application;
    }

    /**
     * Tell dagger that this method provides a dependency
     */
    @Provides
    Context provideApplicationContext() {
        return mApplication;
    }
}
