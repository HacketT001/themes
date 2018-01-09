package com.example.boyko.themes.di.provides;

import android.content.Context;

/**
 * Created by boyko on 27.12.2017.
 */

public class Realm {
    private Context context;

    public Realm(Context context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Context: "+ context;
    }
}
