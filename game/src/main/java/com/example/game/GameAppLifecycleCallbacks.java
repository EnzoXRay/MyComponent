package com.example.game;

import android.content.Context;
import android.util.Log;

import com.hm.iou.lifecycle.annotation.AppLifecycle;
import com.hm.lifecycle.api.IApplicationLifecycleCallbacks;

@AppLifecycle
public class GameAppLifecycleCallbacks implements IApplicationLifecycleCallbacks {


    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public void onCreate(Context context) {
        Log.i("GameApp", "onCreate");
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }
}
