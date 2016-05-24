package com.moviles.movilesapp.models;

/**
 * Created by Francisco on 23-May-16.
 */
public class FeedItem {

    private String name;
    private String msgTxt;

    public FeedItem() {}

    public FeedItem(String name, String msgTxt) {
        this.name = name;
        this.msgTxt = msgTxt;
    }

    public String getName() {
        return name;
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
}
