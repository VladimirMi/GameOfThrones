package ru.mikhalev.vladimir.gotfamilies.utils;

import android.util.Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public interface AppConfig {
    // URL
    String BASE_URL = "http://www.anapioficeandfire.com/api/";

    List<Integer> houseIds = Arrays.asList(362, 229, 378);

    // Time configs
    long MAX_CONNECT_TIMEOUT = 15_000;
    long MAX_READ_TIMEOUT = 15_000;
}
