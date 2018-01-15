package com.playlistservicepoc.parse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.playlistservicepoc.model.MusicModel;
import org.springframework.stereotype.Component;

@Component
public class Parser {
    public MusicModel convertJsonToPersonModel(String jsonString) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, MusicModel.class);
    }
}
