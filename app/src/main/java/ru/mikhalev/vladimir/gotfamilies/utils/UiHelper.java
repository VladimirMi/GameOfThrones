package ru.mikhalev.vladimir.gotfamilies.utils;


import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class UiHelper {
    public static void setHouseIcon(final Context context, final int path, final ImageView view) {
        Picasso.with(context)
                .load(path)
                .fit()
                .centerCrop()
                .into(view);
    }
}