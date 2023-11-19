package com.example.springadvanced.dao.customer;
import com.example.springadvanced.dao.customer.data.IEmployeeDao;
import com.example.springadvanced.log.LogManager;
import com.example.springadvanced.models.EEmployeeStatus;
import com.example.springadvanced.models.Employee;
import com.example.springadvanced.models.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeDataManager {
    private final IEmployeeDao employeeDao;
    private final LogManager logManager;

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = {IllegalStateException.class},
            isolation = Isolation.READ_COMMITTED)
    // start transaction
    public void insert(Employee empParam) {
        logManager.insertLog("inserting : " + empParam);
        Set<Phone> phonesLoc = empParam.getPhones();
        if (phonesLoc != null) {
            for (Phone phoneLoc : phonesLoc) {
                phoneLoc.setCustomer(empParam);
            }
        }
        empParam.setEmpUid(UUID.randomUUID()
                .toString());
        employeeDao.save(empParam);
    } // commit

    public void updateStatus(final EEmployeeStatus eEmployeeStatus,
                             final String cuidParam) {
        employeeDao.updateStatus(eEmployeeStatus,
                cuidParam);
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }


}