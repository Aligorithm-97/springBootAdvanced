package com.example.springadvanced.controller.Employee;

import com.example.springadvanced.dto.EmployeeDto;
import com.example.springadvanced.mapping.IEmployeeMapping;
import com.example.springadvanced.models.Employee;
import com.example.springadvanced.service.EmployeeProvisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee/provision")
@RequiredArgsConstructor
public class EmployeeProvisionController {
    private final EmployeeProvisionService cs;

    @PostMapping("/add")
    public String add(@Valid @RequestBody EmployeeDto employeeDto) {
        return cs.addCustomer(IEmployeeMapping.INSTANCE.toEmployee(employeeDto));
    }

    @PostMapping("/suspend")
    public String suspend(@RequestParam String cuid) {
        cs.suspend(cuid);
        return "OK";
    }
}
