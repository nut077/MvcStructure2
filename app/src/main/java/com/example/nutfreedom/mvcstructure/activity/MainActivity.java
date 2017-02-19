package com.example.nutfreedom.mvcstructure.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.example.nutfreedom.mvcstructure.R;
import com.example.nutfreedom.mvcstructure.fragment.MainFragment;
import com.example.nutfreedom.mvcstructure.fragment.SecondFragment;
import com.example.nutfreedom.mvcstructure.util.ScreenUtils;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();
        Toast.makeText(MainActivity.this, "Width = " + screenWidth + " Height = " + screenHeight, Toast.LENGTH_SHORT).show();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance(1234), "MainFragment")
                    .commit();

            SecondFragment secondFragment = SecondFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, secondFragment, "SecondFragment")
                    .detach(secondFragment)
                    .commit();
        }
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("MainFragment");
            fragment.setHelloText("Woooo Hoooooooo\nWoooo Hoooooooo\nWoooo Hoooooooo\nWoooo Hoooooooo\nWoooo Hoooooooo\nWoooo Hoooooooo\nWoooo Hoooooooo\nWoooo Hoooooooo\nWoooo Hoooooooo\nWoooo Hoooooooo\nWoooo Hoooooooo");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_secode_fragment: {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);
                if (fragment instanceof SecondFragment == false) {
                    getSupportFragmentManager().beginTransaction()
                            //.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .replace(R.id.contentContainer, SecondFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                }
            }
            case R.id.action_first_tap: {
                MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("MainFragment");
                SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag("SecondFragment");
                getSupportFragmentManager().beginTransaction()
                        .attach(mainFragment)
                        .detach(secondFragment)
                        .commit();
                return true;
            }
            case R.id.action_second_tap: {
                MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("MainFragment");
                SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag("SecondFragment");
                getSupportFragmentManager().beginTransaction()
                        .attach(secondFragment)
                        .detach(mainFragment)
                        .commit();
                return true;
            }
        }
        return true;
    }
}
