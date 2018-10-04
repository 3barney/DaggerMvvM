package com.example.barney.daggermvvm.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

// This is an annotation ()
@Scope  // Tell dagger that this is a scope
@Retention(RetentionPolicy.RUNTIME) // Runtime retten, means it wil be retained in final apk

public @interface ActivityScope {
}
