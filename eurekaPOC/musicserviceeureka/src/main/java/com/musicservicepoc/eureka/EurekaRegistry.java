package com.musicservicepoc.eureka;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.UnknownHostException;

@Component
public class EurekaRegistry implements ApplicationListener<ApplicationReadyEvent> {

    private EurekaModelRegistry eurekaModelRegistry;
    private WebApplicationContext webApplicationContext;
    private OkHttpClient client;
    private final String url = "http://localhost:8080/eureka/v2/apps/";

    public EurekaRegistry(EurekaModelRegistry eurekaModelRegistry, WebApplicationContext webApplicationContext, OkHttpClient okHttpClient) {
        this.eurekaModelRegistry = eurekaModelRegistry;
        this.webApplicationContext = webApplicationContext;
        this.client = okHttpClient;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            registerApp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerApp() throws IOException {

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),"" +
                "{\"instance\": {" +
                "   \"hostName\": \""+ eurekaModelRegistry.getHostName() +"\"," +
                "   \"app\": \""+ eurekaModelRegistry.getAppName()+"\"," +
                "   \"vipAddress\": \""+ eurekaModelRegistry.getVipAddress()+"\"," +
                "   \"secureVipAddress\": \""+ eurekaModelRegistry.getSecureVipAddress()+"\"," +
                "   \"ipAddr\": \""+ eurekaModelRegistry.getIpAddr()+"\"," +
                "   \"status\": \""+ eurekaModelRegistry.getStatus()+"\"," +
                "   \"port\": {\"$\": \""+ getPort() +"\", \"@enabled\": \"true\"}," +
                "   \"healthCheckUrl\": \""+ createHealthUrl()+ "\"," +
                "   \"statusPageUrl\": \""+ createHealthUrl()+ "\"," +
                "   \"homePageUrl\": \""+ createHealthUrl()+ "\"," +
                "   \"dataCenterInfo\": {" +
                "       \"@class\": \""+ eurekaModelRegistry.getDataCenterInfo()+"\"," +
                "       \"name\": \""+ eurekaModelRegistry.getDataCenterName()+"\"" +
                " }}}") ;

        Request request2 = new Request.Builder().url(url+ eurekaModelRegistry.getAppName()).post(body).build() ;
        client.newCall(request2).execute() ;
    }

    private String createHealthUrl(){
        return "http://"+eurekaModelRegistry.getIpAddr()+":"+getPort()+"/health";

    }

    private int getPort(){
        return ((AnnotationConfigEmbeddedWebApplicationContext) webApplicationContext).getEmbeddedServletContainer().getPort();
    }


}

