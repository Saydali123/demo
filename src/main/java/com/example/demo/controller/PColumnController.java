package com.example.demo.controller;

import com.example.demo.entity.column.PColumn;
import com.example.demo.services.PColumnService;
import org.hibernate.mapping.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Saydali Murodullayev, Sun 7:25 AM. 2/27/2022
 */
@RestController
@RequestMapping("/controller/*")
public class PColumnController {

    final
    PColumnService service;

    public PColumnController(PColumnService service) {
        this.service = service;
    }

    @RequestMapping(value = "projectId/{id}", method = RequestMethod.GET)
    public List<PColumn> byProjectId(@PathVariable Long id) {
        return service.getAllByProjectId(id);
    }

}
