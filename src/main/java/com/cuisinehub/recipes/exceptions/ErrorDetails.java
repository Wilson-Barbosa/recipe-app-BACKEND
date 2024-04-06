package com.cuisinehub.recipes.exceptions;

import java.time.Instant;

public class ErrorDetails {

    private Instant time;
    private String message;
    private String error;

    public ErrorDetails() {
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    

}
