package com.creditsaison.omni.mediaDotNet.model;

import com.creditsaison.omni.mediaDotNet.enums.EventMemberStatus;

public class EventMembers {

    private String id;

    private String username;

    private EventMemberStatus eventMemberStatus;

    public EventMembers(String id, String username) {
        this.id = id;
        this.username = username;
        this.eventMemberStatus = EventMemberStatus.NONE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EventMemberStatus getEventMemberStatus() {
        return eventMemberStatus;
    }

    public void setEventMemberStatus(EventMemberStatus eventMemberStatus) {
        this.eventMemberStatus = eventMemberStatus;
    }
}
