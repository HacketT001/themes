package com.example.boyko.themes.factory;

import android.content.Context;

import com.example.boyko.themes.R;

/**
 * Created by boyko on 24.12.2017.
 */

public class CustomCheckBoxDarkTheme extends android.support.v7.widget.AppCompatCheckBox implements CustomCheckBox {

    public CustomCheckBoxDarkTheme(Context context) {
        super(context);
        //(getResources().getColor(R.color.colorNightAccent));
        setTextColor(getResources().getColor(R.color.colorNightWhire));
        setText("DARK THEME");
    }
}
