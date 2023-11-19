package com.example.springadvanced.models;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue
    private Long               employeeId;
    @Column(name = "cuid", nullable = false, unique = true)
    @NotEmpty
    private String              empUid;
    private String    firstName;
    private String    lastName;
    private String    userName;
    private String    password;
    private Integer   weight;
    private Integer   height;
    private String department;
    @Enumerated(EnumType.STRING)
    private EEmployeeStatus     employeeStatus = EEmployeeStatus.ACTIVE;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
    private Set<Phone> phones;
}