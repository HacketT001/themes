package com.example.boyko.themes.factory;

import com.example.boyko.themes.factory.CustomButton;
import com.example.boyko.themes.factory.CustomCheckBox;

/**
 * Created by boyko on 24.12.2017.
 */

public interface ViewFactory {
    public CustomButton createButton();
    public CustomCheckBox createCheckBox();
}
