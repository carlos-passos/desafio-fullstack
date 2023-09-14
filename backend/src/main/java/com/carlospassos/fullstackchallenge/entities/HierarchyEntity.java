package com.carlospassos.fullstackchallenge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "TB_HIERARCHY")
public class HierarchyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hierarchyId;

    private Integer level;

    private String office;

}
