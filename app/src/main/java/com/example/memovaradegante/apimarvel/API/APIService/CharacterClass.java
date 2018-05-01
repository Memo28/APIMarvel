package com.example.memovaradegante.apimarvel.API.APIService;

import com.example.memovaradegante.apimarvel.Models.Character;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Memo Vara De Gante on 29/04/2018.
 */

public interface CharacterClass {

    @GET("characters")
    Call<Character> getCharacter(@Query("ts")String ts, @Query("apikey") String APIKey, @Query("name") String name, @Query("hash") String hash);

}
