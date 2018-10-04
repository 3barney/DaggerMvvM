package com.example.barney.daggermvvm.di;

import com.bluelinelabs.conductor.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import dagger.MapKey;

@MapKey
@Target(ElementType.METHOD) // only makes this usable in methods
public @interface ControllerKey {

    Class<? extends Controller> value();
}
