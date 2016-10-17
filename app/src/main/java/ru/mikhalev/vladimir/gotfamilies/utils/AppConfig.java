package ru.mikhalev.vladimir.gotfamilies.utils;

import java.util.Arrays;
import java.util.List;

import ru.mikhalev.vladimir.gotfamilies.R;

public interface AppConfig {
    // URL
    String BASE_URL = "http://www.anapioficeandfire.com/api/";

    // 444 max id, 3 elements
    List<Integer> HOUSE_IDS = Arrays.asList(
            ConstantManager.STARK_ID,
            ConstantManager.LANISTER_ID,
            ConstantManager.TARGARYEN_ID);

    List<Integer> HOUSE_ICON_RES = Arrays.asList(
            R.drawable.stark_icon,
            R.drawable.lanister_icon,
            R.drawable.targaryen_icon);

    List<Integer> HOUSE_IMAGE_RES = Arrays.asList(
            R.drawable.stark,
            R.drawable.lanister,
            R.drawable.targaryen);

    int DEFAULT_IMAGE = R.drawable.got_logo;

    // Time configs
    long MAX_CONNECT_TIMEOUT = 15_000;
    long MAX_READ_TIMEOUT = 15_000;


    int HOUSE_PAGES = 9;
    int CHARACTER_PAGES = 43;
    int PAGE_SIZE = 50;
}
