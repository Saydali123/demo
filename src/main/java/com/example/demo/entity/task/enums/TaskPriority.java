package com.example.demo.entity.task.enums;

import lombok.Getter;

/**
 * @author Saydali Murodullayev, Sun 6:55 PM. 2/27/2022
 */
@Getter
public enum TaskPriority {
    HIGH,
    MEDIUM,
    LOW;

    public static TaskPriority getPriorityByName(String string) {
        for (TaskPriority value : values()) {
            if (value.name().equalsIgnoreCase(string))
                return value;
        }
        return MEDIUM;
    }

}
