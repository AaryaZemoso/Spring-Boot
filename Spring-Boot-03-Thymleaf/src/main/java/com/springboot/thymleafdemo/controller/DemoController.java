package com.springboot.thymleafdemo.controller;

import com.springboot.thymleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class DemoController {

    @GetMapping("/time")
    public String getTime(Model model){
        model.addAttribute("time", LocalDateTime.now().toString());
        return "time";
    }

    @GetMapping("/employees")
    public String listEmployees(Model model){

        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "Aarya", "Devarla", "aarya@gmail.com"));
        list.add(new Employee(2, "Teja", "Dancer", "dancerteja@gmail.com"));
        list.add(new Employee(3, "Upendra", "Noob", "upendra@nob.com"));

        model.addAttribute("listEmployees", list);

        return "employee";
    }
}
