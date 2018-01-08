package com.musicservicepoc.eureka;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

@Component
public class EurekaModelRegistry {

    private final String hostName = "music"+getRandomNumber();
    private String appName =  "musicservice";
    private String vipAddress =   "com.musicservicepoc";
    private String secureVipAddress =  "com.musicservicepoc";
    private String ipAddr = findIp();
    private final String status = "UP";
    private final String dataCenterInfo = "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo";
    private final String dataCenterName = "MyOwn";

    public EurekaModelRegistry() throws IOException {

    }

    public String getHostName() {
        return hostName;
    }

    public String getAppName() {
        return appName;
    }

    public String getVipAddress() {
        return vipAddress;
    }

    public String getSecureVipAddress() {
        return secureVipAddress;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public String getStatus() {
        return status;
    }

    public String getDataCenterInfo() {
        return dataCenterInfo;
    }

    public String getDataCenterName() {
        return dataCenterName;
    }

    private String getRandomNumber(){
        Random rand = new Random();
        return String.valueOf(rand.nextInt(100));
    }

    private String findIp() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("google.com", 80));
        String ip = String.valueOf(socket.getLocalAddress()).substring(1);
        socket.close();
        return ip;
    }
}
