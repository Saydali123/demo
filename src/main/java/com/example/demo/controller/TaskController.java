package com.example.demo.controller;

import com.example.demo.dto.task.TaskCreateDto;
import com.example.demo.services.TaskService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Saydali Murodullayev, Sun 6:48 PM. 2/27/2022
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    final
    TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{columnId}/{userId}", method = RequestMethod.POST)
    public String addTask(@RequestBody TaskCreateDto taskCreateDto, @PathVariable("columnId") Long id, @PathVariable Long userId) {
        Long task = service.addTask(id, userId, taskCreateDto);
        return task.toString();
    }

}
