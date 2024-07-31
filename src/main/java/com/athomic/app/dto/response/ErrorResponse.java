package com.athomic.app.dto.response;

public class ErrorResponse {

    private int status;
    private String error;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String reasonPhrase, String message) {
        this.status = status;
        this.error = reasonPhrase;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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