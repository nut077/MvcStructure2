package com.example.nutfreedom.mvcstructure.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nutfreedom.mvcstructure.R;
import com.example.nutfreedom.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();
        Toast.makeText(MainActivity.this, "Width = " + screenWidth + " Height = " + screenHeight, Toast.LENGTH_SHORT).show();
    }
}
