package com.springboot.demo.controller;

import com.springboot.demo.entity.Employee;
import com.springboot.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class DemoController {

    private EmployeeService employeeService;

    public DemoController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){

        List<Employee> list = employeeService.findAll();
        model.addAttribute("listEmployees", list);
        return "employee/employee-list";
    }

    @GetMapping("/addForm")
    public String addEmployeeForm(Model model){

        model.addAttribute("employee", new Employee());
        return "employee/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("employeeId") int id, Model model){

        Employee e = employeeService.findById(id);
        model.addAttribute("employee", e);
        return "employee/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employee/list";
    }
}
