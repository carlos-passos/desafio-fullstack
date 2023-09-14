package com.carlospassos.fullstackchallenge.services;

import com.carlospassos.fullstackchallenge.mappers.HierarchyMapper;
import com.carlospassos.fullstackchallenge.repositories.HierarchyRepository;
import com.carlospassos.fullstackchallenge.schemas.Hierarchy;
import com.carlospassos.fullstackchallenge.schemas.HierarchyPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HierarchyService {

    private final HierarchyRepository repository;
    private final HierarchyMapper mapper;

    public List<Hierarchy> findAll() {
        return mapper.toResponses(repository.findAll());
    }

    public void save(HierarchyPayload hierarchyPayload) {
        repository.save(mapper.toEntity(hierarchyPayload));
    }
}
