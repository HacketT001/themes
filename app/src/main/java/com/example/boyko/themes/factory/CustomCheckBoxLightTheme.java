package com.example.boyko.themes.factory;

import android.content.Context;

import com.example.boyko.themes.R;

/**
 * Created by boyko on 24.12.2017.
 */

public class CustomCheckBoxLightTheme extends android.support.v7.widget.AppCompatCheckBox implements CustomCheckBox {

    public CustomCheckBoxLightTheme(Context context) {
        super(context);
        setTextColor(getResources().getColor(R.color.colorNightPrimary));
        setText("Light Theme");
    }
}