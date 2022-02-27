package com.example.demo.controller;

import com.example.demo.dto.pColumn.PColumnCreateDto;
import com.example.demo.entity.column.PColumn;
import com.example.demo.services.PColumnService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Saydali Murodullayev, Sun 7:25 AM. 2/27/2022
 */
@RestController
@RequestMapping("/pColumn")
public class PColumnController {

    final
    PColumnService service;

    public PColumnController(PColumnService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public List<PColumn> getAllByProjectId(@PathVariable("projectId") Long id) {
        return service.getAllByProjectId(id);
    }

    @RequestMapping(value = "/{projectId}/{userId}", method = RequestMethod.POST)
    public String addColumn(@RequestBody PColumnCreateDto pColumnCreateDto, @PathVariable("projectId") Long id, @PathVariable Long userId) {
        Long ColumnId = service.addColumn(id, userId, pColumnCreateDto);
        return ColumnId.toString();
    }

}
