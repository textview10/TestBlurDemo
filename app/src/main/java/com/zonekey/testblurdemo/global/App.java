package com.zonekey.testblurdemo.global;

import android.app.Application;

import com.wonderkiln.blurkit.BlurKit;

/**
 * Created by xu.wang
 * Date on  2018/3/5 09:40:48.
 *
 * @Desc
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BlurKit.init(this);
    }
}
