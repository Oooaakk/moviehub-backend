package com.example.moviehub.util;

import com.example.moviehub.collection.JWTSubject;
import com.google.gson.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class JsonUtil {


    public static String toJsonString(String message){
        JsonObject response = new JsonObject();
        response.addProperty("message", message);
        return response.toString();
    }

    public static String toJsonString(String message, Object data){
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("body", data);
        return gson.toJson(map);
    }

    public static String toJsonString(Object data){
        Gson gson = new Gson();
        return gson.toJson(data);
    }

    public static JWTSubject parseJson(String jsonString){
        Gson gson = new Gson();
        JWTSubject subject = gson.fromJson(jsonString, JWTSubject.class);
        return subject;
    }
}
