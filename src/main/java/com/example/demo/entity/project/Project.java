package com.example.demo.entity.project;

import com.example.demo.entity.auth.AuthUser;
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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AuthUser> projectMember;

    private Long organizationId;

    @Column(columnDefinition = "boolean default false")
    private Boolean archived;

    private Long createdBy;

    @CreatedDate
    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP default NOW()")
    private LocalDateTime createdAt;

}