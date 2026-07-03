package com.aditi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditi.springbootrestapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{


}
