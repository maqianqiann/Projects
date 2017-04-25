package com.ken.test.app;

import android.app.Application;
import android.os.Build;
import android.view.View;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by lenovo on 2017/4/22.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());

    }

}

