package com.creditsaison.omni.mediaDotNet.service;

import com.creditsaison.omni.mediaDotNet.model.Event;
import com.creditsaison.omni.mediaDotNet.model.EventMembers;
import com.creditsaison.omni.mediaDotNet.pojos.EventInfo;
import com.creditsaison.omni.mediaDotNet.pojos.EventPojo;
import com.creditsaison.omni.mediaDotNet.repository.EventDao;
import com.creditsaison.omni.mediaDotNet.repository.EventMembersDao;

import java.util.List;

public class EventService {

    private EventDao eventDao;

    private EventMembersDao eventMembersDao;

    public EventService() {
        eventDao = new EventDao();
        eventMembersDao = new EventMembersDao();
    }

    public Event createEvent(EventPojo eventPojo){
        Event event = new Event(eventPojo.getTitle(), eventPojo.getMeta(), eventPojo.getStartTime(), eventPojo.getEndTime(), eventPojo.getOwnerId());
        List<EventMembers> eventMembersList = eventPojo.getEventMembers();
        Event persistedEvent = eventDao.save(event);
        for (EventMembers eventMember: eventMembersList){
            eventMember.setId(persistedEvent.getId());
        }
        eventMembersDao.saveAll(eventMembersList);
        return persistedEvent;
    }

    public boolean updateEvent(EventPojo eventPojo){
        Event event = new Event(eventPojo.getTitle(), eventPojo.getMeta(), eventPojo.getStartTime(), eventPojo.getEndTime(), eventPojo.getOwnerId());
        event.setId(eventPojo.getId());
        List<EventMembers> eventMembersList = eventPojo.getEventMembers();
        for(EventMembers eventMember: eventMembersList){
            eventMembersDao.upsert(eventMember);
        }
        return eventDao.update(event);
    }

    public boolean delete(String id){
        return eventDao.del(id);
    }

    public EventInfo getEventInfo(String id){
        EventPojo eventPojo = null;
        Event event = eventDao.getEvent(id);
        List<EventMembers> eventMembers = eventMembersDao.getByEventId(id);
        return new EventInfo(event, eventMembers);
    }



}
