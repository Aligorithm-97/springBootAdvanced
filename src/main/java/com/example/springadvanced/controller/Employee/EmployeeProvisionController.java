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
    private final EmployeeProvisionService service;

    @PostMapping("/add")
    public Employee add(@Valid @RequestBody EmployeeDto employeeDto){
        System.out.println(IEmployeeMapping.INSTANCE.toEmployee(employeeDto));
        return IEmployeeMapping.INSTANCE.toEmployee(employeeDto);
    }


    @DeleteMapping("/remove/{eid}")
    public void remove(@PathVariable Long eid){
        System.out.println("Kullanıcı Silindi!"+eid);
    }
}
