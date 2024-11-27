package com.pronix.controller;

import com.pronix.entity.Employee;
import com.pronix.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getallemployees")
    public List<Employee> getAllProducts(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getemployee/{id}")
    public Employee getProductById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/saveemployee")
    public void saveProduct(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/updateemployee/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Employee product){
        employeeService.updateEmployee(id, product);
    }

    @DeleteMapping("/deleteemployee/{id}")
    public void deleteProductById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }

}
