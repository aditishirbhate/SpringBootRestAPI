package com.aditi.springbootrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditi.springbootrestapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(String department);

}