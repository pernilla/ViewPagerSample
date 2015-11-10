package com.appease.viewpagersample;

/**
 * Created by pernilla on 10/11/15.
 */
public class Item {

    private String header;
    private int imageResourceId;

    public Item(String header, int imageResourceId) {
        this.header = header;
        this.imageResourceId = imageResourceId;
    }

    public String getHeader() {
        return header;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
