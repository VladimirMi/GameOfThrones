package ru.mikhalev.vladimir.gotfamilies.data.managers;

import android.content.Context;

import ru.mikhalev.vladimir.gotfamilies.data.network.RestService;
import ru.mikhalev.vladimir.gotfamilies.data.network.ServiceGenerator;

public class DataManager {
    private static DataManager ourInstance;
    private Context mContext;
    private RestService mRestService;


    private DataManager() {
        mContext = GotfamilyApplication.getAppContext();
        mRestService = ServiceGenerator.createService(RestService.class);
    }

    public static DataManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataManager();
        }
        return ourInstance;
    }

    public Context getContext() {
        return mContext;
    }

    // region =========== Network ============

    // endregion

    // region =========== Database ===========

    // endregion
}
