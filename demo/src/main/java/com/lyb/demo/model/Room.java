package com.lyb.demo.model;

public class Room {
    private String id;

    private String roomtype;

    private String price;

    private String status;

    private String window;

    private String bashroom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype == null ? null : roomtype.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window == null ? null : window.trim();
    }

    public String getBashroom() {
        return bashroom;
    }

    public void setBashroom(String bashroom) {
        this.bashroom = bashroom == null ? null : bashroom.trim();
    }
}