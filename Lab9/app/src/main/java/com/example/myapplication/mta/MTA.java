package com.example.myapplication.mta;

import android.graphics.Bitmap;

public class MTA {

    private Bitmap image;
    private String title;

    public MTA(Bitmap image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
