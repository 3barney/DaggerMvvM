package com.example.barney.daggermvvm.di;

import android.app.Activity;

import com.bluelinelabs.conductor.Controller;
import com.example.barney.daggermvvm.base.BaseActivity;
import com.example.barney.daggermvvm.base.BaseController;
import com.example.barney.daggermvvm.home.MainActivityComponent;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;

// This is injected many times, since its done by the activity hence need for an annotation
@ActivityScope
public class ScreenInjector {

    private final Map<Class<? extends Controller>, Provider<AndroidInjector<? extends Controller>>> mScreenInjectors;

    // Cache
    private final Map<String, AndroidInjector<Controller>> cache = new HashMap<>();

    @Inject
    ScreenInjector(Map<Class<? extends Controller>, Provider<AndroidInjector<? extends Controller>>> screenInjectors) {

        this.mScreenInjectors = screenInjectors;
    }

    void inject(Controller controller) {
        if (!(controller instanceof BaseController)) {
            throw new IllegalArgumentException("Controller must extend BaseController");
        }

        String instanceId = controller.getInstanceId();

        if (cache.containsKey(instanceId)) {
            cache.get(instanceId).inject(controller);
            return;
        }

        AndroidInjector.Factory<Controller> injectorFactory =
                ((AndroidInjector.Factory<Controller>) mScreenInjectors.get(controller.getClass()).get());
        AndroidInjector<Controller> injector = injectorFactory.create(controller);
        cache.put(instanceId, injector);
    }

    void clear(Controller controller) {
        cache.remove(controller.getInstanceId());
    }

    static ScreenInjector get(Activity activity) {
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalStateException("Controller must be hosted by Base Activity");
        }
        
        return ((BaseActivity) activity).getScreenInjector();
    }
}
