package com.example.demo.entity.column;

import com.example.demo.entity.task.Task;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class PColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String name;

    private Integer columnOrder;

    private Long projectId;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    private Long createdBy;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Task> tasks;

    @CreatedDate
    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP default NOW()")
    private LocalDateTime createdAt;
}
