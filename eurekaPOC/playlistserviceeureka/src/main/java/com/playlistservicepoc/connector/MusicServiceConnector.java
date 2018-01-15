package com.playlistservicepoc.connector;

import com.playlistservicepoc.exception.APINotFoundException;
import com.playlistservicepoc.model.MusicModel;
import com.playlistservicepoc.parse.Parser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MusicServiceConnector {

    @Autowired
    OkHttpClient client;

    @Autowired
    Parser parser;

    public MusicModel run(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response responses = client.newCall(request).execute();
            return parser.convertJsonToPersonModel(responses.body().string());
        } catch (IOException e) {
            throw new APINotFoundException();
        }
    }
}