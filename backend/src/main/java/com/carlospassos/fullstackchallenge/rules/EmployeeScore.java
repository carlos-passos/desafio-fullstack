package com.carlospassos.fullstackchallenge.rules;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmployeeScore {

    @Value("${employee.score.initial.percent}")
    private Integer initialPercent;
    @Value("${employee.score.initial.rules}")
    private Integer initialRules;

    private Integer rules;

    private Integer score;

    public void init() {
        rules = 0;
        score = 0;
    }
    public void replace() {
        if (rules == 0)
            rules = initialRules;
        rules--;
        score = rules * initialPercent / initialRules;
    }

    public Integer getScore() {
        if (score == 0)
            score = initialPercent;
        return score;
    }
}
