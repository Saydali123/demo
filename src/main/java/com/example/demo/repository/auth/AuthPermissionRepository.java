package com.example.demo.repository.auth;

import com.example.demo.entity.auth.AuthPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AuthPermissionRepository extends JpaRepository<AuthPermission, Long> {

}
