package com.example.memovaradegante.apimarvel.Deserializers;

import android.util.Log;

import com.example.memovaradegante.apimarvel.Models.Character;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Memo Vara De Gante on 29/04/2018.
 */

public class MyDeserializer implements JsonDeserializer<Character> {
    @Override
    public Character deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject base = json.getAsJsonObject().get("data").getAsJsonObject().get("results").getAsJsonArray().get(0).getAsJsonObject();
        String name = base.get("name").getAsString();
        String description = base.get("description").getAsString();
        String image = base.get("thumbnail").getAsJsonObject().get("path").getAsString();
        String extension = base.get("thumbnail").getAsJsonObject().get("extension").getAsString();


        Character character = new Character(name,image,extension,description);
        return character;
    }
}
