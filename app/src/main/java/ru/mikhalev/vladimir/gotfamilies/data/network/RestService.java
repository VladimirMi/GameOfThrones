package ru.mikhalev.vladimir.gotfamilies.data.network;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface RestService {
    @GET("houses/{houseId}")
    Call<HouseModelResponse> getHouse(@Path("houseId") String houseId);

    @GET("characters/{characterId}")
    Call<CharacterModelResponse> getCharacter(@Path("characterId") String characterId);


    @GET("characters")
    Call<List<CharacterModelResponse>> getCharacters(@QueryMap Map<String, String> option);

    @GET("houses")
    Call<List<HouseModelResponse>> getHouses(@QueryMap Map<String, String> options);
}

