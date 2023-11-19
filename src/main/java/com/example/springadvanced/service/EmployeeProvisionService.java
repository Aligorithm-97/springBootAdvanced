package com.example.springadvanced.service;

import com.example.springadvanced.dao.customer.EmployeeDataManager;
import com.example.springadvanced.dto.EmployeeDto;
import com.example.springadvanced.mapping.IEmployeeMapping;
import com.example.springadvanced.models.EEmployeeStatus;
import com.example.springadvanced.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeProvisionService {

    private final EmployeeDataManager employeeDataManager;

    public String addCustomer(Employee employeeParam){
        employeeDataManager.insert(employeeParam);
        return employeeParam.getEmpUid();
    }

    public void suspend(final String cuidParam) {
        employeeDataManager.updateStatus(EEmployeeStatus.SUSPENDED,cuidParam);
    }
}
