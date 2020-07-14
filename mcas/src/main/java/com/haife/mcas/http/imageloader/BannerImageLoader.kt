package com.haife.mcas.http.imageloader

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.haife.mcas.http.imageloader.glide.GlideArms
import com.youth.banner.loader.ImageLoader

/**
 * Copyright © LingLingYi Technology Company
 *
 * @author Haife
 * @job Android Development
 * Banner ImageLoader
 */
class BannerImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        if (imageView != null) {
            GlideArms.with(context!!.applicationContext)
                    .load(path)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView)
        }

    }

}
