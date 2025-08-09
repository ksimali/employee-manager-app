package com.uke.employeemanager.repository;

import com.uke.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom delete method - Spring Data JPA will implement it based on method name
    //void deleteEmployeeById(Long id);

    // Custom find method returning an Optional<Employee>
    Optional<Employee> findEmployeeById(Long id);
}
