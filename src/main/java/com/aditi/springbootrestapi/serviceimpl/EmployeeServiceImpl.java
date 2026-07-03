package com.aditi.springbootrestapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditi.repository.EmployeeRepository;
import com.aditi.service.EmployeeService;
import com.aditi.springbootrestapi.entity.Employee;
import com.aditi.springbootrestapi.exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee emp=getEmployeeById(id);

        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setDepartment(employee.getDepartment());
        emp.setSalary(employee.getSalary());

        return repository.save(emp);

    }

    @Override
    public void deleteEmployee(Long id) {

        Employee emp=getEmployeeById(id);

        repository.delete(emp);

    }

}