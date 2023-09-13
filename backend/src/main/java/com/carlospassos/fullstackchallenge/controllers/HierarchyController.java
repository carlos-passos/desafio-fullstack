package com.carlospassos.fullstackchallenge.controllers;

import com.carlospassos.fullstackchallenge.schemas.Hierarchy;
import com.carlospassos.fullstackchallenge.schemas.HierarchyPayload;
import com.carlospassos.fullstackchallenge.services.HierarchyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("hierarchies")
@Tag(name = "Hierarchies", description = "Hierarchies API")
@RequiredArgsConstructor
public class HierarchyController {

    private final HierarchyService hierarchyService;

    @GetMapping
    public ResponseEntity<List<Hierarchy>> findHierarchies() {
        List<Hierarchy> hierarchies = hierarchyService.findAll();
        if (hierarchies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hierarchies);
    }

    @PostMapping
    public ResponseEntity<?> saveHierarchy(@RequestBody HierarchyPayload payload) {
        hierarchyService.save(payload);
        return ResponseEntity.created(URI.create("/hierarchies")).build();
    }
}
