package com.example.demo.repository.column;

import com.example.demo.entity.column.PColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PColumnRepository extends JpaRepository<PColumn, Long> {

    Optional<List<PColumn>> findAllByProjectIdAndDeleted(Long id, Boolean boo);

    Optional<PColumn> findTopByProjectIdOrderByColumnOrderDesc(Long projectId);
}
