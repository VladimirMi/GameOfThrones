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

    List<Integer> houseIds = Arrays.asList(362, 229, 378);
    List<Integer> houseIconRes = Arrays.asList(R.drawable.stark_icon, R.drawable.lanister_icon, R.drawable.targaryen_icon);

    // Time configs
    long MAX_CONNECT_TIMEOUT = 15_000;
    long MAX_READ_TIMEOUT = 15_000;

    int pages = 43;
    int pageSize = 50;
}
