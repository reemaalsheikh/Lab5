package com.example.lab5q3.Controller;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.example.lab5q3.Api.ApiRessponse;
import com.example.lab5q3.Model.Event;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventConroller {


    ArrayList <Event> events = new ArrayList<>();
//• Create (add) a new event (ID , description , capacity, startDate , endDate)
    @PostMapping("/add")
public ApiRessponse CreateEvent( @RequestBody Event event){
    events.add(event);
    return new ApiRessponse("Event successfully Created!");
}

//• Display all event .

    @GetMapping("/get/events")
    public ArrayList <Event> getEvents() {
        return events;
    }
//• Update a event
    @PutMapping("/update/{index}")
    public ApiRessponse updateEvent(@PathVariable int index, @RequestBody Event event){
        events.set(index, event);
        return new ApiRessponse("Event successfully Updated!");
    }
//• Delete a event
    @DeleteMapping("/delete/{index}")
    public ApiRessponse deleteEvent(@PathVariable int index){
        events.remove(index);
        return new ApiRessponse("Event successfully Deleted!");
    }

//• Change capacity
    @PutMapping("/ucapacity/{index}/{capacity}")
    public ApiRessponse changeCapacity (@PathVariable int index, @PathVariable int capacity){
        events.get(index).setCapacity(capacity);
     return new ApiRessponse("Event capacity successfully Updated!");

    }
//• Search for a event by given id
    @GetMapping("/getbyid/{id}")
    public Event getEventById( @PathVariable String id){
        for(Event e : events){
            if (e.getId().equalsIgnoreCase(id)){
                return e;
            }
        }
        return null;
    }


}
