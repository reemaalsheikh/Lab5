package com.example.lab5q2.Controller;

import com.example.lab5q2.Api.ApiResponse;
import com.example.lab5q2.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

@RequestMapping("/api/v1/project")
public class ProjectController {
ArrayList<Project> projects = new ArrayList<>();

// Create (add) a new project (ID,title , description , status, companyName)
    @PostMapping("/add")
    public ApiResponse CreateProject (@RequestBody Project project){
        projects.add(project);
        return new ApiResponse("Project successfully Created!");
    }
//• Display all project .
@GetMapping("/get/projects")
public ArrayList<Project> getProjects() {
    return projects;
}
//• Update a project
    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@PathVariable int index, @RequestBody Project project){
        projects.set(index, project);
        return new ApiResponse("Project successfully Updated!");
    }
//• Delete a project
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index){
        projects.remove(index);
        return new ApiResponse("Project successfully Deleted!");
    }
//• Change(update)the project status as done or not done
@PutMapping("/update/status/{index}/{status}")
    public ApiResponse changeProject(@PathVariable int index, @PathVariable String status){
        if (index >= 0 && index < projects.size()){
            Project project = projects.get(index);
        if(status.equalsIgnoreCase("Done") || status.equalsIgnoreCase("Not Done")){
            project.setStatus("Done");
            return new ApiResponse("Task status successfuly updated!");        }
        }
        return new ApiResponse("Project not found at index:"+index);

    }

//• Search for a project by given title
    @GetMapping("/searchproj/{title}")
    public Project getProjectBytitle(@PathVariable String title){
        for (Project project : projects) {
            if(project.getTitle().equalsIgnoreCase(title)){
                return project;
            }
        }
        return null;
    }
//• Display All project for one company by companyName.
    @GetMapping("/pcn/{companyName}")
public ArrayList<Project> getProjectsByCN (@PathVariable String companyName) {
        ArrayList<Project> projectbycompanyname = new ArrayList<>();
        for (Project project : projects) {
            if(project.getCompanyName().equalsIgnoreCase(companyName)){
                projectbycompanyname.add(project);
            }
        }
      return projectbycompanyname;
    }


    //  for (Project project : projects) {
//      if(project.getCompanyName().equalsIgnoreCase(companyName)){
//          return project;
//      }
//  }

}
