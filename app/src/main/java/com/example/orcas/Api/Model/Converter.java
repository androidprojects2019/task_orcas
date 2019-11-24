package com.example.orcas.Api.Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
 import java.util.List;

import androidx.room.TypeConverter;

public class Converter implements Serializable {

    @TypeConverter // note this annotation
    public String fromSquadItemList(List<SquadItem> squadItems) {
        if (squadItems == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<SquadItem>>() {
        }.getType();
        String json = gson.toJson(squadItems, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<SquadItem> toSquadItemList(String squadValuesString) {
        if (squadValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<SquadItem>>() {
        }.getType();
        List<SquadItem> productCategoriesList = gson.fromJson(squadValuesString, type);
        return productCategoriesList;
    }

}
