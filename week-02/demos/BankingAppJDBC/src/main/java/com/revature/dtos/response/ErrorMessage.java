package com.revature.dtos.response;

import java.util.Date;

public class ErrorMessage {

    private Date timestamp;

    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(String message) {
        this.timestamp = new Date();
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
