package com.example.demo.repository.auth;

import com.example.demo.entity.auth.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AuthRoleRepository extends JpaRepository<AuthRole, Long> {
}
