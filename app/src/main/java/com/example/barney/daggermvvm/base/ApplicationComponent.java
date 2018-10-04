package com.example.barney.daggermvvm.base;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @Singleton: Ensure its lifecycle is the apps only lifecycle
 * @Component: We tell it modules to inject
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
})
public interface ApplicationComponent {

    void inject(MyApplication myApplication);
}
