package com.haife.mcas.integration.lifecycle;

import android.app.Activity;

import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;

/**
 * Copyright © KaiWu Technology Company
 *
 * @author Haife
 * @job Android Development
 * @company KW | 开物科技
 * @time 2019/7/1
 * @desc 让 {@link Activity} 实现此接口,即可正常使用 {@link RxLifecycle} 不需要改动 框架已自动实现
 */
public interface ActivityLifecycleable extends Lifecycleable<ActivityEvent> {
}
