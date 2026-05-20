package com.example.controller;

import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

}
