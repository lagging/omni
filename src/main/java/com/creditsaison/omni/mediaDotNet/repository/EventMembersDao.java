package com.creditsaison.omni.mediaDotNet.repository;

import com.creditsaison.omni.mediaDotNet.model.EventMembers;

import java.util.ArrayList;
import java.util.List;

public class EventMembersDao {

    List<EventMembers> eventMembersList;

    public EventMembersDao() {
        this.eventMembersList = new ArrayList<>();
    }

    public List<EventMembers> getByEventId(String eventId){
        List<EventMembers> eventMembers = new ArrayList<>();
        for (EventMembers eventMember: eventMembersList){
            if (eventMember.getId().equals(eventId)){
                eventMembers.add(eventMember);
            }
        }
        return eventMembers;
    }

    public EventMembers save(EventMembers eventMembers){
        eventMembersList.add(eventMembers);
        return eventMembers;
    }

    public List<EventMembers> saveAll(List<EventMembers> eventMembers){
        eventMembersList.addAll(eventMembers);
        return eventMembersList;
    }

    public List<EventMembers> upsert(EventMembers eventMember){
        boolean isPresent = false;
        for (EventMembers eventMembers: eventMembersList){
            if(eventMembers.getId().equals(eventMember.getId())){
                isPresent = true;
            }
        }
        if (!isPresent){
            eventMembersList.add(eventMember);
        }
        return eventMembersList;
    }


}
