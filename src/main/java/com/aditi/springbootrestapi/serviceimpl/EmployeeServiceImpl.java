package com.aditi.springbootrestapi.serviceimpl;

import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.aditi.springbootrestapi.entity.Employee;
import com.aditi.springbootrestapi.exception.ResourceNotFoundException;
import com.aditi.springbootrestapi.repository.EmployeeRepository;
import com.aditi.springbootrestapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    @Cacheable("employees")
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

        Employee employee = getEmployeeById(id);

        repository.delete(employee);

    }
    
	@Override
	public Page<Employee> getEmployees(Pageable pageable) {
	    return repository.findAll(pageable);
	}
}