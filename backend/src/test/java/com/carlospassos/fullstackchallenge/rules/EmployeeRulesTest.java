package com.carlospassos.fullstackchallenge.rules;

import com.carlospassos.fullstackchallenge.entities.EmployeeEntity;
import com.carlospassos.fullstackchallenge.entities.HierarchyEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class EmployeeRulesTest {

    @Mock
    private EmployeeScore employeeScore;
    @InjectMocks
    private EmployeeRules rulesMock;


    @Test
    void whenProcessRules_thenOnSuccess() {

        HierarchyEntity hierarchyEntity = mock(HierarchyEntity.class);

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("Steve Jobs");
        employeeEntity.setPassword("1A2345678");
        employeeEntity.setHierarchy(hierarchyEntity);

        doNothing().when(employeeScore).replace();

        rulesMock.process(employeeEntity).getEmployee();

    }

    @Test
    void whenVerifyCaseRules_thenOnSuccess() {
        boolean patternMatches = Pattern.matches("[a-zA-Z0-9]{8,}", "KaduKad99");
        System.out.println(patternMatches);

        Pattern pattern = Pattern.compile("[~!@#$%^&*()_+{}\\[\\]:;,.<>/?-]{3,}");
        boolean patternMatches2 = pattern.matcher("Ka*)^uKad99").find();
        System.out.println(patternMatches2);
    }
}