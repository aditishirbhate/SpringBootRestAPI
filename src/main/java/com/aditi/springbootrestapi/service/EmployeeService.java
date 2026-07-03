package com.aditi.springbootrestapi.service;

import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import com.aditi.springbootrestapi.entity.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
    
    Page<Employee> getEmployees(Pageable pageable);

}