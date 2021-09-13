package com.springboot.demo.service;

import com.springboot.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee e);
    void deleteById(int id);
}
