package com.example.springadvanced.service;

import com.example.springadvanced.dto.EmployeeDto;
import com.example.springadvanced.mapping.IEmployeeMapping;
import com.example.springadvanced.models.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProvisionService {

    public Employee addEmployee (EmployeeDto employeeDto){
        return IEmployeeMapping.INSTANCE.toEmployee(employeeDto);
    }
}
