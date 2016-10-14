package ru.mikhalev.vladimir.gotfamilies.utils;

import android.util.Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import ru.mikhalev.vladimir.gotfamilies.R;

public interface AppConfig {
    // URL
    String BASE_URL = "http://www.anapioficeandfire.com/api/";

    // 444 max id
    List<Integer> houseIds = Arrays.asList(229, 362, 378);

    List<Integer> houseIconRes = Arrays.asList(
            R.drawable.stark_icon,
            R.drawable.lanister_icon,
            R.drawable.targaryen_icon);

    List<Integer> houseImageRes = Arrays.asList(
            R.drawable.stark,
            R.drawable.lanister,
            R.drawable.targaryen,
            R.drawable.got_logo);

    // Time configs
    long MAX_CONNECT_TIMEOUT = 15_000;
    long MAX_READ_TIMEOUT = 15_000;

    int housePages = 9;
    int characterPages = 43;
    int pageSize = 50;
}
