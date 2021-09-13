package com.springboot.app.rest;

import com.springboot.app.dao.EmployeeDAO;
import com.springboot.app.entity.Employee;
import com.springboot.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee e = employeeService.findById(employeeId);
        if(e == null)
            throw new RuntimeException("Employee id not found - " + employeeId);
        return e;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee e){
        e.setId(0);
        employeeService.save(e);
        return e;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee e){
        employeeService.save(e);
        return e;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee e = employeeService.findById(employeeId);

        if(e == null)
            throw new RuntimeException("Employee doesn't exist");

        employeeService.deleteById(employeeId);
        return "Deleted Employee with id - " + employeeId;
    }
}
