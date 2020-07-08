package com.haife.mcas.base.delegate;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;


/**
 * Copyright © KaiWu Technology Company
 *
 * @author Haife
 * @job Android Development
 * @company KW | 开物科技
 * @time 2019/7/1
 * @desc 用于代理 {@link Application} 的生命周期
 * @see AppDelegate
 */
public interface AppLifecycles {
    void attachBaseContext(@NonNull Context base);

    void onCreate(@NonNull Application application);

    void onTerminate(@NonNull Application application);
}
