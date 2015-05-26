package com.ibcs.primax.javaee.model;

import java.util.Date;

/**
 * @author Abdullah Al Mamun Oronno
 *         Created on 5/5/15
 */
public class Message {
    private String text;
    private User user;
    private Date sentTime;

    public Message() {
    }

    public Message(String text, User user, Date sentTime) {
        this.text = text;
        this.user = user;
        this.sentTime = sentTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }
}
