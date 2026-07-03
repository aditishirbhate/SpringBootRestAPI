package com.aditi.springbootrestapi.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aditi.springbootrestapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	List<Employee> findByDepartment(String department);
}