package com.safetychina.items_destroyed_wms.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safetychina.items_destroyed_wms.common.JsonLabelAndValue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class StringToJsonUtil {

    public String stringToJsonString(List<String> values){
        List<JsonLabelAndValue> labelAndValues = new ArrayList<>();

        for(String value:values){
            labelAndValues.add(new JsonLabelAndValue(value,value));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(labelAndValues);
    }
}
