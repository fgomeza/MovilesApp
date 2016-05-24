package com.moviles.movilesapp.models;

/**
 * Created by Francisco on 23-May-16.
 */
public class FeedItem {

    private String name;
    private String msgTxt;
    private String timestamp;

    public FeedItem() {}

    public String getName() {
        return name;
    }

    public FeedItem(String name, String msgTxt, String timestamp) {
        this.name = name;
        this.msgTxt = msgTxt;
        this.timestamp = timestamp;
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
}
