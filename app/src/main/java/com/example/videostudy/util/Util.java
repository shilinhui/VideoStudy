package com.example.videostudy.util;

import android.content.Context;
import android.view.WindowManager;

public class Util {

    public static int getScreenShowWidth(Context context){
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
    }

    public static int getScreenShowHeight(Context context){
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight();
    }
}
