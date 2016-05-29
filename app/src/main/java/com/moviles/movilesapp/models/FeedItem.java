package com.moviles.movilesapp.models;

/**
 * Created by Francisco on 23-May-16.
 */
public class FeedItem {

    private String name;
    private String msgTxt;
    private String timestamp;
    private String petname;


    public String getName() {
        return name;
    }

    public FeedItem() {
        name = "";
        petname = "";
        timestamp = "";
        msgTxt = "";
    }

    public FeedItem(String name, String msgTxt, String petname, String timestamp) {
        this.name = name;
        this.msgTxt = msgTxt;
        this.timestamp = timestamp;
        this.petname = petname;
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

    public String getPetname() { return petname; }

    public void setPetname(String petname) {
        this.petname = petname;
    }




}
