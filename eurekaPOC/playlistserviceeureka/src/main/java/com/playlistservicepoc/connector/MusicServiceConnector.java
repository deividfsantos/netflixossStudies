package com.playlistservicepoc.connector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.playlistservicepoc.model.MusicModel;
import okhttp3.*;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class MusicServiceConnector {

    @Autowired
    OkHttpClient client;

    public MusicModel run(String url) throws IOException, ParseException {

        String jsonString = getJson(url);

        Gson gson = new GsonBuilder().create();
        MusicModel musicModel = new MusicModel();

        return musicModel = gson.fromJson(jsonString, MusicModel.class);
    }

    private String getJson(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response responses = null;

        try {
            responses = client.newCall(request).execute();
        }catch (IOException e){
            e.printStackTrace();
        }

        return responses.body().string();
    }

}