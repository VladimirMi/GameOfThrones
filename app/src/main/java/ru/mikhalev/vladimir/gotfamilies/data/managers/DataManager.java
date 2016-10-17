package ru.mikhalev.vladimir.gotfamilies.data.managers;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import ru.mikhalev.vladimir.gotfamilies.data.network.CharacterModelResponse;
import ru.mikhalev.vladimir.gotfamilies.data.network.HouseModelResponse;
import ru.mikhalev.vladimir.gotfamilies.data.network.RestService;
import ru.mikhalev.vladimir.gotfamilies.data.network.ServiceGenerator;
import ru.mikhalev.vladimir.gotfamilies.data.storage.Character;
import ru.mikhalev.vladimir.gotfamilies.data.storage.CharacterDao;
import ru.mikhalev.vladimir.gotfamilies.data.storage.DaoSession;
import ru.mikhalev.vladimir.gotfamilies.data.storage.House;
import ru.mikhalev.vladimir.gotfamilies.data.storage.HouseDao;
import ru.mikhalev.vladimir.gotfamilies.utils.AppConfig;

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

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public Context getContext() {
        return mContext;
    }

    // region =========== Network ============

    public Call<HouseModelResponse> getHouseFromNet(Integer houseId) {
        return mRestService.getHouse(houseId.toString());
    }

    public Call<List<HouseModelResponse>> getHousesFromNet(int page) {
        Map<String, String> options = new HashMap<>();
        options.put("page", String.valueOf(page));
        options.put("pageSize", String.valueOf(AppConfig.PAGE_SIZE));
        return mRestService.getHouses(options);
    }

    public Call<List<CharacterModelResponse>> getCharactersFromNet(int page) {
        Map<String, String> options = new HashMap<>();
        options.put("page", String.valueOf(page));
        options.put("pageSize", String.valueOf(AppConfig.PAGE_SIZE));
        return mRestService.getCharacters(options);
    }

    public Call<CharacterModelResponse> getCharacterFromNet(Integer characterId) {
        return mRestService.getCharacter(characterId.toString());
    }

    // endregion

    // region =========== Database ===========

    public Character getCharacterFromDB(int id) {
        Character character = mDaoSession.queryBuilder(Character.class)
                .where(CharacterDao.Properties.Id.eq(id))
                .build()
                .unique();
        return character;
    }

    public List<Character> getCharactersForHouse(int houseId) {
        List<Character> characters = new ArrayList<>();

        return characters = mDaoSession.queryBuilder(Character.class)
                .where(CharacterDao.Properties.HouseId.eq(houseId))
                .orderAsc(CharacterDao.Properties.Id)
                .build()
                .list();
    }

    public List<Character> getCharactersFromDB() {
        List<Character> characters = new ArrayList<>();
        return characters = mDaoSession.queryBuilder(Character.class)
                .build()
                .list();
    }


    public House getHouseFromDB(int id) {
        House house = mDaoSession.queryBuilder(House.class)
                .where(HouseDao.Properties.Id.eq(id))
                .build()
                .unique();
        return house;
    }

    // endregion
}
