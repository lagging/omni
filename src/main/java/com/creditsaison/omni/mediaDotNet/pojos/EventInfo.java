package com.creditsaison.omni.mediaDotNet.pojos;

import com.creditsaison.omni.mediaDotNet.model.Event;
import com.creditsaison.omni.mediaDotNet.model.EventMembers;

import java.util.List;

public class EventInfo {

    private Event event;

    private List<EventMembers> eventMembers;

    public EventInfo(Event event, List<EventMembers> eventMembers) {
        this.event = event;
        this.eventMembers = eventMembers;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<EventMembers> getEventMembers() {
        return eventMembers;
    }

    public void setEventMembers(List<EventMembers> eventMembers) {
        this.eventMembers = eventMembers;
    }
}
