package com.carlospassos.fullstackchallenge.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "TB_HIERARCHY")
public class HierarchyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hierarchyId;

    private Integer level;

    private String office;

}
