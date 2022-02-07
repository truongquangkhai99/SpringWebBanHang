package com.example.springjpaauditing.dao;

import com.example.springjpaauditing.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
