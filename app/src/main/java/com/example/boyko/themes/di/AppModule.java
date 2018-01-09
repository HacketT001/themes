package com.example.boyko.themes.di;

import android.content.Context;

import com.example.boyko.themes.di.provides.Realm;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by boyko on 27.12.2017.
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Realm getRealm(Context context) {
        return new Realm(context);
    }

    @Singleton
    @Provides
    public Context getContext() {
        return context;
    }
}
