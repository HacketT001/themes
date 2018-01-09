package com.example.boyko.themes.di;

import com.example.boyko.themes.MainActivity;
import com.example.boyko.themes.SecondActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by boyko on 27.12.2017.
 */


@Component(modules = {AppModule.class, UtilModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(SecondActivity secondActivity);
}
