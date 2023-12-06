package com.example.api.response;
//полноценный объект отвечающий за обработку исключения
public class RestApiResponse {
    private int status;
    private String message;
    private Object data;

    public RestApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public RestApiResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
