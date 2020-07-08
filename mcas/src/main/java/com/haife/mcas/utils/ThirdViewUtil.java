package com.haife.mcas.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.haife.mcas.base.delegate.ActivityDelegate.LAYOUT_FRAMELAYOUT;
import static com.haife.mcas.base.delegate.ActivityDelegate.LAYOUT_LINEARLAYOUT;
import static com.haife.mcas.base.delegate.ActivityDelegate.LAYOUT_RELATIVELAYOUT;


public class ThirdViewUtil {
    private static int HAS_AUTO_LAYOUT_META = 0;

    private ThirdViewUtil() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static Unbinder bindTarget(Object target, Object source) {
        if (source instanceof Activity) {
            return ButterKnife.bind(target, (Activity) source);
        } else if (source instanceof View) {
            return ButterKnife.bind(target, (View) source);
        } else if (source instanceof Dialog) {
            return ButterKnife.bind(target, (Dialog) source);
        } else {
            return Unbinder.EMPTY;
        }
    }

    @Nullable
    public static View convertAutoView(String name, Context context, AttributeSet attrs) {
        if (HAS_AUTO_LAYOUT_META == -1) {
            HAS_AUTO_LAYOUT_META = 1;
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = packageManager.getApplicationInfo(context
                        .getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo == null || applicationInfo.metaData == null
                        || !applicationInfo.metaData.containsKey("design_width")
                        || !applicationInfo.metaData.containsKey("design_height")) {
                    HAS_AUTO_LAYOUT_META = 0;
                }
            } catch (PackageManager.NameNotFoundException e) {
                HAS_AUTO_LAYOUT_META = 0;
            }
        }
        if (HAS_AUTO_LAYOUT_META == 0) {
            return null;
        }
        View view = null;
        if (name.equals(LAYOUT_FRAMELAYOUT)) {
            view = new AutoFrameLayout(context, attrs);
        } else if (name.equals(LAYOUT_LINEARLAYOUT)) {
            view = new AutoLinearLayout(context, attrs);
        } else if (name.equals(LAYOUT_RELATIVELAYOUT)) {
            view = new AutoRelativeLayout(context, attrs);
        }
        return view;
    }
}
