package com.carlospassos.fullstackchallenge.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(SpringExtension.class)
class EmployeeScoreTest {

    @InjectMocks
    private EmployeeScore employeeScore;

    @BeforeEach
    void init() {
        ReflectionTestUtils.setField(employeeScore, "initialPercent", 100);
        ReflectionTestUtils.setField(employeeScore, "initialRules", 7);
    }


    @Test
    void replace() {
        employeeScore.replace();
        System.out.println(employeeScore.getScore());
    }

}