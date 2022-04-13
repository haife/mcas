package com.haife.mcas.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.haife.mcas.base.App;
import com.haife.mcas.utils.McaUtils;

import static com.haife.mcas.utils.Preconditions.checkNotNull;


/**
 * Copyright © KaiWu Technology Company
 *
 * @author Haife
 * @job Android Development
 * @company KW | 开物科技
 * @time 2019/7/1
 * @desc 框架要求框架中的每个 View 都需要实现此类, 以满足规范
 * * 为了满足部分人的诉求以及向下兼容, {@link IView} 中的部分方法使用 JAVA 1.8 的默认方法实现, 这样实现类可以按实际需求选择是否实现某些方法
 * * 不实现则使用默认方法中的逻辑, 不清楚默认方法的请自行学习
 */
public interface IView {


    /**
     * 显示加载
     */
    default void showLoading() {

    }

    /**
     * 隐藏加载
     */
    default void hideLoading() {

    }

    /**
     * 获取服务器数据
     * @param data 服务器返回的数据
     */
    default void onGetServerEntity(@NonNull Object data){

    }

    /**
     * 显示信息
     *
     * @param message 消息内容, 不能为 {@code null}
     */
    void showMessage(@NonNull String message);

    /**
     * 跳转 {@link Activity}
     *
     * @param intent {@code intent} 不能为 {@code null}
     */
    default void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        McaUtils.startActivity(intent);
    }



    /**
     * 杀死自己
     */
    default void killMyself() {

    }


    default void showGLoading() {
    }
    /**
     * 加载成功
     */
    default void showLoadSuccess() {
    }
    /**
     * 加载成功(带加载数据)
     */
    default void showLoadSuccess(@NonNull Object data) {
    }
    /**
     * 加载失败
     */
    default void showLoadFailed() {
    }
    /**
     * 加载数据为空
     */
    default void showLoadEmpty() {
    }

}
