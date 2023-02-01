package com.creditsaison.omni.mediaDotNet.repository;

import com.creditsaison.omni.mediaDotNet.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventDao {


    List<Event> events;

    public EventDao() {
        this.events = new ArrayList<>();
    }

//    public EventDao getInstance(){
//
//    }

    public Event save(Event event){
        events.add(event);
        return event;
    }

    public Event getEvent(String id){
        Event event = null;
        for (Event ev: events){
            if (ev.isActive() && ev.getId().equals(id)){
                event = ev;
                break;
            }
        }
        return event;
    }

    public boolean update(Event event){
        for (Event ev: events){
            if (ev.isActive() && ev.getId().equals(event.getId())){
                ev.setMeta(event.getMeta());
                ev.setEndTime(event.getEndTime());
                ev.setStartTime(event.getStartTime());
                ev.setEndTime(event.getEndTime());
                return true;
            }
        }
        return false;
    }

    public boolean del(String id){
        for (Event ev: events){
            if (ev.isActive() && ev.getId().equals(id)){
                ev.setActive(false);
                return true;
            }
        }
        return false;
    }



}
