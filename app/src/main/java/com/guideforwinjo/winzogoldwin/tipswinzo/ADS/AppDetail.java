package com.guideforwinjo.winzogoldwin.tipswinzo.ADS;

public class AppDetail {

    public String app_icon;
    public String app_name;
    public String app_url;

    public AppDetail(String app_icon, String app_name, String app_url) {
        this.app_icon = app_icon;
        this.app_name = app_name;
        this.app_url = app_url;
    }

    public String getApp_icon() {
        return app_icon;
    }

    public void setApp_icon(String app_icon) {
        this.app_icon = app_icon;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_url() {
        return app_url;
    }

    public void setApp_url(String app_url) {
        this.app_url = app_url;
    }
}
