package com.example.demo.entity.auth;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String email;

    private String password;

    private String picture;

    private Long organizationId;

    @OneToOne(cascade = CascadeType.ALL)
    private AuthRole role;

    @Column(columnDefinition = "boolean default false")
    private boolean blocked;

    //    @Column(columnDefinition = "NUMERIC default 0")
//    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    private Long createdBy;

    @CreatedDate
    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP default NOW()")
    private LocalDateTime createdAt;

}
