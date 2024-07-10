package dev.obbie.employee_manager.service;

import dev.obbie.employee_manager.Exception.UserNotFoundException;
import dev.obbie.employee_manager.model.Employee;
import dev.obbie.employee_manager.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
      return employeeRepository.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return  employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository
                .findEmployeeById(id)
                .orElseThrow(()->
                        new UserNotFoundException("User with id "+id+ " was not found"));
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
