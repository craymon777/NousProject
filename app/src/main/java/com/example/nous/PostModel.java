package com.example.nous;

import com.google.firebase.database.ServerValue;

public class PostModel {
    private String postKey, postContent, postTitle, postUser, postImg;
    private Object timeStamp ;

    public  PostModel(){}

    public PostModel(String postTitle, String postContent, String postUser, String postImg) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postUser = postUser;
        this.postImg = postImg;
        this.timeStamp = ServerValue.TIMESTAMP;
    }

    public String getPostKey() {
        return postKey;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Object getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPostUser() {
        return postUser;
    }

    public void setPostUser(String postUser) {
        this.postUser = postUser;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }
}
