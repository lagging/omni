package com.creditsaison.omni.mediaDotNet;


import com.creditsaison.omni.mediaDotNet.model.Event;
import com.creditsaison.omni.mediaDotNet.model.EventMembers;
import com.creditsaison.omni.mediaDotNet.pojos.EventInfo;
import com.creditsaison.omni.mediaDotNet.pojos.EventPojo;
import com.creditsaison.omni.mediaDotNet.service.EventService;

import java.util.ArrayList;
import java.util.List;

//Build a Calendar application. It should support the following features -
//        - Ability to Create, Update, Delete an Event (CRUD operations)
//        An event would typically consist of {start, end, location, owner, user-list, title}
//        Update event, like, add more users, change time, etc.
//        An event once created, can be either accepted or rejected by the constituent users - if neither it should be in neutral state.
//        - Get Calendar for a user Ui for a given time duration.
//        - Get Event details.
//        - For a given set of users (U1...Un) identify a common free slot of time for a given time duration.
public class Driver {

    public static void main(String[] args){

        EventService eventService = new EventService();
        List<EventMembers> eventMembersList = new ArrayList<>();
        EventMembers eventMember1 = new EventMembers("1", "ashish.rathore");
        eventMembersList.add(eventMember1);
        EventPojo eventPojo = new EventPojo("sample title", "sample meta", 12723023l, 12823023l, eventMembersList, "12345");

        //create event
        Event createdEvent = eventService.createEvent(eventPojo);

        EventInfo eventInfo = eventService.getEventInfo(createdEvent.getId());

        eventPojo.setId(createdEvent.getId());
        eventPojo.setStartTime(12623023l);
        eventPojo.setEventMembers(new ArrayList<>());
        //update event
        eventService.updateEvent(eventPojo);

        //delete event
        eventService.delete(eventPojo.getId());


    }

}
