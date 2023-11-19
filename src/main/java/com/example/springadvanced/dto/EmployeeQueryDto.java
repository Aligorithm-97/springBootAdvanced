package com.example.springadvanced.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class EmployeeQueryDto {
    private String name;
    private String surname;
    private Integer weight;
    private Integer height;
    private String department;
}
