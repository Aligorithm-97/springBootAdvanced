package com.example.springadvanced.dto;

import com.example.springadvanced.validation.NotStartWith;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class EmployeeDto {
    private String name;
    private String surname;
    @NotStartWith({"http","https"})
    private String userName;
    private String password;
    private Integer weight;
    private Integer height;
    private List<String> hobby;
    @NotStartWith({"http","https"})
    private String department;

}
