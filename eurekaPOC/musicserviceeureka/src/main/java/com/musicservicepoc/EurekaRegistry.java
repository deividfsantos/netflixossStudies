package com.musicservicepoc;

import okhttp3.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EurekaRegistry implements ApplicationListener<ApplicationReadyEvent> {

    private String hostName = "music";
    private String appName =  "musicService";
    private String vipAddress =   "com.musicservicepoc";
    private String secureVipAddress =  "com.musicservicepoc";
    private String ipAddr = "127.0.0.1";
    private String status = "UP";
    private int port = 9000;
    private String healthCheckUrl = "http://localhost:9000/music/v1/";
    private String statusPageUrl = "http://localhost:9000/music/v1/";
    private String homePageUrl = "http://localhost:9000/music/v1/";
    private String dataCenterInfo = "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo";
    private String dataCenterName = "MyOwn";

    OkHttpClient client = new OkHttpClient();

    public void registry() throws IOException {

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),"" +
                "{\"instance\": {" +
                "   \"hostName\": \""+hostName+"\"," +
                "   \"app\": \""+appName+"\"," +
                "   \"vipAddress\": \""+vipAddress+"\"," +
                "   \"secureVipAddress\": \""+secureVipAddress+"\"," +
                "   \"ipAddr\": \""+ipAddr+"\"," +
                "   \"status\": \""+status+"\"," +
                "   \"port\": {\"$\": \""+port+"\", \"@enabled\": \"true\"}," +
                "   \"healthCheckUrl\": \""+healthCheckUrl+"\"," +
                "   \"statusPageUrl\": \""+statusPageUrl+"\"," +
                "   \"homePageUrl\": \""+homePageUrl+"\"," +
                "   \"dataCenterInfo\": {" +
                "       \"@class\": \""+dataCenterInfo+"\"," +
                "       \"name\": \""+dataCenterName+"\"" +
                " }}}") ;

        Request request2 = new Request.Builder().url("http://localhost:8080/eureka/v2/apps/"+appName).post(body).build() ;
        client.newCall(request2).execute() ;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            registry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
