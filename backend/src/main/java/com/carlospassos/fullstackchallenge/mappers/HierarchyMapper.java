package com.carlospassos.fullstackchallenge.mappers;

import com.carlospassos.fullstackchallenge.entities.HierarchyEntity;
import com.carlospassos.fullstackchallenge.schemas.Hierarchy;
import com.carlospassos.fullstackchallenge.schemas.HierarchyPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HierarchyMapper {
    @Mapping(target = "id", source = "hierarchyId")
    Hierarchy toResponse(HierarchyEntity entity);

    List<Hierarchy> toResponse(List<HierarchyEntity> entity);

    HierarchyEntity toEntity(HierarchyPayload payload);
}
