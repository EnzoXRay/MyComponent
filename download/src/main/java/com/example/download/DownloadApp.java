package com.example.download;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class DownloadApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
