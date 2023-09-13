package com.carlospassos.fullstackchallenge.schemas;

import com.carlospassos.fullstackchallenge.entities.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hierarchy {
    private Long id;
    private Integer level;
    private String office;
}
