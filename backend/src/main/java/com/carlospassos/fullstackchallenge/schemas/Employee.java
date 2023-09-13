package com.carlospassos.fullstackchallenge.schemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    private Long id;

    private String name;

    private String image;

    private Integer score;

    private PasswordLevel passwordLevel;

    private Hierarchy hierarchy;

    private Employee superiorEmployee;
}
