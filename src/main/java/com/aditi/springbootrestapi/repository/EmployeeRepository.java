package com.aditi.springbootrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aditi.springbootrestapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    @Query("SELECT e FROM Employee e WHERE e.department=?1")
    List<Employee> findByDepartment(String department);

}