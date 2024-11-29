package com.example.baitapcanhan;

public class Task {
    private String title;
    private String sellerInfo;
    private int imageResource;
    private String progress;

    public Task(String title, String sellerInfo, int imageResource, String progress) {
        this.title = title;
        this.sellerInfo = sellerInfo;
        this.imageResource = imageResource;
        this.progress = progress;
    }

    public String getTitle() {
        return title;
    }

    public String getSellerInfo() {
        return sellerInfo;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getProgress() {
        return progress;
    }
}
