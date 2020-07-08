package com.haife.mcas.http.imageloader;


import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Incremental change is better than ambitious failure.
 * @desc :0对应DiskCacheStrategy.all,1对应DiskCacheStrategy.NONE,2对应DiskCacheStrategy.SOURCE,3对应DiskCacheStrategy.RESULT
 *        see {@link com.bumptech.glide.load.engine.DiskCacheStrategy}
 */

public interface CacheStrategy {



    int ALL = 0;

    int NONE  = 1;

    int RESOURCE  = 2;

    int DATA  = 3;

    int AUTOMATIC  = 4;

    @IntDef({ALL,NONE,RESOURCE,DATA,AUTOMATIC})
    @Retention(RetentionPolicy.SOURCE)
    @interface Strategy{}

}