package com.example.demo.services;

import com.example.demo.dto.task.TaskCreateDto;
import com.example.demo.entity.column.PColumn;
import com.example.demo.entity.task.Task;
import com.example.demo.entity.task.enums.Level;
import com.example.demo.entity.task.enums.TaskPriority;
import com.example.demo.repository.task.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author Saydali Murodullayev, Sun 6:49 PM. 2/27/2022
 */

@Service
public record TaskService(TaskRepository repository,
                          PColumnService columnService) {

    public Long addTask(Long id, Long userId, TaskCreateDto taskCreateDto) {
        PColumn pColumn = columnService.getColumnByColumnId(id);

        Task task = getTaskByCreateDto(taskCreateDto, userId);
        setOrderToTask(task, pColumn);
        task = repository.save(task);

        List<Task> tasks = pColumn.getTasks();
        tasks.add(task);
        pColumn.setTasks(tasks);
        columnService.saveColumn(pColumn);
        return task.getId();
    }


    private void setOrderToTask(Task task, PColumn pColumn) {
        List<Task> tasks = pColumn.getTasks();
        if (tasks.size() > 1) {
            tasks.sort(Comparator.comparing(Task::getTaskOrder));
            Task latestTask = tasks.get(tasks.size() - 1);
            if (Objects.nonNull(latestTask.getTaskOrder())) {
                task.setTaskOrder(latestTask.getTaskOrder() + 1);
            } else {
                task.setTaskOrder((int) (Math.random() * (-10)));
            }
        } else {
            task.setTaskOrder(1);
        }
    }


    private Task getTaskByCreateDto(TaskCreateDto taskCreateDto, Long userId) {
        String level = taskCreateDto.getLevel();
        String priority = taskCreateDto.getPriority();

        Level levelByName = Level.getLevelByName(level);
        TaskPriority priorityByName = TaskPriority.getPriorityByName(priority);

        Task task = new Task();
        task.setTitle(taskCreateDto.getTitle());
        task.setDescription(taskCreateDto.getDescription());
        task.setLevel(levelByName);
        task.setPriority(priorityByName);
        task.setCreatedBy(userId);

        return task;
    }

}
