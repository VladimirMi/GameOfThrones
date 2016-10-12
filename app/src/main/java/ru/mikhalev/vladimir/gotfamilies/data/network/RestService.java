package ru.mikhalev.vladimir.gotfamilies.data.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestService {
    @GET("houses/{houseId}")
    Call<HouseModelResponse> getHouse(@Path("houseId") String houseId);

    @GET("characters/{characterId}")
    Call<CharacterModelResponse> getCharacter(@Path("characterId") String characterId);
}

