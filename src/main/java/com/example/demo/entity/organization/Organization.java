package com.example.demo.entity.organization;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String name;

    private String logo;

    private Long owner;

    @Column(columnDefinition = "boolean default false")
    private boolean blocked;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    private Long createdBy;

    @CreatedDate
    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP default NOW()")
    private LocalDateTime createdAt;

}
