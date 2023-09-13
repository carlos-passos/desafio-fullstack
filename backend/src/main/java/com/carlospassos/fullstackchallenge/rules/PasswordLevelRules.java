package com.carlospassos.fullstackchallenge.rules;

import com.carlospassos.fullstackchallenge.schemas.PasswordLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordLevelRules {

    private PasswordLevel passwordLevel;

    public PasswordLevelRules process(int score) {

       for (PasswordLevel value : PasswordLevel.values()) {
            if (score <= value.getMinimumPercentage()) {
                passwordLevel = PasswordLevel.RUIM;
                break;
            }
            else if (score >= value.getMinimumPercentage()
                    && score < PasswordLevel.BOM.getMinimumPercentage()) {
                passwordLevel = PasswordLevel.MEDIANA;
                break;
            }
            else if (score >= value.getMinimumPercentage()
                    && score < PasswordLevel.FORTE.getMinimumPercentage()) {
                passwordLevel = PasswordLevel.BOM;
                break;
            }
            else if (score >= value.getMinimumPercentage()) {
                passwordLevel = PasswordLevel.FORTE;
                break;
            }
       }
        
        return this;
    }

    public PasswordLevel getPasswordLevel() {
        return passwordLevel;
    }
}
