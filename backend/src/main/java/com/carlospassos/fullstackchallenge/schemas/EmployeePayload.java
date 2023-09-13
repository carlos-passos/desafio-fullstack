package com.carlospassos.fullstackchallenge.schemas;

import lombok.Data;

@Data
public class EmployeePayload {

    private String name;

    private String password;

    private String image;

    private Long hierarchyId;

    private Long superiorEmployeeId;

}
