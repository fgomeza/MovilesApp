package com.moviles.movilesapp.models;

/**
 * Created by Francisco on 23-May-16.
 */
public class FeedItem {

    private String name;
    private String msgTxt;
    private String timestamp;
    private String petName;
    private String imageUrl;



    private String address;

    public String getName() {
        return name;
    }

    public FeedItem() {
        this("", "", "", "", "", "");
    }

    public FeedItem(String name, String msgTxt, String petName, String timestamp, String imageUrl, String address) {
        this.name = name;
        this.msgTxt = msgTxt;
        this.timestamp = timestamp;
        this.petName = petName;
        this.imageUrl = imageUrl;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsgTxt() {
        return msgTxt;
    }

    public void setMsgTxt(String msgTxt) {
        this.msgTxt = msgTxt;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPetName() { return petName; }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }
}
