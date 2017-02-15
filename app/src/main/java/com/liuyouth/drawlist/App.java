package com.liuyouth.drawlist;

import android.app.Application;

import com.liuyouth.drawlist.utils.Utils;

/**
 * Created by liubo on 2017/2/15.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
