package com.carlospassos.fullstackchallenge.rules;

import com.carlospassos.fullstackchallenge.schemas.PasswordLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class PasswordLevelRulesTest {

    @InjectMocks
    private PasswordLevelRules rulesMock;

    @Test
    void whenProcessRules_thenRuim() {
        PasswordLevel passwordLevel =
                rulesMock.process(12).getPasswordLevel();
        Assertions.assertEquals(PasswordLevel.RUIM.getLevel(),
                passwordLevel.getLevel());
    }

    @Test
    void whenProcessRules_thenMediana() {
        PasswordLevel passwordLevel =
                rulesMock.process(37).getPasswordLevel();
        Assertions.assertEquals(PasswordLevel.MEDIANA.getLevel(),
                passwordLevel.getLevel());
    }

    @Test
    void whenProcessRules_thenBom() {
        PasswordLevel passwordLevel =
                rulesMock.process(74).getPasswordLevel();
        Assertions.assertEquals(PasswordLevel.BOM.getLevel(),
                passwordLevel.getLevel());
    }

    @Test
    void whenProcessRules_thenForte() {
        PasswordLevel passwordLevel =
                rulesMock.process(91).getPasswordLevel();
        Assertions.assertEquals(PasswordLevel.FORTE.getLevel(),
                passwordLevel.getLevel());
    }
}