package com.example.demo.repository.organization;

import com.example.demo.entity.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<List<Organization>> findAllByIdAndDeleted(Long id, Boolean bool);


    Optional<Organization> findById(Integer id);
}
