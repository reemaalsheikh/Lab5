package com.example.lab5q3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

//event Class : ID , description , capacity, startDate , endDate
@Data
@AllArgsConstructor
public class Event {

    private String id;
    private String description;
    private int capacity;
    private Date startDate;
    private Date endDate;



    // ( use @JsonFormat(pattern="yyyy-MM-dd") and LocalDateTime )
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime startDate;
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime endDate;


}
