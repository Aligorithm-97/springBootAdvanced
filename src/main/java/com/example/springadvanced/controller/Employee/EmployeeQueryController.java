package com.example.springadvanced.controller.Employee;

import com.example.springadvanced.dto.EmployeeQueryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee/query")
public class EmployeeQueryController {
    @GetMapping("/find")
    public EmployeeQueryDto find(){
        return new EmployeeQueryDto();
    }
}
