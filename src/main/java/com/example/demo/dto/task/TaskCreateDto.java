package com.example.demo.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.ldap.PagedResultsControl;

/**
 * @author Saydali Murodullayev, Sun 6:50 PM. 2/27/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateDto {

    private String title;
    private String description;
    private String level;
    private String priority;
}
