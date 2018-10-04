package com.example.barney.daggermvvm.di;

import android.app.Activity;

import com.bluelinelabs.conductor.Controller;
import com.example.barney.daggermvvm.base.BaseActivity;

/**
 * Cls with static methods for injecting our activities
 * into screens
 */
public class Injector {

    private Injector() {

    }

    public static void inject(Activity activity) {
        ActivityInjector.get(activity).inject(activity);
    }

    public static void clearComponent(Activity activity) {
        ActivityInjector.get(activity).clear(activity);
    }

    public static void inject(Controller controller) {
        ScreenInjector.get(controller.getActivity()).inject(controller);
    }

    public static void clearComponent(Controller controller) {
        ScreenInjector.get(controller.getActivity()).clear(controller);
    }
}
