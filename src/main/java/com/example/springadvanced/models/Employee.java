package com.example.springadvanced.models;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class Employee {
    private String    name;
    private String    surName;
    private String    userName;
    private String    password;
    private Integer   weight;
    private Integer   height;
    private List<String> hobby;
    private String department;
}