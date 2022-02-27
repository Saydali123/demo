package com.example.demo.dto.project;

import com.example.demo.entity.auth.AuthUser;
import com.example.demo.entity.column.PColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Saydali Murodullayev, Mon 12:50 AM. 2/28/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    protected Long id;

    private String name;

    private String description;

    private LocalDateTime createdAt;

    private List<AuthUser> projectMember;

    private List<PColumn> columns;


}
