package com.carlospassos.fullstackchallenge.rules;

import com.carlospassos.fullstackchallenge.entities.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class EmployeeRules {

    private final EmployeeScore employeeScore;
    private EmployeeEntity employeeEntity;
    public EmployeeRules process(EmployeeEntity toEntity) {
        if (toEntity == null) {
            throw new RuntimeException();
        }

        employeeEntity = toEntity;

        employeeScore.init();

        verifyNumberOfCharacters();
        verifyUpperCaseLetters();
        verifyLowerCaseLetters();
        verifyNumbers();
        verifySimbols();
        verifyMiddleNumbersOfSimbols();
        verifyRequirements();

        employeeEntity.setScore(employeeScore.getScore());
        employeeEntity.setPassword(encrypt(employeeEntity.getPassword()));

        return this;
    }

    private String encrypt(String password) {
        if (StringUtils.isBlank(password))
            throw new RuntimeException();
        return new BCryptPasswordEncoder().encode(password);
    }

    public EmployeeEntity getEmployee() {
        return employeeEntity;
    }

    private void verifyNumberOfCharacters() {
        if (StringUtils.isNotBlank(employeeEntity.getPassword())
         && employeeEntity.getPassword().length() < 8) {

            employeeScore.replace();
        }

    }

    private void verifyUpperCaseLetters() {
        Pattern pattern = Pattern.compile("[A-Z]");
        if (!pattern.matcher(employeeEntity.getPassword()).find())
            employeeScore.replace();
    }

    private void verifyLowerCaseLetters() {
        Pattern pattern = Pattern.compile("[a-z]");
        if (!pattern.matcher(employeeEntity.getPassword()).find())
            employeeScore.replace();
    }

    private void verifyNumbers() {
        Pattern pattern = Pattern.compile("[0-9]");
        if (!pattern.matcher(employeeEntity.getPassword()).find())
            employeeScore.replace();
    }

    private void verifySimbols() {
        Pattern pattern = Pattern.compile("[~!@#$%^&*()_+{}\\[\\]:;,.<>/?-]");
        if (!pattern.matcher(employeeEntity.getPassword()).find())
            employeeScore.replace();
    }

    private void verifyMiddleNumbersOfSimbols() {
        Pattern pattern = Pattern.compile("[~!@#$%^&*()_+{}\\[\\]:;,.<>/?-]{2,}");
        if (!pattern.matcher(employeeEntity.getPassword()).find())
            employeeScore.replace();
    }

    private void verifyRequirements() {
        if (employeeScore.getScore() < 100)
            employeeScore.replace();
    }
}
