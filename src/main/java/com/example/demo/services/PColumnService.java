package com.example.demo.services;

import com.example.demo.entity.column.PColumn;
import com.example.demo.repository.column.PColumnRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Saydali Murodullayev, Sun 7:25 AM. 2/27/2022
 */
@Service
public class PColumnService {

    final
    PColumnRepository repository;

    public PColumnService(PColumnRepository repository) {
        this.repository = repository;
    }

    public List<PColumn> getAllByProjectId(Long id) {
        Optional<List<PColumn>> listColumns = repository.findAllByProjectIdAndDeleted(id, false);

        if (listColumns.isPresent()) {
            List<PColumn> pColumns = listColumns.get();
            return pColumns;
        }
        return null;

    }
}
