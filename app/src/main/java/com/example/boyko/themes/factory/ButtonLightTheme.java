package com.example.boyko.themes.factory;

import android.content.Context;

import com.example.boyko.themes.R;

/**
 * Created by boyko on 24.12.2017.
 */

public class ButtonLightTheme extends android.support.v7.widget.AppCompatButton implements CustomButton {

    public ButtonLightTheme(Context context) {
        super(context);
        setBackgroundColor(getResources().getColor(R.color.colorAccent));
        setTextColor(getResources().getColor(R.color.colorNightWhire));
        setText("LIGHT THEME");
    }

}
