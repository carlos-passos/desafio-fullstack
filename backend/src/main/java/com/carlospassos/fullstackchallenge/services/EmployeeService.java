package com.carlospassos.fullstackchallenge.services;

import com.carlospassos.fullstackchallenge.entities.EmployeeEntity;
import com.carlospassos.fullstackchallenge.entities.HierarchyEntity;
import com.carlospassos.fullstackchallenge.mappers.EmployeeMapper;
import com.carlospassos.fullstackchallenge.repositories.EmployeeRepository;
import com.carlospassos.fullstackchallenge.repositories.HierarchyRepository;
import com.carlospassos.fullstackchallenge.rules.EmployeeRules;
import com.carlospassos.fullstackchallenge.rules.PasswordLevelRules;
import com.carlospassos.fullstackchallenge.schemas.Employee;
import com.carlospassos.fullstackchallenge.schemas.EmployeePayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final HierarchyRepository hierarchyRepository;

    private final EmployeeRules employeeRules;
    private final PasswordLevelRules passwordLevelRules;
    private final EmployeeMapper mapper;

    public List<Employee> findAll() {
        return mapper.toResponse(employeeRepository.findAll());
    }

    public void save(EmployeePayload employeePayload) {

        EmployeeEntity employeeEntity = mapper.toEntity(employeePayload);

        employeeEntity.setSuperiorEmployeeId(employeePayload.getSuperiorEmployeeId());

        employeeEntity.setHierarchy(
                hierarchyRepository.findById(employeePayload.getHierarchyId())
                        .orElseThrow(() -> new RuntimeException())
        );

        employeeEntity = employeeRules.process(employeeEntity).getEmployee();

        employeeEntity.setPasswordLevel(
                passwordLevelRules.process(employeeEntity.getScore()).getPasswordLevel()
        );

        employeeRepository.save(employeeEntity);
    }

    public List<Employee> findHierarchiesBySuperiorEmployee(Long hierarchyId) {

        HierarchyEntity hierarchy = hierarchyRepository.findById(hierarchyId)
                .orElseThrow(() -> new RuntimeException());

        return mapper.toResponse(employeeRepository
                .findByHierarchyLevelGreaterThan(hierarchy.getLevel()));
    }

    public List<Employee> findSuperiorEmployee(Long superiorEmployeeId) {

        return mapper.toResponse(employeeRepository
                .findBySuperiorEmployeeId(superiorEmployeeId));
    }
}
