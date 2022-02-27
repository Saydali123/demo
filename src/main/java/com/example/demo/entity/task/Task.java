package com.example.demo.entity.task;

import com.example.demo.entity.auth.AuthUser;
import com.example.demo.entity.task.enums.Level;
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
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String title;

    private String description;

    private Integer taskOrder;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<AuthUser> taskMembers;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "NUMERIC default 1")
    private Level level;

    @Column(columnDefinition = "boolean default false")
    private boolean archived;

    private Long createdBy;

    @CreatedDate
    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP default NOW()")
    private LocalDateTime createdAt;

}
