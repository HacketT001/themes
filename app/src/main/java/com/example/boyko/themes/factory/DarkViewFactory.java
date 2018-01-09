package com.example.boyko.themes.factory;

import android.content.Context;

/**
 * Created by boyko on 24.12.2017.
 */

public class DarkViewFactory implements ViewFactory {
    private Context context;
    public DarkViewFactory(Context context){
        this.context = context;
    }
    @Override
    public CustomButton createButton() {
        return new ButtonDarkTheme(context);
    }

    @Override
    public CustomCheckBox createCheckBox() {
        return  new CustomCheckBoxDarkTheme(context);
    }
}
