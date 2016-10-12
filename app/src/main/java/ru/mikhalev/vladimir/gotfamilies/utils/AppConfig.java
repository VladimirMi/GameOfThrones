package ru.mikhalev.vladimir.gotfamilies.utils;

import android.util.Patterns;

import java.util.regex.Pattern;

public interface AppConfig {
    // URL
    String BASE_URL = "";

    // Time configs
    long MAX_CONNECT_TIMEOUT = 15_000;
    long MAX_READ_TIMEOUT = 15_000;
    long SEARCH_DELAY = 1000;
}
