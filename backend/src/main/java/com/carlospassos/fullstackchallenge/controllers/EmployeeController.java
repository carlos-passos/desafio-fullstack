package com.carlospassos.fullstackchallenge.controllers;

import com.carlospassos.fullstackchallenge.schemas.Employee;
import com.carlospassos.fullstackchallenge.schemas.EmployeePayload;
import com.carlospassos.fullstackchallenge.services.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("employees")
@Tag(name = "Employees", description = "Employees API")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> findEmployees() {
        List<Employee> employees = service.findAll();
        if (employees.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/hierarchies/superior-employees/{superiorEmployeeId}")
    public ResponseEntity<List<Employee>> findSuperiorEmployee(@PathVariable Long superiorEmployeeId) {
        List<Employee> employees = service.findSuperiorEmployee(superiorEmployeeId);
        if (employees.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/superior-employees/hierarchies/{hierarchyId}")
    public ResponseEntity<List<Employee>> findHierarchiesBySuperiorEmployee(@PathVariable Long hierarchyId) {
        List<Employee> employees = service.findHierarchiesBySuperiorEmployee(hierarchyId);
        if (employees.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeePayload payload) {
        service.save(payload);
        return ResponseEntity.created(URI.create("/employees")).build();
    }
}
