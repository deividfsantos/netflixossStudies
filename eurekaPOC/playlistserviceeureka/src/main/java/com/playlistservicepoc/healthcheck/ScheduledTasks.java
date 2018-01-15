package com.playlistservicepoc.healthcheck;

import java.io.IOException;

import com.playlistservicepoc.eureka.EurekaModelRegistry;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    EurekaModelRegistry eurekaModelRegistry;

    @Autowired
    OkHttpClient client;

    private final static String URL =  "http://localhost:8080/eureka/v2/apps/playlistservice/";

    private final static String MEDIA_TYPE =  "application/json";


    @Scheduled(fixedRate = 2000)
    public void reportCurrentTime() throws IOException {

        RequestBody body = RequestBody.create(MediaType.parse(MEDIA_TYPE),"");

        Request request = new Request.Builder().url(URL+eurekaModelRegistry.getHostName()).put(body).build() ;
        client.newCall(request).execute();
    }
}