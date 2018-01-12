package com.musicservicepoc.healthcheck;

import com.musicservicepoc.eureka.EurekaModelRegistry;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.UnknownHostException;

@Component
public class ScheduledTasks {

    @Autowired
    EurekaModelRegistry eurekaModelRegistry;

    @Autowired
    OkHttpClient client;

    private final String url = "http://localhost:8080/eureka/v2/apps/musicservice/";

    public ScheduledTasks() throws UnknownHostException {
    }

    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() throws IOException {

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),"");

        Request request = new Request.Builder().url(url+eurekaModelRegistry.getHostName()).put(body).build() ;
        client.newCall(request).execute();


    }
}
