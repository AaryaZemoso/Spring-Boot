package com.springboot.app.service;

import com.springboot.app.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee e);
    void deleteById(int id);
}
