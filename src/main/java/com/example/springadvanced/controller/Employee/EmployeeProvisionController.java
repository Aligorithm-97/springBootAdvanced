package com.example.springadvanced.controller.Employee;

import com.example.springadvanced.dto.EmployeeDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee/provision")
public class EmployeeProvisionController {

    @PostMapping("/add")
    public String add(@Valid @RequestBody EmployeeDto employeeDto){
        System.out.println("Kullanıcı Eklendi!");
        return "OK";
    }

    @DeleteMapping("/remove/{eid}")
    public void remove(@PathVariable Long eid){
        System.out.println("Kullanıcı Silindi!"+eid);
    }
}
