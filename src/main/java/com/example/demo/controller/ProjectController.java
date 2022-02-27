package com.example.demo.controller;

import com.example.demo.dto.project.ProjectDto;
import com.example.demo.entity.project.Project;
import com.example.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Saydali Murodullayev, Mon 12:30 AM. 2/28/2022
 */
@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    final
    ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProjectDto getAllAboutProject(@PathVariable Long id) {
        return service.getAllAboutProject(id);
    }
}
