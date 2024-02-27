package com.core.appbackend.playload.model;

public class RevisionDetail {
    private String type;
    private int total;

    public RevisionDetail() {
    }

    public RevisionDetail(String type, int total) {
        this.type = type;
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
