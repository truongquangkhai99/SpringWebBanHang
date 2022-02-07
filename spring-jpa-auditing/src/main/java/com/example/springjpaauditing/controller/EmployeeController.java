package com.example.springjpaauditing.controller;

import com.example.springjpaauditing.dto.InputRequest;
import com.example.springjpaauditing.model.Employee;
import com.example.springjpaauditing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public String saveEmployee(@RequestBody InputRequest<Employee> request) {
        return service.saveEmployee(request);
    }

    @PutMapping("/updateEmployee/{id}/{salary}")
    public String updateEmployeeSalary(@PathVariable int id, @PathVariable double salary,
                                       @RequestBody InputRequest<Employee> request) {
        return service.updateEmployee(id, salary, request);
    }
}
