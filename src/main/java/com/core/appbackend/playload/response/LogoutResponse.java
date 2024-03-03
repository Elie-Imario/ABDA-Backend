package com.core.appbackend.playload.response;

import org.springframework.http.HttpStatus;

public class LogoutResponse {
    private HttpStatus httpStatus;
    private String responseMessage;


    public LogoutResponse(HttpStatus httpStatus, String responseMessage) {
        this.httpStatus = httpStatus;
        this.responseMessage = responseMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
