package com.carlospassos.fullstackchallenge.repositories;

import com.carlospassos.fullstackchallenge.entities.EmployeeEntity;
import com.carlospassos.fullstackchallenge.entities.HierarchyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findByHierarchyLevelGreaterThan(Integer level);

    List<EmployeeEntity> findBySuperiorEmployeeId(Long superiorEmployeeId);
}
