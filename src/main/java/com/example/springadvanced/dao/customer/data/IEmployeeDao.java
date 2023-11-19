package com.example.springadvanced.dao.customer.data;

import com.example.springadvanced.models.EEmployeeStatus;
import com.example.springadvanced.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeeDao extends JpaRepository<Employee,Long> {
    @Modifying
    @Transactional
    @Query("update Employee c set c.employeeStatus=?1 where c.empUid=?2")
    void updateStatus(EEmployeeStatus customerStatusParam,
                      String cuid);

    @Modifying
    @Transactional
    @Query("update Employee c set c.employeeStatus=:cstatus where c.empUid=:cuid")
    void updateStatus2(@Param("cstatus") EEmployeeStatus customerStatusParam,
                       @Param("cuid") String cuid);

}
