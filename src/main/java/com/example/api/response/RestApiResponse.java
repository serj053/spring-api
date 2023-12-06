package com.example.api.response;

public class RestApiResponse {
    private int status;
    private String message;
    private Object data;
    public RestApiResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}