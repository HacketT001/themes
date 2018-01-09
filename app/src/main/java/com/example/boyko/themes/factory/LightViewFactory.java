package com.example.boyko.themes.factory;

import android.content.Context;

/**
 * Created by boyko on 24.12.2017.
 */

public class LightViewFactory implements ViewFactory {

    private Context context;

    public LightViewFactory(Context context){
        this.context = context;
    }

    @Override
    public CustomButton createButton() {
        return new ButtonLightTheme(context);
    }

    @Override
    public CustomCheckBox createCheckBox() {
        return new CustomCheckBoxLightTheme(context);
    }
}
