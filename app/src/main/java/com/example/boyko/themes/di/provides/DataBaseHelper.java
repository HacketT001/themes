package com.example.boyko.themes.di.provides;

/**
 * Created by boyko on 27.12.2017.
 */

public class DataBaseHelper {
    private Realm realm;

    public DataBaseHelper(Realm realm) {
        this.realm = realm;
    }

    @Override
    public String toString() {
        return realm.toString() + " DATABASEHELPER";
    }
}
