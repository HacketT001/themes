package com.example.boyko.themes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.boyko.themes.di.AppComponent;
import com.example.boyko.themes.di.AppModule;
import com.example.boyko.themes.di.DaggerAppComponent;
import com.example.boyko.themes.di.UtilModule;
import com.example.boyko.themes.di.provides.DataBaseHelper;
import com.example.boyko.themes.di.provides.NetworkClass;
import com.example.boyko.themes.factory.CustomButton;
import com.example.boyko.themes.factory.CustomCheckBox;
import com.example.boyko.themes.factory.DarkViewFactory;
import com.example.boyko.themes.factory.LightViewFactory;
import com.example.boyko.themes.factory.ViewFactory;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataBaseHelper helper;
    @Inject
    NetworkClass networkClass;

    private AppComponent component;


    private Button button;
    private boolean isDarkTheme;
    private LinearLayout field;
    private ViewFactory factory;
    private SharedPreferences prefs;

    String REFERENCE_KEY = "THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        component = buildComponent();
        component.inject(this);

        super.onCreate(savedInstanceState);

        prefs = getPreferences(MODE_PRIVATE);
        isDarkTheme = prefs.getBoolean(REFERENCE_KEY, false);
        initTheme();

        setContentView(R.layout.activity_main);

        field = findViewById(R.id.field);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //init by dagger
                System.out.println("toString: ");
                if (helper != null)
                    System.out.println(helper.toString());
                //startActivity(new Intent(MainActivity.this, SecondActivity.class));

                createViews();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_dark) {
            setDarkTheme(true);

        } else if (item.getItemId() == R.id.menu_light) {
            setDarkTheme(false);
        }
        return true;
    }

    public void setDarkTheme(boolean var) {
        if (isDarkTheme != var) {
            SharedPreferences.Editor prefEditor = prefs.edit();
            prefEditor.putBoolean(REFERENCE_KEY, var);
            prefEditor.commit();
            this.recreate();
        }
    }

    public void initTheme() {
        if (isDarkTheme) {
            factory = new DarkViewFactory(this);
            setTheme(R.style.DarkTheme);
        } else {
            factory = new LightViewFactory(this);
            setTheme(R.style.AppTheme);
        }

    }

    public void createViews() {

        CustomButton button = factory.createButton();
        CustomCheckBox checkbox = factory.createCheckBox();

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 10, 20, 10);
        LinearLayout horizontalLayout = new LinearLayout(this);
        horizontalLayout.setLayoutParams(layoutParams);
        horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);

        horizontalLayout.addView((View) button);
        horizontalLayout.addView((View) checkbox);

        field.addView(horizontalLayout);

    }
    ///DAGGER 2

    private AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .utilModule(new UtilModule())
                .build();
    }
}
