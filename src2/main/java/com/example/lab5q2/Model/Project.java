package com.example.lab5q2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

//project Class : ID , title , description , status, companyName
@Data
@AllArgsConstructor
public class Project {

    private String id;
    private String title;
    private String description;
    private String status;
    private String companyName;

}
