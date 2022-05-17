package com.guideforwinjo.winzogoldwin.tipswinzo.Model;

public class Games {
    private int Thumbnail;
    private String Title;
    private String Url;

    public Games() {
    }

    public Games(String str, String str2, int i) {
        this.Title = str;
        this.Url = str2;
        this.Thumbnail = i;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getUrl() {
        return this.Url;
    }

    public int getThumbnail() {
        return this.Thumbnail;
    }

    public void setTitle(String str) {
        this.Title = str;
    }

    public void setUrl(String str) {
        this.Url = str;
    }

    public void setThumbnail(int i) {
        this.Thumbnail = i;
    }
}
