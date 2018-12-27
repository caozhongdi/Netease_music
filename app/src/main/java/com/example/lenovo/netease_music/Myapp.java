package com.example.lenovo.netease_music;

import android.app.Application;

import org.xutils.x;

/**
 * Created by lenovo on 2018/12/8.
 */

public class Myapp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
