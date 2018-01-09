package com.example.boyko.themes.di;

import com.example.boyko.themes.di.provides.DataBaseHelper;
import com.example.boyko.themes.di.provides.NetworkClass;
import com.example.boyko.themes.di.provides.Realm;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by boyko on 27.12.2017.
 */
@Module
public class UtilModule {

    @Provides
    public DataBaseHelper getHelper(Realm realm){
        return new DataBaseHelper(realm);
    }

    @Singleton
    @Provides
    public NetworkClass getNetworkClass(){
        return new NetworkClass();
    }
}
