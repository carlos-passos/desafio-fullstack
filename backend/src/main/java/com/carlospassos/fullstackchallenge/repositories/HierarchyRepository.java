package com.carlospassos.fullstackchallenge.repositories;

import com.carlospassos.fullstackchallenge.entities.HierarchyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HierarchyRepository extends JpaRepository<HierarchyEntity, Long> {
}
