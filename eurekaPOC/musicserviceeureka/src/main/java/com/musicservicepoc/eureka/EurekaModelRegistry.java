package com.musicservicepoc.eureka;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EurekaModelRegistry {

    private String hostName = "music";
    private String appName =  "musicService";
    private String vipAddress =   "com.musicservicepoc";
    private String secureVipAddress =  "com.musicservicepoc";
    private String ipAddr = InetAddress.getLocalHost().getCanonicalHostName().toString();
    private String status = "UP";
    private int port = 9000;
    private String healthCheckUrl = "http://"+ InetAddress.getLocalHost().getHostName()+":9000/healthcheck";
    private String statusPageUrl = "http://"+ InetAddress.getLocalHost().getHostName()+":9000/music/v1/";
    private String homePageUrl = "http://"+ InetAddress.getLocalHost().getHostName()+":9000/music/v1/";
    private String dataCenterInfo = "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo";
    private String dataCenterName = "MyOwn";

    public EurekaModelRegistry() throws UnknownHostException {
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVipAddress() {
        return vipAddress;
    }

    public void setVipAddress(String vipAddress) {
        this.vipAddress = vipAddress;
    }

    public String getSecureVipAddress() {
        return secureVipAddress;
    }

    public void setSecureVipAddress(String secureVipAddress) {
        this.secureVipAddress = secureVipAddress;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHealthCheckUrl() {
        return healthCheckUrl;
    }

    public void setHealthCheckUrl(String healthCheckUrl) {
        this.healthCheckUrl = healthCheckUrl;
    }

    public String getStatusPageUrl() {
        return statusPageUrl;
    }

    public void setStatusPageUrl(String statusPageUrl) {
        this.statusPageUrl = statusPageUrl;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    public String getDataCenterInfo() {
        return dataCenterInfo;
    }

    public void setDataCenterInfo(String dataCenterInfo) {
        this.dataCenterInfo = dataCenterInfo;
    }

    public String getDataCenterName() {
        return dataCenterName;
    }

    public void setDataCenterName(String dataCenterName) {
        this.dataCenterName = dataCenterName;
    }
}
