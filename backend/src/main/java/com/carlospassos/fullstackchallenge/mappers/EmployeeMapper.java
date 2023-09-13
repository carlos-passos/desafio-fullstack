package com.carlospassos.fullstackchallenge.mappers;

import com.carlospassos.fullstackchallenge.entities.EmployeeEntity;
import com.carlospassos.fullstackchallenge.schemas.Employee;
import com.carlospassos.fullstackchallenge.schemas.EmployeePayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        HierarchyMapper.class
})
public interface EmployeeMapper {

    @Mapping(target = "id", source = "employeeId")
    Employee toResponse(EmployeeEntity entity);

    List<Employee> toResponse(List<EmployeeEntity> entity);

    EmployeeEntity toEntity(EmployeePayload payload);
}
