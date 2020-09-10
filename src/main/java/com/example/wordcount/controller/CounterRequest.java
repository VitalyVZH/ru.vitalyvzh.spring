package com.example.wordcount.controller;

import java.io.Serializable;

public class CounterRequest implements Serializable {

    private Long idRequest;
    private String text;

    public CounterRequest(Long idRequest, String text) {
        this.idRequest = idRequest;
        this.text = text;
    }

    public Long getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Long idRequest) {
        this.idRequest = idRequest;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
