package com.aditi.springbootrestapi.service;

import java.util.List;

import com.aditi.springbootrestapi.entity.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

	List<Employee> getEmployeesByDepartment(String department);

}