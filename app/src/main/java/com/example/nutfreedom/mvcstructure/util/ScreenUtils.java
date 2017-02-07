package com.example.nutfreedom.mvcstructure.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

public class ScreenUtils {

    private static ScreenUtils instance;

    public static ScreenUtils getInstance() {
        if (instance == null)
            instance = new ScreenUtils();
        return instance;
    }

    private Context mContext;

    private ScreenUtils() {
        mContext = Contextor.getInstance().getContext();
    }

    public int getScreenWidth() {
        Point size = getScreen();
        return size.x;
    }

    public int getScreenHeight() {
        Point size = getScreen();
        return size.y;
    }

    private Point getScreen() {
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

}
