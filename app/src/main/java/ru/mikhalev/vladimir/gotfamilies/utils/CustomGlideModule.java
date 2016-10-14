package ru.mikhalev.vladimir.gotfamilies.utils;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

import ru.mikhalev.vladimir.gotfamilies.data.managers.DataManager;

public class CustomGlideModule implements GlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();
        int customBitmapPoolSize = 2 * defaultBitmapPoolSize;
        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));

        int cacheSize100MegaBytes = 104857600;

        builder.setDiskCache(
                new DiskLruCacheFactory(DataManager.getInstance().getContext().getCacheDir().getPath(), cacheSize100MegaBytes));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        // register ModelLoaders here.
    }

    public static void setImage(Context context, int imageRes, ImageView view) {
        Glide.with(context)
                .load(imageRes)
                .centerCrop()
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(view);
    }
}