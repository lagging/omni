package com.creditsaison.omni.mediaDotNet.pojos;

import com.creditsaison.omni.mediaDotNet.model.EventMembers;

import java.util.List;
import java.util.UUID;

public class EventPojo {


    private String id;

    private String title;

    private String meta;

    private long startTime;

    private long endTime;

    private List<EventMembers> eventMembers;

    private String ownerId;

    public EventPojo(String title, String meta, long startTime, long endTime, List<EventMembers> eventMembers, String ownerId) {
        this.title = title;
        this.meta = meta;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventMembers = eventMembers;
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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

    public List<EventMembers> getEventMembers() {
        return eventMembers;
    }

    public void setEventMembers(List<EventMembers> eventMembers) {
        this.eventMembers = eventMembers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
