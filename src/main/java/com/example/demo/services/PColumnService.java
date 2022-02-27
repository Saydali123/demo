package com.example.demo.services;

import com.example.demo.dto.pColumn.PColumnCreateDto;
import com.example.demo.entity.column.PColumn;
import com.example.demo.repository.column.PColumnRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        return listColumns.orElse(null);
    }

    public Long addColumn(Long id, Long userId, @NotNull PColumnCreateDto pColumnCreateDto) {
        Optional<PColumn> topByProjectIdOrderByColumnOrderDesc = repository.findTopByProjectIdAndDeletedOrderByColumnOrderDesc(id, false);

        PColumn pColumn = new PColumn();
        pColumn.setProjectId(id);
        pColumn.setCreatedBy(userId);
        pColumn.setName(pColumnCreateDto.getName());

        if (topByProjectIdOrderByColumnOrderDesc.isPresent()) {
            PColumn latestColumn = topByProjectIdOrderByColumnOrderDesc.get();
            if (Objects.nonNull(latestColumn.getColumnOrder()))
                pColumn.setColumnOrder(latestColumn.getColumnOrder() + 1);
            else {
                pColumn.setColumnOrder((int) (Math.random() * 10) + 1);
            }
        } else
            pColumn.setColumnOrder(1);
        PColumn save = repository.save(pColumn);
        return save.getId();
    }

    public PColumn getColumnByColumnId(Long id) {
        Optional<PColumn> byId = repository.findById(id);
        return byId.orElse(null);
    }

    public void saveColumn(PColumn pColumn) {
        repository.save(pColumn);
    }
}
