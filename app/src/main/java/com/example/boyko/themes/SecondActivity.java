package com.example.boyko.themes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.boyko.themes.R;
import com.example.boyko.themes.di.AppComponent;
import com.example.boyko.themes.di.AppModule;
import com.example.boyko.themes.di.DaggerAppComponent;
import com.example.boyko.themes.di.UtilModule;
import com.example.boyko.themes.di.provides.DataBaseHelper;
import com.example.boyko.themes.di.provides.NetworkClass;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    @Inject
    DataBaseHelper dataBaseHelper;
    @Inject
    NetworkClass networkClass;

    private AppComponent appComponent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        appComponent = buildAppComponent();
        appComponent.inject(this);


        System.out.println("toString "+ dataBaseHelper +" "+ networkClass);

    }

    private AppComponent buildAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .utilModule(new UtilModule())
                .build();
    }
}
