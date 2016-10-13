package ru.mikhalev.vladimir.gotfamilies.utils;


import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ru.mikhalev.vladimir.gotfamilies.R;
import ru.mikhalev.vladimir.gotfamilies.ui.activities.CharacterActivity;

public class UiHelper {

    public static void setHouseIcon(final Context context, final int imageRes, final ImageView view) {
        Picasso.with(context)
                .load(imageRes)
                .fit()
                .centerCrop()
                .into(view);
    }

    public static void setHouseImage(Context context, int imageRes, ImageView view) {
        Picasso.with(context)
                .load(imageRes)
                .into(view);
    }
}