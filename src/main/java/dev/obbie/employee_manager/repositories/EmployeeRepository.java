package dev.obbie.employee_manager.repositories;

import dev.obbie.employee_manager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

    Employee updateEmployeeById(Long id);

}
