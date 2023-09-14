package com.carlospassos.fullstackchallenge.entities;

import com.carlospassos.fullstackchallenge.schemas.PasswordLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "TB_EMPLOYEE")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;

    private String password;

    private String image;

    private Integer score;

    @Enumerated(value = EnumType.STRING)
    private PasswordLevel passwordLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HIERARCHY_ID")
    private HierarchyEntity hierarchy;

    private Long superiorEmployeeId;
}
