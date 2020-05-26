package com.example.consult.entity;

import java.util.Date;

public class Comment {

    private int id;
    private int userID;
    private int acticleID;
    private Date createdTime;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getActicleID() {
        return acticleID;
    }

    public void setActicleID(int acticleID) {
        this.acticleID = acticleID;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
