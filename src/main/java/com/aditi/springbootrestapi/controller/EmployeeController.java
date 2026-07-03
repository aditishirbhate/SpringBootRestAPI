package com.aditi.springbootrestapi.controller;

import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aditi.springbootrestapi.entity.Employee;
import com.aditi.springbootrestapi.service.EmployeeService;
import com.aditi.springbootrestapi.serviceimpl.EmployeeServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
@Validated

public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

        Employee employee = service.getEmployeeById(id);

        return ResponseEntity.ok(employee);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {

        return ResponseEntity.ok(service.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
    @GetMapping("/page")
    public ResponseEntity<Page<Employee>> getEmployees(

            @RequestParam(defaultValue="0") int page,

            @RequestParam(defaultValue="5") int size){

        Pageable pageable = PageRequest.of(page,size);

        return ResponseEntity.ok(service.getEmployees(pageable));

    }

}