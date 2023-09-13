package com.carlospassos.fullstackchallenge.services;

import com.carlospassos.fullstackchallenge.entities.EmployeeEntity;
import com.carlospassos.fullstackchallenge.entities.HierarchyEntity;
import com.carlospassos.fullstackchallenge.mappers.EmployeeMapper;
import com.carlospassos.fullstackchallenge.repositories.EmployeeRepository;
import com.carlospassos.fullstackchallenge.repositories.HierarchyRepository;
import com.carlospassos.fullstackchallenge.rules.EmployeeRules;
import com.carlospassos.fullstackchallenge.rules.PasswordLevelRules;
import com.carlospassos.fullstackchallenge.schemas.EmployeePayload;
import com.carlospassos.fullstackchallenge.schemas.PasswordLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private HierarchyRepository hierarchyRepository;
    @Mock
    private EmployeeRules employeeRules;
    @Mock
    private PasswordLevelRules passwordLevelRules;
    @Mock
    private EmployeeMapper mapper;
    @InjectMocks
    private EmployeeService employeeService;


    @Test
    void save() {

        EmployeePayload employeePayload = new EmployeePayload();
        employeePayload.setName("Steve Jobs");
        employeePayload.setPassword("1A2345678");
        employeePayload.setHierarchyId(1L);

        HierarchyEntity hierarchyEntity = new HierarchyEntity();
        hierarchyEntity.setHierarchyId(1L);
        hierarchyEntity.setLevel(1);
        hierarchyEntity.setOffice("Analista");

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("Steve Jobs");
        employeeEntity.setPassword("1A2345678");
        employeeEntity.setHierarchy(hierarchyEntity);
        employeeEntity.setSuperiorEmployeeId(1L);

//        doReturn(employeeEntity).when(mapper).toEntity(any());
//        doReturn(Optional.of(hierarchyEntity)).when(hierarchyRepository).findById(anyLong());
//        doReturn(mock(PasswordLevel.class)).when(passwordLevelRules).process(anyInt()).getPasswordLevel();
//        doReturn(employeeEntity).when(employeeRules).process(any()).getEmployee();
//        doReturn(employeeEntity).when(employeeRepository).save(any());
//
//        employeeService.save(employeePayload);
    }
}