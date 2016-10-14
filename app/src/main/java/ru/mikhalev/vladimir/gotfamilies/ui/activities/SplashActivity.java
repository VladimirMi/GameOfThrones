package ru.mikhalev.vladimir.gotfamilies.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mikhalev.vladimir.gotfamilies.R;
import ru.mikhalev.vladimir.gotfamilies.data.network.CharacterModelResponse;
import ru.mikhalev.vladimir.gotfamilies.data.network.HouseModelResponse;
import ru.mikhalev.vladimir.gotfamilies.data.storage.Character;
import ru.mikhalev.vladimir.gotfamilies.data.storage.House;
import ru.mikhalev.vladimir.gotfamilies.utils.AppConfig;
import ru.mikhalev.vladimir.gotfamilies.utils.ConstantManager;
import ru.mikhalev.vladimir.gotfamilies.utils.NetworkStatusChecker;

public class SplashActivity extends BaseActivity {
    private static final String TAG = ConstantManager.TAG_PREFIX + "SplashActivity";

    Map<String, String> mCharacterHouseMap = new HashMap<>();
    private List<Character> mCharacters = new ArrayList<>();
    private List<CharacterModelResponse> mCharactersResponse = new ArrayList<>();
    private List<House> mHouses = new ArrayList<>();
    private List<HouseModelResponse> mHousesResponse = new ArrayList<>();
    private boolean isLoading;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);

        Log.d(TAG, "onCreate: " + mDataManager.getCharactersFromDB().size());

        if (mDataManager.getCharactersFromDB().size() == 0) {

            if (NetworkStatusChecker.isNetworkAvaliable(this)) {

                startDelay();
                isLoading = true;
                loadHouses();
                loadCharacters();

            } else {
                showSnackBar(getString(R.string.err_msg_internet));
            }
        } else {
            startDelay();
        }
    }

    private void startDelay() {
        showProgress();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startNextActivity();
            }
        }, 3000);
    }

    private void showSnackBar(String message) {
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    private void loadHouses() {
        for (Integer houseId : AppConfig.houseIds) {
            Call<HouseModelResponse> call = mDataManager.getHouseFromNet(houseId);

            call.enqueue(new Callback<HouseModelResponse>() {
                @Override
                public void onResponse(Call<HouseModelResponse> call, Response<HouseModelResponse> response) {
                    if (response.isSuccessful()) {
                        mHousesResponse.add(response.body());
                    } else {
                        Log.e(TAG, "loadHouse onResponse: " + response.message());
                    }
                }

                @Override
                public void onFailure(Call<HouseModelResponse> call, Throwable t) {
                    Log.e(TAG, "loadHouse onFailure: " + t.getMessage());
                }
            });
        }
    }

    private void loadCharacters() {
        for (int page = 1; page <= AppConfig.pages; page++) {
            Call<List<CharacterModelResponse>> call = mDataManager.getCharactersFromNet(page);

            final int finalPage = page;
            call.enqueue(new Callback<List<CharacterModelResponse>>() {
                @Override
                public void onResponse(Call<List<CharacterModelResponse>> call, Response<List<CharacterModelResponse>> response) {

                    if (response.isSuccessful()) {
                        mCharactersResponse.addAll(response.body());
                        if (finalPage == AppConfig.pages) {
                            saveData();
                        }
                    } else {
                        Log.e(TAG, "loadCharacter onResponse: " + response.message());
                    }
                }

                @Override
                public void onFailure(Call<List<CharacterModelResponse>> call, Throwable t) {
                    Log.e(TAG, "loadCharacter onFailure: " + t.getMessage());
                }
            });
        }


    }

    private void saveData() {
        for (HouseModelResponse houseModelResponse : mHousesResponse) {
            for (String characterUrl : houseModelResponse.getSwornMembers()) {
                mCharacterHouseMap.put(characterUrl, houseModelResponse.getUrl());
            }
            House house = new House(houseModelResponse);
            mHouses.add(house);
        }
        for (CharacterModelResponse characterModelResponse : mCharactersResponse) {
            String houseUrl = mCharacterHouseMap.get(characterModelResponse.getUrl());
            if (houseUrl != null) {
                Character character = new Character(characterModelResponse, houseUrl);
                mCharacters.add(character);
            }
        }
        mHouseDao.insertOrReplaceInTx(mHouses);
        mCharacterDao.insertOrReplaceInTx(mCharacters);

        isLoading = false;
        startNextActivity();
    }

    private void startNextActivity() {
        hideProgress();
        if (!isLoading) {
            Intent startFamiliesActivity = new Intent(this, FamiliesActivity.class);
            startActivity(startFamiliesActivity);
            finish();
        }
    }

}
