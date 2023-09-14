package com.carlospassos.fullstackchallenge.schemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hierarchy {
    private Long id;
    private Integer level;
    private String office;
    private List<Employee> employees;
}
