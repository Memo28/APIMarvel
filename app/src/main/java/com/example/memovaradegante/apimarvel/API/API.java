package com.example.memovaradegante.apimarvel.API;

import com.example.memovaradegante.apimarvel.Deserializers.MyDeserializer;
import com.example.memovaradegante.apimarvel.Models.Character;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Memo Vara De Gante on 29/04/2018.
 */

public class API {

    public static final String APIKey = "5728cca78585bac6616b51f9760fc451";
    public static final String Ts = "1";
    public static final String Hash = "ddb7edab259e9df433f1ea374ba602b9";
    public static final String BASE_URL = "https://gateway.marvel.com:443/v1/public/";
    public static Retrofit retrofit = null;

    public static Retrofit getAPI(){
        if(retrofit == null){
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Character.class,new MyDeserializer());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }
}
