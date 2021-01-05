package com.example.nous;

import com.google.firebase.database.ServerValue;

public class CommentModel {

    private String username, comment;
    Object commentDate;

    public CommentModel(){}

    public CommentModel(String username, String comment) {
        this.username = username;
        this.comment = comment;
        this.commentDate = ServerValue.TIMESTAMP;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Object getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Object commentDate) {
        this.commentDate = commentDate;
    }
}
