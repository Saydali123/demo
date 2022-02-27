package com.example.demo.services;

import com.example.demo.dto.project.ProjectDto;
import com.example.demo.entity.column.PColumn;
import com.example.demo.entity.project.Project;
import com.example.demo.repository.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Saydali Murodullayev, Mon 12:32 AM. 2/28/2022
 */
@Service
public class ProjectService {
    final
    ProjectRepository repository;

    final
    PColumnService columnService;

    public ProjectService(ProjectRepository repository, PColumnService columnService) {
        this.repository = repository;
        this.columnService = columnService;
    }

    public ProjectDto getAllAboutProject(Long id) {
        Optional<Project> byId = repository.findById(id);
        if (byId.isPresent()) {
            ProjectDto projectDto = getProjectDto(byId.get());
            List<PColumn> allByProjectId = columnService.getAllByProjectId(id);
            projectDto.setColumns(allByProjectId);
            return projectDto;
        }
        return null;
    }

    private ProjectDto getProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName(projectDto.getName());
        projectDto.setId(projectDto.getId());
        projectDto.setDescription(project.getDescription());
        projectDto.setCreatedAt(project.getCreatedAt());
        return projectDto;
    }
}
