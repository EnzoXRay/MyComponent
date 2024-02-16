package com.example.comp;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hm.lifecycle.api.ApplicationLifecycleManager;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("App", "onCreate");
        if(BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        ApplicationLifecycleManager.init();
        ApplicationLifecycleManager.onCreate(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        ApplicationLifecycleManager.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        ApplicationLifecycleManager.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        ApplicationLifecycleManager.onTrimMemory(level);
    }

}
