package com.musicservicepoc.eureka;

public class EurekaModelRegistry {

    private String hostName = "music";
    private String appName =  "musicService";
    private String vipAddress =   "com.musicservicepoc";
    private String secureVipAddress =  "com.musicservicepoc";
    private String ipAddr = "127.0.0.1";
    private String status = "UP";
    private int port = 9000;
    private String healthCheckUrl = "http://localhost:9000/healthcheck";
    private String statusPageUrl = "http://localhost:9000/music/v1/";
    private String homePageUrl = "http://localhost:9000/music/v1/";
    private String dataCenterInfo = "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo";
    private String dataCenterName = "MyOwn";

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