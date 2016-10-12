package ru.mikhalev.vladimir.gotfamilies.data.managers;

import android.content.Context;

import retrofit2.Call;
import ru.mikhalev.vladimir.gotfamilies.data.network.CharacterModelResponse;
import ru.mikhalev.vladimir.gotfamilies.data.network.HouseModelResponse;
import ru.mikhalev.vladimir.gotfamilies.data.network.RestService;
import ru.mikhalev.vladimir.gotfamilies.data.network.ServiceGenerator;
import ru.mikhalev.vladimir.gotfamilies.data.storage.DaoSession;

public class DataManager {
    private static DataManager ourInstance;
    private Context mContext;
    private RestService mRestService;
    private DaoSession mDaoSession;

    private DataManager() {
        mContext = GotfamilyApplication.getAppContext();
        mRestService = ServiceGenerator.createService(RestService.class);
        mDaoSession = GotfamilyApplication.getDaoSession();

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

    public Call<HouseModelResponse> getHouseFromNet(String houseId) {
        return mRestService.getHouse(houseId);
    }

    public Call<CharacterModelResponse> getCharacterFromNet(String characterId) {
        return mRestService.getCharacter(characterId);
    }

    // endregion

    // region =========== Database ===========

    // endregion
}
