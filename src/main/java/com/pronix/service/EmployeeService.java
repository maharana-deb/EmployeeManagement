package com.pronix.service;

import com.pronix.entity.Employee;
import com.pronix.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(Employee Employee){
        employeeRepository.save(Employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public void updateEmployee(Long id, Employee Employee){

        Employee newEmployee = employeeRepository.findById(id).orElse(null);

        if(newEmployee != null){
            newEmployee.setName(Employee.getName());
            newEmployee.setDesignation(Employee.getDesignation());
            newEmployee.setSalary(Employee.getSalary());
            employeeRepository.save(newEmployee);
        } else {
            PrintWriter pw = new PrintWriter(System.out);
            pw.println("Invalid Id");
        }

    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

}
