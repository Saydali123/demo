package com.example.demo.entity.auth;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class AuthRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AuthPermission> permission;
}
