package com.carlospassos.fullstackchallenge.services;

import com.carlospassos.fullstackchallenge.entities.EmployeeEntity;
import com.carlospassos.fullstackchallenge.entities.HierarchyEntity;
import com.carlospassos.fullstackchallenge.mappers.EmployeeMapper;
import com.carlospassos.fullstackchallenge.mappers.HierarchyMapper;
import com.carlospassos.fullstackchallenge.repositories.EmployeeRepository;
import com.carlospassos.fullstackchallenge.repositories.HierarchyRepository;
import com.carlospassos.fullstackchallenge.rules.EmployeeRules;
import com.carlospassos.fullstackchallenge.rules.PasswordLevelRules;
import com.carlospassos.fullstackchallenge.schemas.Employee;
import com.carlospassos.fullstackchallenge.schemas.EmployeePayload;
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
        return mapper.toResponse(repository.findAll());
    }

    public void save(HierarchyPayload hierarchyPayload) {
        repository.save(mapper.toEntity(hierarchyPayload));
    }
}
