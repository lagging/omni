package com.creditsaison.omni.mediaDotNet.model;

import java.util.UUID;

public class Event {

    private String id;

    private String title;

    private String meta;

    private long startTime;

    private long endTime;

    private boolean isActive;

    private String ownerId;

    public Event(String title, String meta, long startTime, long endTime, String ownerId) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.meta = meta;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isActive = true;
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
