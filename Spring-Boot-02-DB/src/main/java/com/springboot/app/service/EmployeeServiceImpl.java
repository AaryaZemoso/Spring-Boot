package com.springboot.app.service;

import com.springboot.app.dao.EmployeeDAO;
import com.springboot.app.dao.EmployeeRepository;
import com.springboot.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // Old Style
    // private EmployeeDAO employeeDAO;

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository e){
        employeeRepository = e;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new RuntimeException("Did not find Employee id - " + id);
        }
    }

    @Override
    @Transactional
    public void save(Employee e) {
        employeeRepository.save(e);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
