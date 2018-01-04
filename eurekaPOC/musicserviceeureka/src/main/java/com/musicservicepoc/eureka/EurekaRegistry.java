package com.musicservicepoc.eureka;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EurekaRegistry implements ApplicationListener<ApplicationReadyEvent> {

    EurekaModelRegistry eurekaModelRegistry = new EurekaModelRegistry();
    OkHttpClient client = new OkHttpClient();

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            registry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registry() throws IOException {

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),"" +
                "{\"instance\": {" +
                "   \"hostName\": \""+ eurekaModelRegistry.getHostName()+"\"," +
                "   \"app\": \""+ eurekaModelRegistry.getAppName()+"\"," +
                "   \"vipAddress\": \""+ eurekaModelRegistry.getVipAddress()+"\"," +
                "   \"secureVipAddress\": \""+ eurekaModelRegistry.getSecureVipAddress()+"\"," +
                "   \"ipAddr\": \""+ eurekaModelRegistry.getIpAddr()+"\"," +
                "   \"status\": \""+ eurekaModelRegistry.getStatus()+"\"," +
                "   \"port\": {\"$\": \""+ eurekaModelRegistry.getPort()+"\", \"@enabled\": \"true\"}," +
                "   \"healthCheckUrl\": \""+ eurekaModelRegistry.getHealthCheckUrl()+"\"," +
                "   \"statusPageUrl\": \""+ eurekaModelRegistry.getStatusPageUrl()+"\"," +
                "   \"homePageUrl\": \""+ eurekaModelRegistry.getHomePageUrl()+"\"," +
                "   \"dataCenterInfo\": {" +
                "       \"@class\": \""+ eurekaModelRegistry.getDataCenterInfo()+"\"," +
                "       \"name\": \""+ eurekaModelRegistry.getDataCenterName()+"\"" +
                " }}}") ;


        Request request2 = new Request.Builder().url("http://localhost:8080/eureka/v2/apps/"+ eurekaModelRegistry.getAppName()).post(body).build() ;
        client.newCall(request2).execute() ;
    }


}
