package com.uke.employeemanager.service;

import com.uke.employeemanager.exception.UserNotFoundException;
import com.uke.employeemanager.model.Employee;
import com.uke.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    // Attributes
    private final EmployeeRepository employeeRepository;

    // Constructor
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    // Method to add an employee
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);

    }

    // Method findAllEmployees() to display all employees
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    // Method updateEmployee() to update an employee
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    // Method findEmployeeById()
    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur ayant comme id: " + id + " n'a pas été trouvé"));
    }

    // Method deletEmployee() to delete an employee by id
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

}
