package ru.mikhalev.vladimir.gotfamilies.utils;


import android.util.Log;

import java.util.List;

public class Helper {

    public static int getIdFromURL(String url) {
        String id = "";
        if (url != null) {
            id = url.substring(url.lastIndexOf("/") + 1);
        }
        return id.isEmpty() ? 0 : Integer.valueOf(id);
    }

    public static String getShortHouseName(String houseName) {
        String[] strings = houseName.split(" ");
        return strings[1];
    }

    public static String convertToDb(List<String> strings) {
        String result ="";
        for (int i = 0; i < strings.size(); i++) {
            result += strings.get(i);
            if (i != strings.size()-1) {
                result += ", ";
            }
        }
        return result;
    }
}
