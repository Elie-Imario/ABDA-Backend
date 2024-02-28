package com.core.appbackend.playload.response;

import com.core.appbackend.beans.Inscription;
import org.springframework.http.HttpStatus;

public class InscriptionResponse {
    private Inscription inscription;
    private HttpStatus responseStatus;
        private String responseMessage;

    public InscriptionResponse(Inscription inscription, HttpStatus responseStatus) {
        this.inscription = inscription;
        this.responseStatus = responseStatus;
    }

    public InscriptionResponse(HttpStatus responseStatus, String responseMessage) {
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
    }

    public InscriptionResponse(Inscription inscription, HttpStatus responseStatus, String responseMessage) {
        this.inscription = inscription;
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
