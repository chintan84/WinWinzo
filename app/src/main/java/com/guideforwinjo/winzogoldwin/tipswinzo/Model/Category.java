package com.guideforwinjo.winzogoldwin.tipswinzo.Model;

public class Category {
    String title;
    int imageicon;
    int backImage;

    public Category(String title, int imageicon, int backImage) {
        this.title = title;
        this.imageicon = imageicon;
        this.backImage = backImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageicon() {
        return imageicon;
    }

    public void setImageicon(int imageicon) {
        this.imageicon = imageicon;
    }

    public int getBackImage() {
        return backImage;
    }

    public void setBackImage(int backImage) {
        this.backImage = backImage;
    }
}
